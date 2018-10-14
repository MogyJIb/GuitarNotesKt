package by.mogyjib.guitarnotes.main.splash.view

import by.mogyjib.guitarnotes.base.view.BasePresenter
import io.reactivex.Single
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashPresenter : BasePresenter<SplashContract.View>() {

    override fun init() {
        disposables += Single.timer(7, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .subscribeBy { view?.openMainScreen() }
    }

}