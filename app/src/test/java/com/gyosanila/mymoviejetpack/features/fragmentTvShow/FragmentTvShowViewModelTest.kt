package com.gyosanila.mymoviejetpack.features.fragmentTvShow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gyosanila.mymoviejetpack.data.model.ResultResponse
import com.gyosanila.mymoviejetpack.data.model.TvShows
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository
import com.gyosanila.mymoviejetpack.features.utils.JsonUtils
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.refEq
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import retrofit2.Response

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 19:53
 * Division Mobile - PT.Homecareindo Global Medika
 */
class FragmentTvShowViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    lateinit var observer: Observer<ResultResponse>
    @Mock
    lateinit var tvShowRepository: TvShowRepository
    lateinit var viewModel: FragmentTvShowViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = FragmentTvShowViewModel(tvShowRepository)
    }

    @Test
    fun getTvShowSuccess() {
        val responseString = JsonUtils.getJson("json/tvShow/tv_show_item.json")
        val responseType = object : TypeToken<TvShows>() {}.type
        val dummyData: TvShows = Gson().fromJson(responseString, responseType)
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.Success(dummyData)
        `when`(tvShowRepository.getTvShowList()).thenReturn(Observable.just(dummyData))
        viewModel.getTvShows()?.observeForever(observer)
        verify(observer).onChanged(refEq(response.value ))
    }

    @Test
    fun getTvShowLoading() {
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.OnLoading(true)
        `when`(tvShowRepository.getTvShowList()).thenReturn(Observable.empty())
        viewModel.getTvShows()?.observeForever(observer)
        verify(observer).onChanged(refEq(response.value ))
    }

    @Test
    fun getTvShowError() {
        val errorResponseBody = ResponseBody.create(MediaType.parse("application/json"), "")
        val errorResponse = Response.error<TvShows>(404, errorResponseBody)
        val exception = HttpException( errorResponse )
        val response = MutableLiveData<ResultResponse>()
        response.value = ResultResponse.Error(exception)
        `when`(tvShowRepository.getTvShowList()).thenReturn(Observable.error(exception))
        viewModel.getTvShows()?.observeForever(observer)
        verify(observer).onChanged(refEq(response.value ))
    }
}