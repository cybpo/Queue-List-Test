import Track
class Queue(private var currentList : MutableList<Track>) {
    private var previousList = mutableListOf<Track>()
    var currentTrack = currentList[0]
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
        }else if (currentList.size == 1){ // Telling the user when this is the last song of the Queue
            previousList?.add(currentTrack)
            currentList?.removeFirst()
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
}