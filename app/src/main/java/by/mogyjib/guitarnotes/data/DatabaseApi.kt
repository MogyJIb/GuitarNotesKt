package by.mogyjib.guitarnotes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.mogyjib.guitarnotes.data.dao.SongDao
import by.mogyjib.guitarnotes.data.models.Song


@Database(entities = [Song::class], version = 1)
abstract class DatabaseApi : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "guitar_notes_db"

        @JvmStatic
        fun instance(context: Context) =
                Room.databaseBuilder(context, DatabaseApi::class.java, DATABASE_NAME).build()
    }

    abstract fun songDao(): SongDao
}