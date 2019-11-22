package com.gyosanila.mymoviejetpack.core.utils

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ilgaputra15
 * on Tuesday, 19/11/2019 21:21
 * Division Mobile - PT.Homecareindo Global Medika
 **/

object RxUtils {
    fun <T> applyObservableAsync(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}