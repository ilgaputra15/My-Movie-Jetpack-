package com.gyosanila.mymoviejetpack.core.extension

import android.view.View

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 19:10
 * Division Mobile - PT.Homecareindo Global Medika
 **/

var View.visible: Boolean
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if(value) View.VISIBLE else View.GONE
    }
