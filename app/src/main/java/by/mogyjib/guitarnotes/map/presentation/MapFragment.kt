package by.mogyjib.guitarnotes.map.presentation

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.base.view.BaseFragment
import by.mogyjib.guitarnotes.utils.extentions.isPermissionGranted
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment

class MapFragment : BaseFragment() {
    private var googleMap: GoogleMap? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = layoutInflater.inflate(R.layout.fragment_map, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager.findFragmentById(R.id.support_map_fragment) as SupportMapFragment
        mapFragment.getMapAsync { map -> setUpMap(map) }
    }

    private fun setUpMap(map: GoogleMap) {
        googleMap = map

        activity?.isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION) {
            googleMap?.isMyLocationEnabled = true
        }
    }
}