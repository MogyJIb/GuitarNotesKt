package by.mogyjib.guitarnotes

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import by.mogyjib.guitarnotes.data.DatabaseApi
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import androidx.test.platform.app.InstrumentationRegistry
import
import by.mogyjib.guitarnotes.data.models.Song
import org.junit.Rule
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class SongDaoTest {
    @Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: DatabaseApi

    @Before
    fun initDb()
    {
        database = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getInstrumentation().context,
                DatabaseApi::class.java)
                        // allowing main thread queries, just for testing
                        .allowMainThreadQueries()
                        .build()
    }

    @After
    fun closeDb()
    {
        database.close()
    }

    @Test
    fun insertAndGetUserById() {
        val song = Song("someName", "11", "TEXTTEXTTEXT")
        database.songDao().insert(song)

        database.songDao().get(song.uid)
                .filter { it.isEmpty() }
                .map { it.first() }
                .test()
                .assertValue { it == song }
    }
}