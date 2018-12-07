package by.mogyjib.guitarnotes.main.data.database

import androidx.room.*
import by.mogyjib.guitarnotes.main.data.models.Song


@Dao
interface SongDao {
    @Query("SELECT * FROM songs")
    fun getAll(): List<Song>

    @Query("SELECT * FROM songs WHERE uid IN (:songIds)")
    fun get(vararg songIds: String): List<Song>

    @Query("SELECT * FROM songs WHERE name LIKE :name")
    fun findByName(name: String): List<Song>

    @Query("SELECT * FROM songs WHERE author LIKE :author")
    fun findByAuthor(author: String): List<Song>

    @Insert
    fun insert(vararg songs: Song)

    @Update
    fun update(vararg songs: Song)

    @Delete
    fun delete(vararg songs: Song)

    @Query("DELETE FROM songs WHERE uid IN (:songIds)")
    fun delete(vararg songIds: String)
}