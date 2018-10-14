package by.mogyjib.guitarnotes.main.splash

import by.mogyjib.guitarnotes.main.splash.view.SplashPresenter
import org.koin.dsl.module.module

val splashModule = module {
    factory { SplashPresenter() }
}