package by.mogyjib.guitarnotes.main.presentation.songs.detail

import by.mogyjib.guitarnotes.base.view.BaseContract

interface SongDetailContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter {
        fun onBackButtonClicked()
    }
}