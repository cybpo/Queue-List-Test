@kotlinx.serialization.Serializable
 data class DataResult(val data : Data ) {
    @kotlinx.serialization.Serializable
     class Data(val album : Album){
        @kotlinx.serialization.Serializable
         class Album(val tracks  : MutableList<Track> ){
            @kotlinx.serialization.Serializable
             class Track(
                val id : String,
                val artist : String,
                val title : String,
                val duration : Int,
                val media : ID
            )
        }

    }
}