package com.gyosanila.mymoviejetpack.features.fragmentTvShow

import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.data.model.TvShow
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 15:29
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class FragmentTvShowViewModel: ViewModel() {

    private val repository = TvShowRepository()

    fun getTvShows(): ArrayList<TvShow> {
        return repository.getTvShowsDummy()
    }
}