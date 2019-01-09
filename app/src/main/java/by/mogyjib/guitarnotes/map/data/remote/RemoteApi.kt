package by.mogyjib.guitarnotes.map.data.remote

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RemoteApi(
    gson: Gson,
    okHttpClient: OkHttpClient
) {
    private val retrofit: Retrofit

    companion object {
        const val BASE_URL = "https://maps.googleapis.com/maps/api/place/"
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun placesService(): PlacesService = retrofit.create(PlacesService::class.java)
}