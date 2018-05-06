package info.babin.photos

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.concurrent.thread

class DataSource {

    private val api: API

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://cloud-api.yandex.net")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        api = retrofit.create(API::class.java)
    }

    fun getPhotos(resourceKey: String, callback: (list: List<PhotoItem>) -> Unit) {
        thread {
            val call = api.getResource(resourceKey)
            val resp = call.execute()
            val result = resp.body()?._embedded?.items
                    ?.filter { it.media_type == "image" }
                    ?: emptyList()
            callback(result)
        }
    }
}
