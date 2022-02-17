import java.io.File

import java.io.FileReader
fun main(args: Array<String>) {
    println("           *-------Hello Deezer World!-------*")
    // Creation of a list of tracks to use it as examples.
    val Track1= Track("12312","Eminem","Oui",60,"3231")
    val Track2= Track("12412","Eminem","Non",61,"3241")
    val Track3= Track("12512","Eminem","Maybe",62,"3251")
    var listOfTracks = mutableListOf<Track>(Track1,Track2,Track3)
    var QueueList = Queue(listOfTracks)

    QueueList.getCurrentTrack()
    println("\n 1) Previous Song     2) Get The Current Track    3) Next Song  4) Quit")
    var userChoice=readLine() // The user enter a number between 1 and 4

    while ((userChoice!= "4")){
        when(userChoice){
            "1" -> QueueList.previousTrack()
            "2" -> QueueList.getCurrentTrack()
            "3" -> QueueList.nextTrack()
        }
        println("\n 1) Previous Song     2) Get The Current Track    3) Next Song  4) Quit")
        userChoice=readLine()
    }

    println("\n See you soon ! Push a button to quit...")
    readLine()


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}