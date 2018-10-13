package by.mogyjib.guitarnotes

import android.app.Application
import by.mogyjib.guitarnotes.main.dependency.appModule
import org.koin.android.ext.android.startKoin

class GuitarNotesApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}