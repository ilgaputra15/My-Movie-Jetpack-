package com.gyosanila.mymoviejetpack.features.fragmentMovie

import androidx.lifecycle.ViewModel
import com.gyosanila.mymoviejetpack.data.model.Movie
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 14:10
 * Division Mobile - PT.Homecareindo Global Medika
 **/

class FragmentMovieViewModel : ViewModel() {
    fun getMovies(): ArrayList<Movie> {
        val repository = MovieRepository()
        return repository.getMoviesDummy()
    }
}