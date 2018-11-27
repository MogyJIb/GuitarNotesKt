package by.mogyjib.guitarnotes.main.presentation.songs.edit

import by.mogyjib.guitarnotes.main.presentation.base.view.BasePresenter
import by.mogyjib.guitarnotes.main.data.repository.IRepository
import by.mogyjib.guitarnotes.utils.async
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign
import java.util.concurrent.TimeUnit

class SongEditPresenter(
        private val repository: IRepository
) : BasePresenter<SongEditContract.View>(), SongEditContract.Presenter