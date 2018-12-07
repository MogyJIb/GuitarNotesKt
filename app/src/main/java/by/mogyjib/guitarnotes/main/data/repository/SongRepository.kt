package by.mogyjib.guitarnotes.main.data.repository

import by.mogyjib.guitarnotes.main.data.database.SongDao
import by.mogyjib.guitarnotes.main.data.models.Song
import io.reactivex.Observable


class SongRepository(
        private val songDao: SongDao
) {
    fun getAll(): Observable<List<Song>>
            = Observable.fromCallable { songDao.getAll()  }
    fun get(vararg songIds: String): Observable<List<Song>>
            = Observable.fromCallable { songDao.get(*songIds) }
    fun findByName(name: String): Observable<List<Song>>
            = Observable.fromCallable { songDao.findByName(name) }
    fun findByAuthor(author: String): Observable<List<Song>>
            = Observable.fromCallable { songDao.findByAuthor(author) }
    fun add(vararg songs: Song): Observable<Unit>
            = Observable.fromCallable { songDao.insert(*songs) }
    fun update(vararg songs: Song): Observable<Unit>
            = Observable.fromCallable { songDao.update(*songs) }
    fun delete(vararg songs: Song): Observable<Unit>
            = Observable.fromCallable { songDao.delete(*songs) }
    fun delete(vararg songIds: String): Observable<Unit>
            = Observable.fromCallable { songDao.delete(*songIds) }
}