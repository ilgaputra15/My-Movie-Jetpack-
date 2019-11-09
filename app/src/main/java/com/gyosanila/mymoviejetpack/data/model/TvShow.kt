package com.gyosanila.mymoviejetpack.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 10:05
 * Division Mobile - PT.Homecareindo Global Medika
 **/

@Parcelize
data class TvShow (
    val id: Int,
    val original_name: String?,
    val overview: String?,
    val genre_ids: List<String>,
    val name: String?,
    val popularity: Double?,
    val origin_country: List<String>,
    val vote_count: Long?,
    val first_air_date: String?,
    val backdrop_path: String?,
    val original_language: String?,
    val vote_average: Double?,
    val poster_path: String?
): Parcelable