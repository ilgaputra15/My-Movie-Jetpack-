package com.gyosanila.mymoviejetpack.features.movieDetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gyosanila.mymoviejetpack.data.model.MovieDetail
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.model.Movies
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository
import com.gyosanila.mymoviejetpack.features.utils.JsonUtils
import io.reactivex.Observable
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import retrofit2.Response

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 19:57
 * Division Mobile - PT.Homecareindo Global Medika
 */
class MovieViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    lateinit var observer: Observer<ResultResponse>
    @Mock
    lateinit var movieRepository: MovieRepository
    lateinit var viewModel: MovieViewModel
    private val movieId = 330457

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovie() {
        val responseString = JsonUtils.getJson("json/movie/movie_detail.json")
        val responseType = object : TypeToken<MovieDetail>() {}.type
        val dummyData: MovieDetail = Gson().fromJson(responseString, responseType)
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.Success(dummyData)
        Mockito.`when`(movieRepository.getMovieDetail(movieId)).thenReturn(Observable.just(dummyData))
        viewModel.getMovieById(movieId)?.observeForever(observer)
        Mockito.verify(observer).onChanged(Mockito.refEq(response.value))
    }

    @Test
    fun getMovieLoading() {
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.OnLoading(true)
        Mockito.`when`(movieRepository.getMovieDetail(movieId)).thenReturn(Observable.empty())
        viewModel.getMovieById(movieId)?.observeForever(observer)
        Mockito.verify(observer).onChanged(Mockito.refEq(response.value))
    }

    @Test
    fun getMovieError() {
        val errorResponseBody = ResponseBody.create(MediaType.parse("application/json"), "")
        val errorResponse = Response.error<Movies>(404, errorResponseBody)
        val exception = HttpException( errorResponse )
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.Error(exception)
        Mockito.`when`(movieRepository.getMovieDetail(movieId)).thenReturn(Observable.error(exception))
        viewModel.getMovieById(movieId)?.observeForever(observer)
        Mockito.verify(observer).onChanged(Mockito.refEq(response.value))
    }

    @Test
    @Throws(Exception::class)
    fun saveFavorite() {
        val responseString = JsonUtils.getJson("json/movie/movie_item.json")
        val responseType = object : TypeToken<Movies>() {}.type
        val dummyData: Movies = Gson().fromJson(responseString, responseType)
        val response = MutableLiveData<MovieItem>()
        response.value = dummyData.results[0]
        runBlocking {
            movieRepository.saveFavorite(dummyData.results[0])
            Mockito.verify(movieRepository).saveFavorite(dummyData.results[0])
        }
    }

    @Test
    @Throws(Exception::class)
    fun getFavoriteStatus() {
        val responseString = JsonUtils.getJson("json/movie/movie_item.json")
        val responseType = object : TypeToken<Movies>() {}.type
        val dummyData: Movies = Gson().fromJson(responseString, responseType)
        val response = MutableLiveData<MovieItem>()
        response.value = dummyData.results[0]
        runBlocking {
            movieRepository.getFavorite(dummyData.results[0].id)
            Mockito.`when`(movieRepository.getFavorite(dummyData.results[0].id)).thenReturn(response)
            assertThat(response.value, equalTo(dummyData.results[0]) )
        }
    }

    @Test
    @Throws(Exception::class)
    fun deleteFavorite() {
        val responseString = JsonUtils.getJson("json/movie/movie_item.json")
        val responseType = object : TypeToken<Movies>() {}.type
        val dummyData: Movies = Gson().fromJson(responseString, responseType)
        val response = MutableLiveData<MovieItem>()
        response.value = dummyData.results[0]
        runBlocking {
            movieRepository.deleteFavorite(dummyData.results[0].id)
            Mockito.verify(movieRepository).deleteFavorite(dummyData.results[0].id)
        }
    }


}