package by.mogyjib.guitarnotes.repository

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import by.mogyjib.guitarnotes.data.database.DatabaseApi
import by.mogyjib.guitarnotes.data.models.Song
import by.mogyjib.guitarnotes.data.repository.IRepository
import by.mogyjib.guitarnotes.data.repository.RepositoryApi
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest


@RunWith(AndroidJUnit4::class)
class SongRepositoryTest : KoinTest {
    private lateinit var database: DatabaseApi
    private lateinit var repository: IRepository

    @Before
    fun initDb()
    {
        database = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getInstrumentation().context,
                DatabaseApi::class.java)
                // allowing main thread queries, just for testing
                .allowMainThreadQueries()
                .build()
        repository = RepositoryApi(database)
    }

    @After
    fun closeDb()
    {
        database.close()
    }

    @Test
    fun insertAndGetById() {
        val expected = Song("someName", "11", "TEXTTEXTTEXT")
        repository.songs().add(expected).blockingFirst()

        val actual = repository.songs().get(expected.uid).blockingFirst()[0]
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun insertAndDeleteById() {
        val expected = Song("someName", "11", "TEXTTEXTTEXT")
        repository.songs().add(expected).blockingFirst()

        val actual = repository.songs().get(expected.uid).blockingFirst()[0]
        Assert.assertEquals(expected, actual)

        repository.songs().delete(expected.uid).blockingFirst()
        val list = repository.songs().get(expected.uid).blockingFirst()
        Assert.assertTrue(list.isEmpty())
    }

    @Test
    fun findByName() {
        val expected = Song("someName", "11", "TEXTTEXTTEXT")
        repository.songs().add(expected).blockingFirst()
        val actual = repository.songs().findByName("%ome%").blockingFirst()
        Assert.assertEquals(expected, actual[0])
    }
}