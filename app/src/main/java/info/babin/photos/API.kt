package info.babin.photos

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("/v1/disk/public/resources")
    fun getResource(
            @Query("public_key") publicKey: String,
            @Query("preview_size") previewSize: String = "L"): Call<Response>
}
