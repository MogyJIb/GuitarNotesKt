package by.mogyjib.guitarnotes.main.presentation.songs.edit

import androidx.annotation.StringRes
import by.mogyjib.guitarnotes.main.data.models.Song
import by.mogyjib.guitarnotes.base.view.BaseContract

interface SongEditContract {
    interface View : BaseContract.View {
        fun showNameError(@StringRes errorRes: Int)
        fun hideNameError()

        fun showAuthorError(@StringRes errorRes: Int)
        fun hideAuthorError()

        fun showTextError(@StringRes errorRes: Int)
        fun hideTextError()
    }

    interface Presenter : BaseContract.Presenter {
        fun onBackButtonClicked()
        fun onDeleteButtonClicked(songId: String?)
        fun onSaveButtonClicked(song: Song, songId: String?)
    }
}