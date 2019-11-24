package com.gyosanila.mymoviejetpack.data.remote

import com.gyosanila.mymoviejetpack.data.model.TvShowDetail
import com.gyosanila.mymoviejetpack.data.model.TvShows
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by ilgaputra15
 * on Tuesday, 19/11/2019 22:20
 * Division Mobile - PT.Homecareindo Global Medika
 **/

interface TvShowServices {
    @GET("3/tv/popular")
    fun getListTvShow(
        @Query("api_key") api_key: String,
        @Query("page") page: Int
    ) : Observable<TvShows>

    @GET("3/tv/{id}")
    fun getTvShowDetail(
        @Path("id") id: Int,
        @Query("api_key") api_key: String
    ) : Observable<TvShowDetail>
}