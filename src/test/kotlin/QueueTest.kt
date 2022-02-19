import kotlin.test.Test


internal class QueueTest {
    private val queuetest = Queue()

    @Test
    fun getCurrentTrack() {
        val expected = "Eminem"
        queuetest.loadTracks()
        //assertEquals(expected,queuetest.getCurrentTrack())
    }

    @Test
    fun loadTracks() {
        val expected = DataResult.Data.Album.Track("916413","Eminem","Business",251,ID("916413"))
        //assertEquals(expected, queuetest.LoadTracks())
    }
}