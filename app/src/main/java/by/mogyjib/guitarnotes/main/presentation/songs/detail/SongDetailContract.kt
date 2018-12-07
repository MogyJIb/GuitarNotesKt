package by.mogyjib.guitarnotes.main.presentation.songs.detail

import by.mogyjib.guitarnotes.base.view.BaseContract
import by.mogyjib.guitarnotes.main.data.models.Song

interface SongDetailContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter {
        fun onBackButtonClicked()
        fun onDeleteButtonClicked(songId: String)
        fun onEditButtonClicked(song: Song)
    }
}