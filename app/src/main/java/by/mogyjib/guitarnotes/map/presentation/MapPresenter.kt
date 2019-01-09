package by.mogyjib.guitarnotes.map.presentation

import by.mogyjib.guitarnotes.base.view.BasePresenter
import by.mogyjib.guitarnotes.map.domain.LocationHandler
import by.mogyjib.guitarnotes.map.domain.NearbySearchUseCase
import by.mogyjib.guitarnotes.utils.extentions.async
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationResult
import io.reactivex.rxkotlin.plusAssign


const val UPDATE_INTERVAL = 5000

class MapPresenter(
        private val locationHandler: LocationHandler,
        private val nearbySearchUseCase: NearbySearchUseCase
) : BasePresenter<MapContract.View>(), MapContract.Presenter {
    override fun startLocationUpdates(fusedLocationClient: FusedLocationProviderClient) {
        locationHandler.startLocationUpdates(fusedLocationClient,
                object : LocationCallback() {
                    override fun onLocationResult(result: LocationResult?) {
                        result?.lastLocation ?: return

                        disposables += nearbySearchUseCase.nearbyPlacesAsync(result.lastLocation)
                                .subscribe { places -> view?.addPlaces(places) }
                    }
                })
    }

    override fun stopLocationUpdates() = locationHandler.stopLocationUpdates()
}