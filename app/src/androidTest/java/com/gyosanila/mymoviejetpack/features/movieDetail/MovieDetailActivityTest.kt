package com.gyosanila.mymoviejetpack.features.movieDetail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.data.repository.MovieRepository
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

    private val dummyMovie = MovieRepository().getMoviesDummy()[0]

    @Rule
    @JvmField var activityRule = ActivityTestRule(MovieDetailActivity::class.java, true, false)

    @Before
    fun setUp() {
        val intent = Intent()
        intent.putExtra(MovieDetailActivity.MOVIE_ID, dummyMovie.id)
        activityRule.launchActivity(intent)
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.textTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.textTitle)).check(matches(withText(dummyMovie.title)))
        onView(withId(R.id.textPublishAt)).check(matches(isDisplayed()))
        onView(withId(R.id.textPublishAt)).check(matches(withText("(${dummyMovie.release_date})")))
        onView(withId(R.id.textValueLanguage)).check(matches(isDisplayed()))
        onView(withId(R.id.textValueLanguage)).check(matches(withText(dummyMovie.original_language)))
        onView(withId(R.id.textValueOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.textValueOverview)).check(matches(withText(dummyMovie.overview)))
        onView(withId(R.id.textValueVoteAverage)).check(matches(isDisplayed()))
        onView(withId(R.id.textValueVoteAverage)).check(matches(withText(dummyMovie.vote_average.toString())))
    }


}