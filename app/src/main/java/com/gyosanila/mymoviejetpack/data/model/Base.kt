package com.gyosanila.mymoviejetpack.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by ilgaputra15
 * on Tuesday, 19/11/2019 21:21
 * Division Mobile - PT.Homecareindo Global Medika
 **/

@Parcelize
data class DateRange(
    @Json(name = "maximum") val maximum: String,
    @Json(name = "minimum") val minimum: String
) : Parcelable

sealed class ResultResponse {
    data class OnLoading(val isLoading: Boolean) : ResultResponse()
    data class Success<out T : Any?>(val data: T) : ResultResponse()
    data class Error(val error: Throwable) : ResultResponse()
}