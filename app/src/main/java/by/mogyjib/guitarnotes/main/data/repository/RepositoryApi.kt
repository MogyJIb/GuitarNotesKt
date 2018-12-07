package by.mogyjib.guitarnotes.main.data.repository

import by.mogyjib.guitarnotes.main.data.database.DatabaseApi

class RepositoryApi(
        private val db: DatabaseApi
) : IRepository {
    override fun songs() = SongRepository(db.songDao())
}