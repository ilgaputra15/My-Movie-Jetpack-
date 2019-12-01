package com.gyosanila.mymoviejetpack.features.movieDetail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResourceMovie
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResourceTvShow
import com.gyosanila.mymoviejetpack.data.model.MovieItem
import com.gyosanila.mymoviejetpack.features.utils.FakeDataDummy
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 21:07
 * Division Mobile - PT.Homecareindo Global Medika
 */

@RunWith(AndroidJUnit4::class)
class MovieDetailActivityTest {

    @Rule
    @JvmField var activityRule = ActivityTestRule(MovieDetailActivity::class.java, true, false)

    private var movieItem: MovieItem = FakeDataDummy.getMovieItem()
    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResourceMovie.getEspressoIdlingResourceForMainActivity())
        val intent = Intent()
        intent.putExtra(MovieDetailActivity.MOVIE, movieItem)
        activityRule.launchActivity(intent)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResourceMovie.getEspressoIdlingResourceForMainActivity())
    }

    @Test
    fun loadMovieDetail() {

        onView(withId(R.id.textTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.textPublishAt)).check(matches(isDisplayed()))
        onView(withId(R.id.textValueLanguage)).check(matches(isDisplayed()))
        onView(withId(R.id.textValueOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.textValueVoteAverage)).check(matches(isDisplayed()))
    }

    @Test
    fun selectFavorite() {
        onView(withId(R.id.action_add_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.action_add_favorite)).perform(ViewActions.click())
    }


}