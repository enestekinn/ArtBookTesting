package com.enestekin.artbooktesting.repo

import androidx.lifecycle.LiveData
import com.enestekin.artbooktesting.model.ImageResponse
import com.enestekin.artbooktesting.roomdb.Art
import com.enestekin.artbooktesting.util.Resource

interface ArtRepositoryInterface {

    suspend fun  insertArt(art : Art)

    suspend fun deleteArt(art : Art)

    fun getArt() : LiveData<List<Art>>

    suspend fun searchImage(imageString : String) : Resource<ImageResponse>
}