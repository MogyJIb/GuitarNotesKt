package by.mogyjib.guitarnotes.map.presentation

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BaseFragment
import by.mogyjib.guitarnotes.map.data.models.PlaceBasicDTO
import by.mogyjib.guitarnotes.utils.extentions.isPermissionGranted
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.android.ext.android.inject


class MapFragment : BaseFragment(), MapContract.View {

    override val presenter: MapContract.Presenter by inject()
    private var googleMap: GoogleMap? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = layoutInflater.inflate(R.layout.fragment_map, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.support_map_fragment) as SupportMapFragment
        mapFragment.getMapAsync { map ->
            googleMap = map
            activity?.isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION) {
                googleMap?.isMyLocationEnabled = true
            }
        }

    }

    override fun onResume() {
        super.onResume()
        activity?.isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION) {
            presenter.startLocationUpdates(LocationServices.getFusedLocationProviderClient(activity!!))
        }
    }

    override fun onPause() {
        super.onPause()
        activity?.isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION) {
            presenter.stopLocationUpdates()
        }
    }

    override fun addPlaces(places: List<PlaceBasicDTO>) {
        for (place in places)
            googleMap?.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .snippet("Id: ${place.placeId}")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                    .position(LatLng(place.latitude, place.longitude))
                    .alpha(0.8f)
                    .flat(true))
    }

    override fun updateCurrentLocationMarker(latitude: Double, longitude: Double) {
        val latLng = LatLng(latitude, longitude)

        googleMap?.addMarker(
             MarkerOptions()
                .position(latLng)
                .title(getString(R.string.current_position_title))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )

        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(latLng))
    }
}