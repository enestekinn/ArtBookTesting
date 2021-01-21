package com.enestekin.artbooktesting.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.enestekin.artbooktesting.adapter.ArtRecyclerAdapter
import com.enestekin.artbooktesting.adapter.ImageRecyclerViewAdapter
import javax.inject.Inject

class ArtFragmentFactory @Inject constructor(
        private  val artRecyclerAdapter: ArtRecyclerAdapter,
        private val glide : RequestManager,
        private val imageRecyclerAdapter : ImageRecyclerViewAdapter

) : FragmentFactory()
{


    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when (className) {
            ImageApiFragment::class.java.name -> ImageApiFragment(imageRecyclerAdapter)
            ArtFragment::class.java.name -> ArtFragment(artRecyclerAdapter)
            ArtDetailsFragment::class.java.name -> ArtDetailsFragment(glide)
            else ->  return super.instantiate(classLoader, className)

        }

    }
}