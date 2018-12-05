package by.mogyjib.guitarnotes.main.presentation.songs.detail

import by.mogyjib.guitarnotes.main.presentation.base.view.BasePresenter
import by.mogyjib.guitarnotes.main.data.repository.IRepository

class SongDetailPresenter(
        private val repository: IRepository
) : BasePresenter<SongDetailContract.View>(), SongDetailContract.Presenter