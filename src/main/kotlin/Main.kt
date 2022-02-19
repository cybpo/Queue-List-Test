fun main(args: Array<String>) {
    println("           *-------Hello Deezer World!-------*")
    var queue = Queue()
    var userChoice = ""// The user enter a number between 1 and 6
    queue.loadTracks()


    while ((userChoice!= "5")){
        queue.getCurrentTrack()
        println("\n 1) Previous Song     2)  Next Song       \n " +
                "3) Remove Song on the Queue     4) Add Songs on the Queue     5) Quit")
        userChoice= readLine().toString()
        when(userChoice){
            "1" -> queue.previous()
            "2" -> queue.next()
            "3" -> queue.showTracksToRemove()
            "4" -> queue.showTracksToAdd()
        }

    }

    println("\n See you soon ! \n")



    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}



