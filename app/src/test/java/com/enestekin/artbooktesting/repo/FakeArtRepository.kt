package com.enestekin.artbooktesting.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.enestekin.artbooktesting.model.ImageResponse
import com.enestekin.artbooktesting.roomdb.Art
import com.enestekin.artbooktesting.util.Resource

class FakeArtRepository : ArtRepositoryInterface {

    private  val  arts = mutableListOf<Art>()  // degistirilebilir liste
    private val artsLiveData = MutableLiveData<List<Art>>(arts)

    override suspend fun insertArt(art: Art) {

        arts.add(art)
        refreshData()
    }

    override suspend fun deleteArt(art: Art) {
        arts.remove(art)
        refreshData()

    }

    override fun getArt(): LiveData<List<Art>> {
        return artsLiveData
    }

    override suspend fun searchImage(imageString: String): Resource<ImageResponse> {
        return  Resource.success(ImageResponse(listOf(),0,0))
    }

    private  fun refreshData() {
        artsLiveData.postValue(arts)
    }
}