package com.gyosanila.mymoviejetpack.features.fragmentMovie

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResource
import com.gyosanila.mymoviejetpack.features.dashboard.DashboardActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 20:37
 * Division Mobile - PT.Homecareindo Global Medika
 */

@RunWith(AndroidJUnit4::class)
class FragmentMovieTest {

    @Rule
    @JvmField var activity = ActivityTestRule(DashboardActivity::class.java)

    @Before
    fun setup() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
        onView(withText(R.string.text_title_movie)).perform(click())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
    }

    @Test
    fun showMovieFragment() {
        onView(withId(R.id.recyclerViewMovie)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.recyclerViewMovie)).perform(scrollToPosition<RecyclerView.ViewHolder>(5))
        onView(withId(R.id.recyclerViewMovie)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textTitle)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}