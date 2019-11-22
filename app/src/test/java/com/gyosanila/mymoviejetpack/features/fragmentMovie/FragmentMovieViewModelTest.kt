package com.gyosanila.mymoviejetpack.features.fragmentMovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gyosanila.mymoviejetpack.data.model.Movies
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository
import com.gyosanila.mymoviejetpack.features.utils.JsonUtils
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import retrofit2.Response


/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 19:33
 * Division Mobile - PT.Homecareindo Global Medika
 */
class FragmentMovieViewModelTest {

    @Rule @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    lateinit var observer: Observer<ResultResponse>
    @Mock
    lateinit var movieRepository: MovieRepository
    lateinit var viewModel: FragmentMovieViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = FragmentMovieViewModel(movieRepository)
    }

    @Test
    fun getMovie() {
        val responseString = JsonUtils.getJson("json/movie/movie_item.json")
        val responseType = object : TypeToken<Movies>() {}.type
        val dummyData: Movies = Gson().fromJson(responseString, responseType)
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.Success(dummyData)
        `when`(movieRepository.getMovieList()).thenReturn(Observable.just(dummyData))
        viewModel.getListMovie()?.observeForever(observer)
        verify(observer).onChanged(refEq(response.value ))
    }

    @Test
    fun getMovieLoading() {
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.OnLoading(true)
        `when`(movieRepository.getMovieList()).thenReturn(Observable.empty())
        viewModel.getListMovie()?.observeForever(observer)
        verify(observer).onChanged(refEq(response.value ))
    }

    @Test
    fun getMovieError() {
        val errorResponseBody = ResponseBody.create(MediaType.parse("application/json"), "")
        val errorResponse = Response.error<Movies>(404, errorResponseBody)
        val exception = HttpException( errorResponse )
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.Error(exception)
        `when`(movieRepository.getMovieList()).thenReturn(Observable.error(exception))
        viewModel.getListMovie()?.observeForever(observer)
        verify(observer).onChanged(refEq(response.value ))
    }
}