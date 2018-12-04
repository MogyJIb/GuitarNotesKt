package by.mogyjib.guitarnotes.main.presentation.songs

import by.mogyjib.guitarnotes.main.presentation.songs.detail.SongDetailContract
import by.mogyjib.guitarnotes.main.presentation.songs.detail.SongDetailPresenter
import by.mogyjib.guitarnotes.main.presentation.songs.list.SongListContract
import by.mogyjib.guitarnotes.main.presentation.songs.list.SongListPresenter
import org.koin.dsl.module.module

val songsModule = module {
    factory { SongListPresenter(get()) as SongListContract.Presenter }
    factory { SongDetailPresenter(get()) as SongDetailContract.Presenter }
}