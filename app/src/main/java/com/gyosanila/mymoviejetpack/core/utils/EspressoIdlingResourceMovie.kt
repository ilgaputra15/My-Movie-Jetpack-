package com.gyosanila.mymoviejetpack.core.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource



/**
 * Created by ilgaputra15
 * on Friday, 22/11/2019 21:43
 * Division Mobile - PT.Homecareindo Global Medika
 **/
object EspressoIdlingResourceMovie {
    private const val RESOURCE = "GLOBAL2"
    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }

    fun getEspressoIdlingResourceForMainActivity(): IdlingResource {
        return espressoTestIdlingResource
    }
}