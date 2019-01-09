package by.mogyjib.guitarnotes

import by.mogyjib.guitarnotes.main.data.database.DatabaseApi
import by.mogyjib.guitarnotes.main.data.repository.IRepository
import by.mogyjib.guitarnotes.main.data.repository.RepositoryApi
import by.mogyjib.guitarnotes.main.domain.DeleteSongUseCase
import by.mogyjib.guitarnotes.main.domain.GetSongsUseCase
import by.mogyjib.guitarnotes.main.domain.UpdateSongUseCase
import by.mogyjib.guitarnotes.main.domain.ValidateSongUseCase
import by.mogyjib.guitarnotes.main.presentation.songs.detail.SongDetailContract
import by.mogyjib.guitarnotes.main.presentation.songs.detail.SongDetailPresenter
import by.mogyjib.guitarnotes.main.presentation.songs.edit.SongEditContract
import by.mogyjib.guitarnotes.main.presentation.songs.edit.SongEditPresenter
import by.mogyjib.guitarnotes.main.presentation.songs.list.SongListContract
import by.mogyjib.guitarnotes.main.presentation.songs.list.SongListPresenter
import by.mogyjib.guitarnotes.main.presentation.splash.view.SplashPresenter
import by.mogyjib.guitarnotes.map.data.remote.PlacesService
import by.mogyjib.guitarnotes.map.data.remote.RemoteApi
import by.mogyjib.guitarnotes.map.data.repository.IPlacesRepository
import by.mogyjib.guitarnotes.map.data.repository.PlacesRepository
import by.mogyjib.guitarnotes.map.domain.LocationHandler
import by.mogyjib.guitarnotes.map.domain.NearbySearchUseCase
import by.mogyjib.guitarnotes.map.presentation.MapContract
import by.mogyjib.guitarnotes.map.presentation.MapPresenter
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import java.util.concurrent.TimeUnit


val dataModule = module {
    single { DatabaseApi.instance(androidContext()) }
    single { RepositoryApi(get()) as IRepository }

    single { PlacesRepository(get()) as IPlacesRepository }
}

val remoteModule = module {
    single { provideOkHttpClient() }
    single { provideGson() }
    single { RemoteApi(get(), get()) }
    single { providePlacesService(get()) }
}

val domainModule = module {
    single { GetSongsUseCase(get()) }
    single { ValidateSongUseCase() }
    single { UpdateSongUseCase(get()) }
    single { DeleteSongUseCase(get()) }

    single { NearbySearchUseCase(androidContext().getString(R.string.google_maps_key), get()) }
    single { LocationHandler() }
}

val splashModule = module {
    factory { SplashPresenter(get()) }
}

val songsModule = module {
    factory { SongListPresenter(get()) as SongListContract.Presenter }
    factory { SongDetailPresenter(get()) as SongDetailContract.Presenter }
    factory { SongEditPresenter(get(), get(), get()) as SongEditContract.Presenter }
}

val mapModule = module {
    factory { MapPresenter(get(), get()) as MapContract.Presenter }
}



private fun providePlacesService(remoteApi: RemoteApi): PlacesService = remoteApi.placesService()

private fun provideGson(): Gson
        = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()

private fun provideOkHttpClient()
        = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
        .build()