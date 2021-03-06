package by.mogyjib.guitarnotes.repository

import androidx.room.Room
import by.mogyjib.guitarnotes.main.data.database.DatabaseApi
import org.junit.runner.RunWith
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import by.mogyjib.guitarnotes.main.data.models.Song
import org.junit.*


@RunWith(AndroidJUnit4::class)
class SongDaoTest {

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
    fun insertAndGetById() {
        val expected = Song("someName", "11", "TEXTTEXTTEXT")
        database.songDao().insert(expected)

        val actual = database.songDao().get(expected.uid)[0]
        Assert.assertEquals(expected, actual)
    }

    @Test
    fun insertAndDeleteById() {
        val expected = Song("someName", "11", "TEXTTEXTTEXT")
        database.songDao().insert(expected)

        val actual = database.songDao().get(expected.uid)[0]
        Assert.assertEquals(expected, actual)

        database.songDao().delete(expected.uid)
        val list = database.songDao().get(expected.uid)
        Assert.assertTrue(list.isEmpty())
    }

    @Test
    fun findByName() {
        val expected = Song("someName", "11", "TEXTTEXTTEXT")
        database.songDao().insert(expected)
        val actual = database.songDao().findByName("%ome%")
        Assert.assertEquals(expected, actual[0])
    }
}