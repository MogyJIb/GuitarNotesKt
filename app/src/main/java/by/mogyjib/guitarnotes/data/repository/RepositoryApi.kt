package by.mogyjib.guitarnotes.data.repository

import by.mogyjib.guitarnotes.data.database.DatabaseApi

class RepositoryApi(
        private val db: DatabaseApi
) : IRepository {
    override fun songs() = SongRepository(db.songDao())
}