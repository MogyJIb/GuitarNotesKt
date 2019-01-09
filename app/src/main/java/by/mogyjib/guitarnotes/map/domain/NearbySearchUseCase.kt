package by.mogyjib.guitarnotes.map.domain

import android.location.Location
import by.mogyjib.guitarnotes.map.data.models.PlaceBasicDTO
import by.mogyjib.guitarnotes.map.data.repository.IPlacesRepository
import by.mogyjib.guitarnotes.utils.extentions.async
import io.reactivex.Observable

class NearbySearchUseCase(
        private val key: String,
        private val placesRepository: IPlacesRepository
) {
    fun nearbyPlacesAsync(
            location: Location,
            radius: Int = 15000,
            type: String = "atm"
    ): Observable<List<PlaceBasicDTO>>
            = placesRepository.nearbyPlaces(key, location.toStr(), radius, type).async()

    private fun Location.toStr() = "${this.latitude},${this.longitude}"
}