package com.enestekin.artbooktesting.api

import android.media.Image
import com.enestekin.artbooktesting.model.ImageResponse
import com.enestekin.artbooktesting.util.Constant.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {

    @GET("/api/")
    suspend fun  imageSearch(
            @Query("q") searchQuery : String,
            @Query ("key") apiKey : String = API_KEY

    ) : Response<ImageResponse>
}