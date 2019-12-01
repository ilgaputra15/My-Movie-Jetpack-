package com.gyosanila.mymoviejetpack.features.fragmentFavoriteMovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository


/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 14:10
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentFavoriteMoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private var response: LiveData<PagedList<MovieItem>>? = null

    fun getFavoriteMovies(): LiveData<PagedList<MovieItem>>? {
        if (response == null) {
            response = LivePagedListBuilder(movieRepository.getFavoriteMovies(), 5).build()
        }
        return response
    }
}