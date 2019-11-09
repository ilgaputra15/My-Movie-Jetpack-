package com.gyosanila.mymoviejetpack.features.movieDetail

import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.data.model.Movie
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository


class MovieViewModel : ViewModel() {

    private val repository: MovieRepository = MovieRepository()
    var movieId: Int? = null

    fun setMovieId(id: Int) {
        movieId = id
    }

    fun getMovieById(): Movie? {
        return repository.getMovieById(movieId!!)
    }
}
