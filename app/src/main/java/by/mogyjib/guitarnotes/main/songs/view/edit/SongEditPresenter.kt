package by.mogyjib.guitarnotes.main.songs.view.edit

import by.mogyjib.guitarnotes.base.view.BasePresenter
import by.mogyjib.guitarnotes.data.repository.IRepository
import by.mogyjib.guitarnotes.utils.async
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign
import java.util.concurrent.TimeUnit

class SongEditPresenter(
        private val repository: IRepository
) : BasePresenter<SongEditContract.View>(), SongEditContract.Presenter {
    override fun init() {
        disposables += Observable.fromCallable {  }
                .delay(900, TimeUnit.MILLISECONDS)
                .async()
                .subscribe { view?.showBackButton() }
    }
}