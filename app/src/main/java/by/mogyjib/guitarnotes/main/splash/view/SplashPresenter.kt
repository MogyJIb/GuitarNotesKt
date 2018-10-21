package by.mogyjib.guitarnotes.main.splash.view

import by.mogyjib.guitarnotes.base.view.BasePresenter
import by.mogyjib.guitarnotes.data.repository.IRepository
import by.mogyjib.guitarnotes.utils.async
import by.mogyjib.guitarnotes.utils.fakeSongList
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import java.util.concurrent.TimeUnit


class SplashPresenter(
        private val repository: IRepository
) : BasePresenter<SplashContract.View>() {
    override fun init() {
        disposables += repository.songs().getAll()
                .delay(3, TimeUnit.SECONDS)
                .map { if (it.isEmpty()) repository.songs().add(*fakeSongList().toTypedArray()) }
                .async()
                .subscribeBy { view?.openMainScreen() }
    }
}