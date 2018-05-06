package info.babin.photos

data class Response(val _embedded: EmbeddedData)

data class EmbeddedData(val items: List<PhotoItem>)

data class PhotoItem(
    val file: String,
    val preview: String,
    val media_type: String
)
