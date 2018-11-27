package by.mogyjib.guitarnotes

import android.app.Application
import by.mogyjib.guitarnotes.main.presentation.songs.songsModule
import by.mogyjib.guitarnotes.main.presentation.splash.splashModule
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