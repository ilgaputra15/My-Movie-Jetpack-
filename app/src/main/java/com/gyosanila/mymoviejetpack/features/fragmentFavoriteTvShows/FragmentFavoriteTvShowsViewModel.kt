package com.gyosanila.mymoviejetpack.features.fragmentFavoriteTvShows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.data.model.TvShowItem
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 14:10
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentFavoriteTvShowsViewModel(private val tvShowRepository: TvShowRepository) : ViewModel() {

    private var response: LiveData<List<TvShowItem>>? = null

    fun getFavoriteTvShows(): LiveData<List<TvShowItem>>? {
        if (response == null) {
            response = tvShowRepository.getFavoriteTvShows()
        }
        return response
    }
}