package com.gyosanila.mymoviejetpack.features.fragmentFavoriteTvShows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.gyosanila.mymoviejetpack.data.model.TvShowItem
import com.gyosanila.mymoviejetpack.data.model.TvShows
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository
import com.gyosanila.mymoviejetpack.features.utils.JsonUtils
import com.gyosanila.mymoviejetpack.features.utils.mockPagedList
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by ilgaputra15
 * on Sunday, 01/12/2019 15:31
 * Division Mobile - PT.Homecareindo Global Medika
 */
class FragmentFavoriteTvShowsViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    @Mock
    lateinit var tvShowRepository: TvShowRepository
    @Mock
    lateinit var observer: Observer<PagedList<TvShowItem>>
    private lateinit var viewModel: FragmentFavoriteTvShowsViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = FragmentFavoriteTvShowsViewModel(tvShowRepository)
    }

    @Test
    fun getFavoriteTvShows() {
        val responseString = JsonUtils.getJson("json/tvShow/tv_show_item.json")
        val responseType = object : TypeToken<TvShows>() {}.type
        val dummyData: TvShows = Gson().fromJson(responseString, responseType)
        val result = mockPagedList(dummyData.results)
        val response = MutableLiveData<PagedList<TvShowItem>>()
        response.value = result
        `when`(tvShowRepository.getFavoriteTvShows(10)).thenReturn(response)
        viewModel.getFavoriteTvShows()?.observeForever(observer)
        verify(observer).onChanged(Mockito.refEq(response.value))
    }
}