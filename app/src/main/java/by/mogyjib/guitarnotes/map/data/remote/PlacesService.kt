package by.mogyjib.guitarnotes.map.data.remote

import by.mogyjib.guitarnotes.map.data.models.NearbyResultDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PlacesService {

    @GET("nearbysearch/json")
    fun nearbySearch(
            @Query("key") key: String,
            @Query("location") location: String,
            @Query("radius") radius: Int,
            @Query("type") type: String,
            @Query("pagetoken") pagetoken: String? = null
    ) : Observable<NearbyResultDTO>
}