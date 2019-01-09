package by.mogyjib.guitarnotes.map.data.repository

import by.mogyjib.guitarnotes.map.data.models.PlaceBasicDTO
import io.reactivex.Observable


interface IPlacesRepository {
    fun nearbyPlaces(
            key: String,
            location: String,
            radius: Int,
            type: String
    ): Observable<List<PlaceBasicDTO>>
}