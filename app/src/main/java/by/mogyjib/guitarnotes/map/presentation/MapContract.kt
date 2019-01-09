package by.mogyjib.guitarnotes.map.presentation

import by.mogyjib.guitarnotes.base.view.BaseContract
import by.mogyjib.guitarnotes.map.data.models.PlaceBasicDTO
import com.google.android.gms.location.FusedLocationProviderClient

interface MapContract {
    interface View : BaseContract.View {
        fun addPlaces(places: List<PlaceBasicDTO>)
        fun updateCurrentLocationMarker(latitude: Double, longitude: Double)
    }

    interface Presenter : BaseContract.Presenter {
        fun startLocationUpdates(fusedLocationClient: FusedLocationProviderClient)
        fun stopLocationUpdates()
    }
}