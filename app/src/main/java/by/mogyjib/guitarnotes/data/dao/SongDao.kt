package by.mogyjib.guitarnotes.data.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import by.mogyjib.guitarnotes.data.models.Song
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable


@Dao
interface SongDao {
    @Query("SELECT * FROM songs")
    fun getAll(): Observable<List<Song>>

    @Query("SELECT * FROM songs WHERE uid IN (:songIds)")
    fun get(vararg songIds: String): Observable<List<Song>>

    @Query("SELECT * FROM songs WHERE name LIKE :name")
    fun findByName(name: String): Observable<List<Song>>

    @Query("SELECT * FROM songs WHERE author LIKE :author")
    fun findByAuthor(author: String): Observable<List<Song>>

    @Insert
    fun insert(vararg songs: Song)

    @Update
    fun update(vararg songs: Song)

    @Delete
    fun delete(vararg songs: Song)

    @Query("DELETE FROM songs WHERE uid IN (:songIds)")
    fun delete(vararg songIds: String)
}