package by.mogyjib.guitarnotes.main.presentation.songs.list

import by.mogyjib.guitarnotes.base.view.BaseContract
import by.mogyjib.guitarnotes.main.data.models.Song

interface SongListContract {
    interface View : BaseContract.View {
        fun updateSongs(songs: List<Song>)
    }

    interface Presenter : BaseContract.Presenter {
        fun onSongItemClicked(song: Song)
        fun onAddSongClicked()
    }
}