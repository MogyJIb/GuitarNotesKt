package by.mogyjib.guitarnotes.main.presentation.splash

import by.mogyjib.guitarnotes.main.presentation.splash.view.SplashPresenter
import org.koin.dsl.module.module


val splashModule = module {
    factory { SplashPresenter(get()) }
}