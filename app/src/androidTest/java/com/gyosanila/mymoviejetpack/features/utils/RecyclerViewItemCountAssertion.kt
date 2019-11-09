package com.gyosanila.mymoviejetpack.features.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import junit.framework.TestCase.assertNotNull
import org.hamcrest.CoreMatchers.`is`


/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 20:37
 * Division Mobile - PT.Homecareindo Global Medika
 **/
class RecyclerViewItemCountAssertion(private val expectedCount: Int) : ViewAssertion {

    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }

        val recyclerView = view as RecyclerView
        val adapter = recyclerView.adapter
        assertNotNull(adapter)
        assertThat(adapter!!.itemCount, `is`(expectedCount))
    }
}