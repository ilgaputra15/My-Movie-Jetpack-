package com.gyosanila.mymoviejetpack.data.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 10:05
 * Division Mobile - PT.Homecareindo Global Medika
 **/

data class TvShows(
    @Json(name = "results") val results: List<TvShowItem>,
    @Json(name = "page") val page: Int,
    @Json(name = "total_results") val total_results: Int,
    @Json(name = "dates") val dates: DateRange,
    @Json(name = "total_pages") val total_pages: Int
)

@Parcelize
data class TvShowItem(
    @PrimaryKey @Json(name = "id") val id: Int,
    @Json(name = "vote_count") val vote_count: Int,
    @Json(name = "original_name") val original_name: String,
    @Json(name = "vote_average") val vote_average: Double,
    @Json(name = "name") val name: String,
    @Json(name = "popularity") val popularity: Double,
    @Json(name = "poster_path") val poster_path: String,
    @Json(name = "original_language") val original_language: String,
    @Json(name = "overview") val overview: String
) : Parcelable


@Parcelize
data class TvShowDetail(
    @Json(name = "backdrop_path") val backdrop_path: String,
    @Json(name = "homepage") val homepage: String,
    @Json(name = "id") val id: Int,
    @Json(name = "original_language") val original_language: String,
    @Json(name = "original_name") val original_name: String,
    @Json(name = "name") val name: String,
    @Json(name = "overview") val overview: String,
    @Json(name = "popularity") val popularity: Double,
    @Json(name = "poster_path") val poster_path: String,
    @Json(name = "origin_country") val origin_country: List<String>,
    @Json(name = "first_air_date") val first_air_date: String,
    @Json(name = "status") val status: String,
    @Json(name = "vote_average") val vote_average: Double,
    @Json(name = "vote_count") val vote_count: Int,
    @Json(name = "genres") val genres: List<Genres>,
    @Json(name = "languages") val languages: List<String>,
    @Json(name = "seasons") val seasons: List<Session>,
    @Json(name = "created_by") val created_by: List<CreateBy>
): Parcelable

@Parcelize
data class CreateBy(
    @Json(name = "name") val name: String
): Parcelable

@Parcelize
data class Session(
    @Json(name = "name") val name: String,
    @Json(name = "overview") val overview: String,
    @Json(name = "poster_path") val poster_path: String,
    @Json(name = "season_number") val season_number: Int
): Parcelable

@Parcelize
data class Genres(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String
): Parcelable