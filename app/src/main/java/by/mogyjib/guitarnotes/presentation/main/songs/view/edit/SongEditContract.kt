package by.mogyjib.guitarnotes.presentation.main.songs.view.edit

import by.mogyjib.guitarnotes.presentation.base.view.BaseContract

interface SongEditContract {
    interface View : BaseContract.View {
        fun showBackButton(): Unit?
    }

    interface Presenter : BaseContract.Presenter
}