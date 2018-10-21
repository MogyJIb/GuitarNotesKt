package by.mogyjib.guitarnotes

import by.mogyjib.guitarnotes.data.database.DatabaseApi
import by.mogyjib.guitarnotes.data.repository.IRepository
import by.mogyjib.guitarnotes.data.repository.RepositoryApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


val businessModule = module {
    single { DatabaseApi.instance(androidContext()) }
    single { RepositoryApi(get()) as IRepository }
}