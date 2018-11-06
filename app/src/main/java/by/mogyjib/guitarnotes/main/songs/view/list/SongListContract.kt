package by.mogyjib.guitarnotes.main.songs.view.list

import by.mogyjib.guitarnotes.base.view.BaseContract
import by.mogyjib.guitarnotes.data.models.Song

interface SongListContract {
    interface View : BaseContract.View {
        fun updateSongs(songs: List<Song>)
        fun showAddButton(): Unit?
        fun hideAddButton(): Unit?
        fun navigateToEditSong()
    }

    interface Presenter : BaseContract.Presenter {
        fun onSongItemClicked(song: Song)
    }
}