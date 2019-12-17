package com.gyosanila.mymoviejetpack.features.fragmentFavoriteTvShows

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResourceTvShow
import com.gyosanila.mymoviejetpack.features.favorites.FavoritesActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by ilgaputra15
 * on Sunday, 01/12/2019 20:16
 * Division Mobile - PT.Homecareindo Global Medika
 */

@RunWith(AndroidJUnit4::class)
class FragmentFavoriteTvShowsTest {
    @Rule
    @JvmField
    var activity = ActivityTestRule(FavoritesActivity::class.java)

    @Before
    fun setup() {
        IdlingRegistry.getInstance()
            .register(EspressoIdlingResourceTvShow.getEspressoIdlingResourceForMainActivity())
        Espresso.onView(ViewMatchers.withText(R.string.text_title_tv_show))
            .perform(ViewActions.click())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance()
            .unregister(EspressoIdlingResourceTvShow.getEspressoIdlingResourceForMainActivity())
    }

    @Test
    @Throws(Exception::class)
    fun showTvShowFragment() {
        try {
            Espresso.onView(ViewMatchers.withId(R.id.recyclerViewFavoriteTvShows))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Espresso.onView(ViewMatchers.withId(R.id.recyclerViewFavoriteTvShows))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        } catch (e: NoMatchingViewException) {
            Espresso.onView(ViewMatchers.withId(R.id.textViewNoDataTvShow))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        }
    }

    @Test
    @Throws(Exception::class)
    fun showMovieFragmentDetail() {
        try {
            Espresso.onView(ViewMatchers.withId(R.id.recyclerViewFavoriteTvShows))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            Espresso.onView(ViewMatchers.withId(R.id.recyclerViewFavoriteTvShows)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    ViewActions.click()
                )
            )
            Espresso.onView(ViewMatchers.withId(R.id.textTitle))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        } catch (e: NoMatchingViewException) {
            Espresso.onView(ViewMatchers.withId(R.id.textViewNoDataTvShow))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        }
    }
}