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
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


val dataModule = module {
    single { DatabaseApi.instance(androidContext()) }
    single { RepositoryApi(get()) as IRepository }
}

val domainModule = module {
    single { GetSongsUseCase(get()) }
    single { ValidateSongUseCase() }
    single { UpdateSongUseCase(get()) }
    single { DeleteSongUseCase(get()) }
}

val splashModule = module {
    factory { SplashPresenter(get()) }
}

val songsModule = module {
    factory { SongListPresenter(get()) as SongListContract.Presenter }
    factory { SongDetailPresenter(get()) as SongDetailContract.Presenter }
    factory { SongEditPresenter(get(), get(), get()) as SongEditContract.Presenter }
}