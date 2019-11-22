package com.gyosanila.mymoviejetpack.features.dashboard

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResource
import com.gyosanila.mymoviejetpack.features.utils.RecyclerViewItemCountAssertion
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 20:26
 * Division Mobile - PT.Homecareindo Global Medika
 */

@RunWith(AndroidJUnit4::class)
class DashboardActivityTest {

    @Rule
    @JvmField var activity = ActivityTestRule(DashboardActivity::class.java)

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
    }

    @Test
    fun onEachButtonNavigationClickTest(){
        onView(ViewMatchers.withText(R.string.text_title_movie)).perform(click())
        Thread.sleep(1000)

        onView(ViewMatchers.withText(R.string.text_title_tv_show)).perform(click())
        Thread.sleep(1000)
    }

    @Test
    fun showMovieFragment() {
        onView(ViewMatchers.withText(R.string.text_title_movie)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.recyclerViewMovie)).check(matches(isDisplayed()))

    }

    @Test
    fun showTvShowFragment() {
        onView(ViewMatchers.withText(R.string.text_title_tv_show)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.recyclerViewTvShow)).check(matches(isDisplayed()))

    }
}