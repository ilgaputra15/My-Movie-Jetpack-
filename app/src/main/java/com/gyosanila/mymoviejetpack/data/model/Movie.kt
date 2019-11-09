package com.gyosanila.mymoviejetpack.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by ilgaputra15
 * on Sunday, 08/11/2019 22:41
 * Division Mobile - PT.Homecareindo Global Medika
 **/

@Parcelize
data class Movie(
    val id: Int,
    val title: String?,
    val overview: String?,
    val poster_path: String,
    val original_language: String?,
    val original_title: String?,
    val vote_average: Double?,
    val release_date: String?
) : Parcelable