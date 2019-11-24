package com.gyosanila.mymoviejetpack.data.remote

import com.gyosanila.mymoviejetpack.data.model.MovieDetail
import com.gyosanila.mymoviejetpack.data.model.Movies
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by ilgaputra15
 * on Tuesday, 19/11/2019 21:21
 * Division Mobile - PT.Homecareindo Global Medika
 **/

interface MovieServices {
    @GET("3/movie/upcoming")
    fun getListMovie(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ): Observable<Movies>

    @GET("3/movie/{idMovie}")
    fun getMovieDetail(
        @Path("idMovie") idMovie: Int,
        @Query("api_key") api_key: String
    ): Observable<MovieDetail>

}