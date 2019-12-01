package com.gyosanila.mymoviejetpack.features.fragmentFavoriteTvShows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.gyosanila.mymoviejetpack.data.model.TvShowItem
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 14:10
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentFavoriteTvShowsViewModel(private val tvShowRepository: TvShowRepository) : ViewModel() {

    private var response: LiveData<PagedList<TvShowItem>>? = null

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowItem>>? {
        if (response == null) {
            response = LivePagedListBuilder(tvShowRepository.getFavoriteTvShows(), 5).build()
        }
        return response
    }
}