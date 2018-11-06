package by.mogyjib.guitarnotes.main.songs.view.edit

import by.mogyjib.guitarnotes.base.view.BaseContract

interface SongEditContract {
    interface View : BaseContract.View {
        fun showBackButton(): Unit?
    }

    interface Presenter : BaseContract.Presenter
}