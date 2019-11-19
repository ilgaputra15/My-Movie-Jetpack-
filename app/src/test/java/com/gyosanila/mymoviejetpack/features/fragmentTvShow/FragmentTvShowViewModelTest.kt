package com.gyosanila.mymoviejetpack.features.fragmentTvShow

import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 19:53
 * Division Mobile - PT.Homecareindo Global Medika
 */
class FragmentTvShowViewModelTest {
    lateinit var viewModel: FragmentTvShowViewModel

    @Before
    fun setUp() {
        viewModel = FragmentTvShowViewModel()
    }

    @Test
    fun getTvShows() {
        val tvShows = viewModel.getTvShows()
        assertNotNull(tvShows)
        assertEquals(20, tvShows.size)
    }
}