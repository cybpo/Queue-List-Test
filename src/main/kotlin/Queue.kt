import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.File

class Queue {
    private lateinit var jsonData : DataResult
    private var currentQueueList = mutableListOf<DataResult.Data.Album.Track>() // Actual Queue
    private var userChoice = -1 //
    private val trackZero = DataResult.Data.Album.Track("","---","---",0,ID("")) //Empty Track when no songs are playing
    private var previousList = mutableListOf<DataResult.Data.Album.Track>() // Tracks the user had already listen
    private var listOfTracks = mutableListOf<DataResult.Data.Album.Track>() // Tracks the user can add on the queue
    private var currentTrack = trackZero

    fun loadTracks() { //Loading tracks from the json file
        try{
            val filename = "data/tracks.json"
            val jsonString: String = File(filename).readText(Charsets.UTF_8)
            jsonData = Json.decodeFromString(jsonString)
            listOfTracks = jsonData.data.album.tracks
        }catch(e:Exception){
            e.printStackTrace()
        }
    }

    fun getCurrentTrack() {
        //if (currentQueueList.size == 0 && ) currentTrack = trackZero
        println("\n         CURRENT TRACK        ")
        println(currentTrack.artist)
        println(currentTrack.title)
        println(conversion(currentTrack.duration))

    }


    fun next(): DataResult.Data.Album.Track {
        if(currentQueueList.size > 1){ //If the Queue is not empty, we remove the track from the queue and put it as current track
            previousList.add(currentTrack)
            currentQueueList.removeFirst()
            currentTrack = currentQueueList[0]
        }else if(currentQueueList.size == 1){ // Telling the user when this is the last song of the Queue
            previousList.add(currentTrack)
            currentQueueList.removeFirst()
            currentTrack = trackZero
            println("This was the last track of the queue. Please select a track\n" +
                    " Push a button to continue...")
            readLine()
        }else {
            println("There is no song on the Queue. Please select a track\n" +
                    " Push a button to continue...")
            readLine()
        }
        return currentTrack
    }


    fun previous(): DataResult.Data.Album.Track {
        if (previousList.size > 0){ // Checking if there is songs in the list of songs that the user already listened to.
            currentTrack = previousList[previousList.lastIndex]
            previousList.removeLast()
        }else{
            currentTrack = trackZero
            println("No track was played before this one. You need to select a track. \n Push a button to continue...")
            readLine()
        }
        return currentTrack
    }


    fun showTracksToAdd(){// Showing all the tracks from the database so the user can choose the one he wants to add to the queue
        while (userChoice != 0){
            showTracks(listOfTracks)
            println("\n Choose the number of the track you want to add on the Queue. Push 0 to quit...")
            userChoice = readLine()!!.toInt()
            if (userChoice !=0){
                add(listOfTracks[userChoice-1]) // Adding the track on the Queue
                if(currentQueueList.size ==1) currentTrack = currentQueueList[0] // The first element of the current List represents the current track.
                println("Track added. Push a button to continue")
                readLine()
            }
        }
        userChoice = -1
    }

    fun showTracksToRemove(){ // Showing all the tracks from the Queue so the user can choose the one he wants to remove from it
        while((currentQueueList.size != 0) && (userChoice !=0)){
            println("----------------- QUEUE -----------------")
            showTracks(currentQueueList)
            println("\n Choose the number of the track you want to remove from the Queue. Push 0 to return ")
            userChoice = readLine()!!.toInt()
            if (userChoice != 0 ) removeAt(userChoice-1)
            if (userChoice == 1 && currentQueueList.size != 0) currentTrack = currentQueueList[0]
        }
        if (currentQueueList.size<= 0){
            currentTrack = trackZero
            println("The Queue is empty. Push a button to continue...")
            readLine()
        }
        userChoice=-1
    }

    private fun showTracks(list : MutableList<DataResult.Data.Album.Track>){
        for (i in 1..list.size){
            println( "\nTrack $i  : \n Artist : ${list[i-1].artist} \n Title : ${list[i-1].title}" )
        }
    }
    private fun removeAt(i : Int){
        currentQueueList.removeAt(i)
    }

    private fun add(newTrack : DataResult.Data.Album.Track){
        currentQueueList.add(newTrack)
    }

    private fun conversion(duration: Int): String { // converting seconds to minutes
        var minutes = 0
        val seconds: Int
        if (duration >= 60) {
            minutes = duration / 60
            seconds = duration - minutes * 60
        } else {
            seconds = duration
        }
        return "$minutes : $seconds s"
    }
}