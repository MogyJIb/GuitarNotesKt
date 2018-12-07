package by.mogyjib.guitarnotes.main.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(tableName = "songs")
data class Song(
        @ColumnInfo(name = "name")
        var name: String,

        @ColumnInfo(name = "author")
        var author: String,

        @ColumnInfo(name = "text")
        var text: String,

        @ColumnInfo(name = "uid")
        @PrimaryKey
        val uid: String = UUID.randomUUID().toString()
) : Serializable