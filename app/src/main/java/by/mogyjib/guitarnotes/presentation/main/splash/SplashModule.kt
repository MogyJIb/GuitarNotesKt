package by.mogyjib.guitarnotes.presentation.main.splash

import by.mogyjib.guitarnotes.presentation.main.splash.view.SplashPresenter
import org.koin.dsl.module.module


val splashModule = module {
    factory { SplashPresenter(get()) }
}