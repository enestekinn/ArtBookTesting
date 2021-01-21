package com.enestekin.artbooktesting.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.enestekin.artbooktesting.MainCoroutineRule
import com.enestekin.artbooktesting.getOrAwaitValueTest
import com.enestekin.artbooktesting.repo.FakeArtRepository
import com.enestekin.artbooktesting.util.Status
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@ExperimentalCoroutinesApi
class ArtViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()  // thread dinlemeden calistiriyor herseyi

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel : ArtViewModel

    @Before
    fun setup() {
        //Test Doubles  kopyasini test ediyoruz


        viewModel = ArtViewModel(FakeArtRepository())


    }

    @Test
    fun  `insert art without year returns error`() {
        viewModel.makeArt("Mona Lisa","Da Vinci","")
       val value =  viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert art without name returns error`() {

        viewModel.makeArt("","Da Vinci","1700")
        val value =  viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun `insert art without artistName returns error`() {

        viewModel.makeArt("Mona Lisa","","1700")
        val value =  viewModel.insertArtMessage.getOrAwaitValueTest()
        assertThat(value.status).isEqualTo(Status.ERROR)
    }
}