class ListOfTracks() {
    // Creation of a list of tracks to use it as examples.
    val Track1= Track("12312","Eminem","Oui",60,"3231")
    val Track2= Track("12412","Eminem","Non",61,"3241")
    val Track3= Track("12512","Eminem","Maybe",62,"3251")
    var listOfTracks = mutableListOf<Track>(Track1,Track2,Track3)
}