package com.gyosanila.mymoviejetpack.features.fragmentMovie

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 19:33
 * Division Mobile - PT.Homecareindo Global Medika
 */
class FragmentMovieViewModelTest {
    lateinit var viewModel: FragmentMovieViewModel

    @Before
    fun setup() {
        viewModel = FragmentMovieViewModel()
    }

    @Test
    fun getMovie() {
        val movies = viewModel.getMovies()
        assertNotNull(movies)
        assertEquals(14, movies.size)
    }
}