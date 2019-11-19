package com.gyosanila.mymoviejetpack.features.tvShowDetail

import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.data.model.TvShow
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository


/**
 * Created by ilgaputra15
 * on Sunday, 09/11/2019 19:25
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class TvShowViewModel: ViewModel() {

    private val repository = TvShowRepository()
    var tvShowId: Int? = null

    fun seTvShowId(id: Int) {
        tvShowId = id
    }

    fun getTvShowById(): TvShow? {
        return repository.getTvShowById(tvShowId!!)
    }
}