package by.mogyjib.guitarnotes.main.songs.view

import by.mogyjib.guitarnotes.base.view.BaseContract
import by.mogyjib.guitarnotes.data.models.Song

interface SongListContract {
    interface View : BaseContract.View {
        fun updateSongs(songs: List<Song>)
    }

    interface Presenter : BaseContract.Presenter
}