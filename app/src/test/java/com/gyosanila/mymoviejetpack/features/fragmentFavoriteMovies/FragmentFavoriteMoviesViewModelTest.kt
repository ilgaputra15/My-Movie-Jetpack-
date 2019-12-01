package com.gyosanila.mymoviejetpack.features.fragmentFavoriteMovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gyosanila.mymoviejetpack.data.model.Movies
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository
import com.gyosanila.mymoviejetpack.features.utils.JsonUtils
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import androidx.paging.DataSource
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.features.utils.mockPagedList
import org.mockito.Mockito.*



/**
 * Created by ilgaputra15
 * on Sunday, 01/12/2019 14:43
 * Division Mobile - PT.Homecareindo Global Medika
 */
class FragmentFavoriteMoviesViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    lateinit var movieRepository: MovieRepository
    lateinit var viewModel: FragmentFavoriteMoviesViewModel

    @Mock
    lateinit var dataSource: DataSource.Factory<Int, MovieItem>

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = FragmentFavoriteMoviesViewModel(movieRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val responseString = JsonUtils.getJson("json/movie/movie_item.json")
        val responseType = object : TypeToken<Movies>() {}.type
        val dummyData: Movies = Gson().fromJson(responseString, responseType)
        `when`(movieRepository.getFavoriteMovies()).thenReturn(dataSource)
        movieRepository.getFavoriteMovies()
        val result = mockPagedList(dummyData.results)
        verify(movieRepository).getFavoriteMovies()
        assertNotNull(result)
        assertEquals(dummyData.results.size, result.size)
    }
}