package by.mogyjib.guitarnotes.main.presentation.songs

import by.mogyjib.guitarnotes.main.presentation.songs.edit.SongEditPresenter
import by.mogyjib.guitarnotes.main.presentation.songs.list.SongListPresenter
import org.koin.dsl.module.module

val songsModule = module {
    factory { SongListPresenter(get()) }
    factory { SongEditPresenter(get()) }
}