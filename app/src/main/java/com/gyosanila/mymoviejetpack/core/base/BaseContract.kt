package com.gyosanila.mymoviejetpack.core.base

import android.content.Context

/**
 * Created by ilgaputra15
 * on Wednesday, 15/05/2019 15:47
 * Division Mobile - PT.Homecareindo Global Medika
 **/


interface BaseViewInterface {
    fun getContext(): Context
    fun getIntentExtra()
    fun setup()
    fun showDialog()
    fun hideDialog()
    fun connectionError(error: Throwable)
}