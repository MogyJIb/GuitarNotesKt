package by.mogyjib.guitarnotes.data.repository

import by.mogyjib.guitarnotes.data.database.SongDao
import by.mogyjib.guitarnotes.data.models.Song
import io.reactivex.Maybe


class SongRepository(
        private val songDao: SongDao
) {
    fun getAll() = songDao.getAll()
    fun get(vararg songIds: String) = songDao.get(*songIds)
    fun findByName(name: String) = songDao.findByName(name)
    fun findByAuthor(author: String) = songDao.findByAuthor(author)
    fun add(vararg songs: Song) = Maybe.fromCallable { songDao.insert(*songs) }
    fun update(vararg songs: Song) = Maybe.fromCallable { songDao.update(*songs) }
    fun delete(vararg songs: Song) = Maybe.fromCallable { songDao.delete(*songs) }
    fun delete(vararg songIds: String) = Maybe.fromCallable { songDao.delete(*songIds) }
}