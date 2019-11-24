package com.gyosanila.mymoviejetpack.features.tvShowDetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.model.TvShowDetail
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository
import com.gyosanila.mymoviejetpack.features.utils.JsonUtils
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.ResponseBody
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
 * on Saturday, 09/11/2019 20:04
 * Division Mobile - PT.Homecareindo Global Medika
 */
class TvShowViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    lateinit var observer: Observer<ResultResponse>
    @Mock
    lateinit var tvShowRepository: TvShowRepository
    private lateinit var viewModel: TvShowViewModel
    private val tvShowId = 330457

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = TvShowViewModel(tvShowRepository)
    }

    @Test
    fun getTvShowDetail() {
        val responseString = JsonUtils.getJson("json/tvShow/tv_show_detail.json")
        val responseType = object : TypeToken<TvShowDetail>() {}.type
        val dummyData: TvShowDetail = Gson().fromJson(responseString, responseType)
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.Success(dummyData)
        Mockito.`when`(tvShowRepository.getTvShowDetail(tvShowId)).thenReturn(Observable.just(dummyData))
        viewModel.getMovieById(tvShowId)?.observeForever(observer)
        Mockito.verify(observer).onChanged(Mockito.refEq(response.value))
    }

    @Test
    fun getMovieLoading() {
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.OnLoading(true)
        Mockito.`when`(tvShowRepository.getTvShowDetail(tvShowId)).thenReturn(Observable.empty())
        viewModel.getMovieById(tvShowId)?.observeForever(observer)
        Mockito.verify(observer).onChanged(Mockito.refEq(response.value))
    }

    @Test
    fun getMovieError() {
        val errorResponseBody = ResponseBody.create(MediaType.parse("application/json"), "")
        val errorResponse = Response.error<TvShowDetail>(404, errorResponseBody)
        val exception = HttpException( errorResponse )
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.Error(exception)
        Mockito.`when`(tvShowRepository.getTvShowDetail(tvShowId)).thenReturn(Observable.error(exception))
        viewModel.getMovieById(tvShowId)?.observeForever(observer)
        Mockito.verify(observer).onChanged(Mockito.refEq(response.value))
    }
}