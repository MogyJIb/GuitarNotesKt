package by.mogyjib.guitarnotes

import android.app.Application
import org.koin.android.ext.android.startKoin


class GuitarNotesApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
                dataModule,
                domainModule,
                splashModule,
                songsModule
        ))
    }
}