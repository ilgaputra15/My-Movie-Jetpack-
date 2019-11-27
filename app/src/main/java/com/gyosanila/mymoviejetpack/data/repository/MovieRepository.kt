package com.gyosanila.mymoviejetpack.data.repository

import androidx.lifecycle.LiveData
import com.gyosanila.mymoviejetpack.core.common.Constant
import com.gyosanila.mymoviejetpack.core.utils.RxUtils
import com.gyosanila.mymoviejetpack.data.local.MyMovieDao
import com.gyosanila.mymoviejetpack.data.model.MovieDetail
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.model.Movies
import com.gyosanila.mymoviejetpack.data.remote.MovieServices
import io.reactivex.Observable

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 13:51
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class MovieRepository(private val movieApi: MovieServices, private val myMovieDao: MyMovieDao) {

    fun getMovieList() : Observable<Movies> {
        return movieApi.getListMovie(Constant.MovieAPIKey, 1).compose(RxUtils.applyObservableAsync())
    }

    fun getMovieDetail(idMovie: Int) : Observable<MovieDetail> {
        return movieApi.getMovieDetail(idMovie, Constant.MovieAPIKey).compose(RxUtils.applyObservableAsync())
    }

    suspend fun saveFavorite(movie: MovieItem) {
        myMovieDao.insertMovie(movie)
    }

    fun getFavorite(movieId: Int): LiveData<MovieItem> {
        return myMovieDao.getMovieById(movieId)
    }

    suspend fun deleteFavorite(movieId: Int) {
        myMovieDao.deleteMovieById(movieId)
    }

    fun getFavoriteMovies(): LiveData<List<MovieItem>> {
        return myMovieDao.getMoviesFavorites()
    }
}