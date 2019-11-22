package com.gyosanila.mymoviejetpack.features.utils

import java.io.File

object JsonUtils {
    fun getJson(path: String) : String {
        val uri = this.javaClass.classLoader?.getResource(path)
        val file = File(uri?.path!!)
        return String(file.readBytes())
    }
}
