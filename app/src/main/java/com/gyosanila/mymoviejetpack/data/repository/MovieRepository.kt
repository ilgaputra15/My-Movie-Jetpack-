package com.gyosanila.mymoviejetpack.data.repository

import com.gyosanila.mymoviejetpack.core.common.Constant
import com.gyosanila.mymoviejetpack.core.utils.RxUtils
import com.gyosanila.mymoviejetpack.data.model.MovieDetail
import com.gyosanila.mymoviejetpack.data.model.Movies
import com.gyosanila.mymoviejetpack.data.remote.MovieServices
import io.reactivex.Observable

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 13:51
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class MovieRepository(private val movieApi: MovieServices) {


    fun getMovieList() : Observable<Movies> {
        return movieApi.getListMovie(Constant.MovieAPIKey, 1).compose(RxUtils.applyObservableAsync())
    }

    fun getMovieDetail(idMovie: Int) : Observable<MovieDetail> {
        return movieApi.getMovieDetail(idMovie, Constant.MovieAPIKey).compose(RxUtils.applyObservableAsync())
    }
}