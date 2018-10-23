package by.mogyjib.guitarnotes.main.songs

import by.mogyjib.guitarnotes.main.songs.view.SongListPresenter
import org.koin.dsl.module.module

val songsModule = module {
    factory { SongListPresenter(get()) }
}