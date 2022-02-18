import Track
class Queue() {
    private var currentList = mutableListOf<Track>()
    private var previousList = mutableListOf<Track>()
    private val  listOfTracks = ListOfTracks()
    var currentTrack = Track("","","",0,"")

    fun getCurrentTrack(){
        println("\n         CURRENT TRACK        ")
        println("Artist : " + currentTrack.artist)
        println("Titre : " + currentTrack.title)
        println("Duration : " + currentTrack.duration + " s" )
    }


    fun nextTrack(): Track {
        if(currentList.size > 1){ //If the Queue is not empty, we remove the track from the queue and put it as current track
            previousList?.add(currentTrack)
            currentList?.removeFirst()
            currentTrack = currentList[0]
            getCurrentTrack()
        }else if(currentList.size == 1){ // Telling the user when this is the last song of the Queue
            previousList?.add(currentTrack)
            currentList?.removeFirst()
            getCurrentTrack()
            println("This was the last track of the queue. Please select a track\n" +
                    " Push a button to continue...")
            readLine()
        }else { //  Warning the user that there is no songs left in the queue.
            println("There is no song on the Queue. Please select a track\n" +
                    " Push a button to continue...")
            readLine()
            getCurrentTrack()
        }
        return currentTrack
    }


    fun previousTrack(): Track {
        if (previousList.size > 0){ // Checking if there is songs in the list of songs that the user already listened to.
            currentTrack = previousList[previousList.lastIndex]
            previousList?.removeLast()
            getCurrentTrack()
        }else {
            println("No track was played before this one. You need to select a track. \n Push a button to continue...")
            readLine()
            getCurrentTrack()
        }
        return currentTrack
    }


    fun showTracksToAdd(){// Showing all the tracks from the database so the user can choose the one he wants to add to the queue
        var i = 0

        for (element in listOfTracks.listOfTracks){
            i++
            println( "Track $i  : \n Artist : ${element.artist} \n Title : ${element.title}" )
        }
        println("\n Choose the number of the track you want to add on the Queue")
        var userChoice = readLine()!!.toInt()

        add(listOfTracks.listOfTracks[userChoice-1]) // Adding the track on the Queue
        if(currentList.size ==1) currentTrack = currentList[0] // If we add only one track on the Queue, we consider it as the current Track
        getCurrentTrack()
    }


    fun showTracksToRemove(){ // Showing all the tracks from the Queue so the user can choose the one he wants to remove from it
        var i = 0
        if (currentList.size== 0){ // If the Queue is empty, we can't remove any songs from it
            println("The Queue is empty. Please add songs on it .Push a button to continue...")
            readLine()
        }else{
            for (element in currentList){
                i++
                println( "Track $i  : \n Artist : ${element.artist} \n Title : ${element.title}" )
            }
            println("\n Choose the number of the track you want to remove from the Queue")
            var userChoice = readLine()!!.toInt()

            removeAt(userChoice-1)
        }
        getCurrentTrack()
    }

    fun removeAt( i : Int){
    currentList.removeAt(i)
    }

    fun add(newTrack : Track){
        currentList.add(newTrack)
    }
}