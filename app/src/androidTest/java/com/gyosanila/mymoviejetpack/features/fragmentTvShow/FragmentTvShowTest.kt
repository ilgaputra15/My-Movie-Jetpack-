package com.gyosanila.mymoviejetpack.features.fragmentTvShow

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResourceTvShow
import com.gyosanila.mymoviejetpack.features.dashboard.DashboardActivity
import org.junit.After
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 20:57
 * Division Mobile - PT.Homecareindo Global Medika
 */

@RunWith(AndroidJUnit4::class)
class FragmentTvShowTest {

    @Rule
    @JvmField var activity = ActivityTestRule(DashboardActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResourceTvShow.getEspressoIdlingResourceForMainActivity())
        onView(ViewMatchers.withText(R.string.text_title_tv_show)).perform(ViewActions.click())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResourceTvShow.getEspressoIdlingResourceForMainActivity())
    }

    @Test
    fun showTvShowFragment() {
        onView(withId(R.id.recyclerViewTvShow)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.recyclerViewTvShow)).perform(scrollToPosition<RecyclerView.ViewHolder>(5))
        onView(withId(R.id.recyclerViewTvShow)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        onView(withId(R.id.textTitle)).check(matches(ViewMatchers.isDisplayed()))
    }
}