package com.gyosanila.mymoviejetpack.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.data.model.TvShowItem

/**
 * Created by ilgaputra15
 * on Sunday, 24/11/2019 22:37
 * Division Mobile - PT.Homecareindo Global Medika
 **/

@Dao
interface MyMovieDao {

    @Query("SELECT * from movie_table ORDER BY id ASC")
    fun getMoviesFavorites(): DataSource.Factory<Int, MovieItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(word: MovieItem)

    @Query("DELETE FROM movie_table WHERE id = :idMovie")
    suspend fun deleteMovieById(idMovie: Int)

    @Query("SELECT * from movie_table WHERE id = :idMovie")
    fun getMovieById(idMovie: Int): LiveData<MovieItem>

    @Query("DELETE FROM movie_table")
    fun deleteAllMovie()



    @Query("SELECT * from tv_show_table ORDER BY id ASC")
    fun getTvShowFavorites(): DataSource.Factory<Int,TvShowItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTvShow(word: TvShowItem)

    @Query("DELETE FROM tv_show_table WHERE id = :idMovie")
    suspend fun deleteTvShowById(idMovie: Int)

    @Query("SELECT * from tv_show_table WHERE id = :idMovie")
    fun getTvShowById(idMovie: Int): LiveData<TvShowItem>

    @Query("DELETE FROM tv_show_table")
    fun deleteAllTvShow()







}