package com.gyosanila.mymoviejetpack.features.fragmentFavoriteMovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 14:10
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentFavoriteMoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private var response: LiveData<List<MovieItem>>? = null

    fun getFavoriteMovies(): LiveData<List<MovieItem>>? {
        if (response == null) {
            response = movieRepository.getFavoriteMovies()
        }
        return response
    }
}