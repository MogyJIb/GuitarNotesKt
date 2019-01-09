package by.mogyjib.guitarnotes.map.data.repository

import by.mogyjib.guitarnotes.map.data.models.PlaceBasicDTO
import by.mogyjib.guitarnotes.map.data.remote.PlacesService
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject


class PlacesRepository(
        private val placesService: PlacesService
) : IPlacesRepository {
    override fun nearbyPlaces(
            key: String,
            location: String,
            radius: Int,
            type: String
    ): Observable<List<PlaceBasicDTO>> {
        val tokenControl: BehaviorSubject<String?> = BehaviorSubject.createDefault("default")
        return tokenControl.concatMap { token ->
            val tokenToSend = if (token != "default") token else null
            return@concatMap placesService.nearbySearch(key, type, radius, type, tokenToSend)
                    .doOnNext { searchResult ->
                        searchResult.nextToken?.let { tokenControl.onNext(it) }
                                ?: tokenControl.onComplete()
                    }
                    .flatMap { searchResult ->
                        Observable.fromCallable { searchResult.places }
                    }
        }
    }
}