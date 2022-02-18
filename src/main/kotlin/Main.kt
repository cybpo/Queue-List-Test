import java.io.File

import java.io.FileReader
fun main(args: Array<String>) {
    println("           *-------Hello Deezer World!-------*")
    var QueueList = Queue()

    QueueList.getCurrentTrack()
    println("\n 1) Previous Song     2) Get The Current Track    3) Next Song  \n " +
            "4) Remove Song on the Queue     5) Add Songs on the Queue     6) Quit")
    var userChoice=readLine() // The user enter a number between 1 and 4

    while ((userChoice!= "6")){
        when(userChoice){
            "1" -> QueueList.previousTrack()
            "2" -> QueueList.getCurrentTrack()
            "3" -> QueueList.nextTrack()
            "4" -> QueueList.showTracksToRemove()
            "5" -> QueueList.showTracksToAdd()
            "6" -> break
        }
        println("\n 1) Previous Song     2) Get The Current Track    3) Next Song  \n " +
                "4) Remove Song on the Queue     5) Add Songs on the Queue     6) Quit")
        userChoice=readLine()
    }

    println("\n See you soon ! Push a button to quit...")
    readLine()


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}