package by.mogyjib.guitarnotes.map.domain

import android.os.Looper
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest

const val UPDATE_INTERVAL: Long = 20000

class LocationHandler {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback

    fun startLocationUpdates(
            fusedLocationClient: FusedLocationProviderClient,
            locationCallback: LocationCallback
    ) {
        this.fusedLocationClient = fusedLocationClient
        this.locationCallback = locationCallback

        fusedLocationClient.requestLocationUpdates(
                LocationRequest()
                        .setInterval(UPDATE_INTERVAL)
                        .setFastestInterval(UPDATE_INTERVAL)
                        .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY),
                locationCallback,
                Looper.myLooper())
    }

    fun stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }
}