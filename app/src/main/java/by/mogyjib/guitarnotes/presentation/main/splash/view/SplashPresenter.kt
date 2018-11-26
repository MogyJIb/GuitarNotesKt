package by.mogyjib.guitarnotes.presentation.main.splash.view

import by.mogyjib.guitarnotes.presentation.base.view.BasePresenter
import by.mogyjib.guitarnotes.data.repository.IRepository
import by.mogyjib.guitarnotes.presentation.utils.async
import by.mogyjib.guitarnotes.presentation.utils.fakeSongList
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit


class SplashPresenter(
        private val repository: IRepository
) : BasePresenter<SplashContract.View>() {
    override fun init() {
        disposables += repository.songs().getAll()
                .flatMap {
                    if (it.isEmpty())
                        repository.songs().add(*fakeSongList().toTypedArray())
                    else
                        Observable.just(Unit).delay(3, TimeUnit.SECONDS)
                }
                .async()
                .subscribeBy { view?.openMainScreen() }
    }
}