package by.mogyjib.guitarnotes.presentation

import android.app.Application
import by.mogyjib.guitarnotes.presentation.main.songs.songsModule
import by.mogyjib.guitarnotes.presentation.main.splash.splashModule
import org.koin.android.ext.android.startKoin


class GuitarNotesApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
                businessModule,
                splashModule,
                songsModule
        ))
    }
}