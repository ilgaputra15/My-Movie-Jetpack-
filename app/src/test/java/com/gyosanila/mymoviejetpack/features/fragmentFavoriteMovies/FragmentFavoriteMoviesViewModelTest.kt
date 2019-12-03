package com.gyosanila.mymoviejetpack.features.fragmentFavoriteMovies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.model.Movies
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository
import com.gyosanila.mymoviejetpack.features.utils.JsonUtils
import com.gyosanila.mymoviejetpack.features.utils.mockPagedList
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


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
    @Mock
    lateinit var observer: Observer<PagedList<MovieItem>>
    lateinit var viewModel: FragmentFavoriteMoviesViewModel

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
        val response = MutableLiveData<PagedList<MovieItem>>()
        val result = mockPagedList(dummyData.results)
        response.value = result
        `when`(movieRepository.getFavoriteMovies(10)).thenReturn(response)
        viewModel.getFavoriteMovies()?.observeForever(observer)
        verify(observer).onChanged(refEq(response.value ))
    }
}