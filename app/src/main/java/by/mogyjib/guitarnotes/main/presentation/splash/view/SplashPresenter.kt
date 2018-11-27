package by.mogyjib.guitarnotes.main.presentation.splash.view

import by.mogyjib.guitarnotes.R
import by.mogyjib.guitarnotes.main.presentation.base.view.BasePresenter
import by.mogyjib.guitarnotes.main.data.repository.IRepository
import by.mogyjib.guitarnotes.utils.async
import by.mogyjib.guitarnotes.main.data.fakeSongList
import by.mogyjib.guitarnotes.main.presentation.base.view.BaseContract
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit


class SplashPresenter(
        private val repository: IRepository
) : BasePresenter<BaseContract.View>() {
    override fun init() {
        disposables += repository.songs().getAll()
                .flatMap {
                    if (it.isEmpty())
                        repository.songs().add(*fakeSongList().toTypedArray())
                    else
                        Observable.just(Unit).delay(3, TimeUnit.SECONDS)
                }
                .async()
                .subscribeBy {
                    view?.router()?.navigate(R.id.action_splash_fragment_to_song_activity)
                }
    }
}