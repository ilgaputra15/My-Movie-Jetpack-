package com.gyosanila.mymoviejetpack.features.tvShowDetail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.data.repository.TvShowRepository
import org.junit.Before

import org.junit.Rule
import org.junit.Test

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 21:28
 * Division Mobile - PT.Homecareindo Global Medika
 */
class TvShowDetailActivityTest {

    private val dummyTvShow = TvShowRepository().getTvShowsDummy()[0]

    @Rule
    @JvmField var activityRule = ActivityTestRule(TvShowDetailActivity::class.java, true, false)


    @Before
    fun setUp() {
        val intent = Intent()
        intent.putExtra(TvShowDetailActivity.TV_SHOW_ID, dummyTvShow.id)
        activityRule.launchActivity(intent)
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.textTitle))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textTitle))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow.name)))
        onView(withId(R.id.textPublishAt))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textPublishAt))
            .check(ViewAssertions.matches(ViewMatchers.withText("(${dummyTvShow.first_air_date})")))
        onView(withId(R.id.textValueGenres))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textValueGenres))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow.genre_ids.toString())))
        onView(withId(R.id.textValueOverview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textValueOverview))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow.overview)))
        onView(withId(R.id.textValueCreatedBy))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textValueCreatedBy))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow.origin_country.toString())))
        onView(withId(R.id.textValuePopularity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textValuePopularity))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow.popularity.toString())))
        onView(withId(R.id.textValueVoteAverage))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textValueVoteAverage))
            .check(ViewAssertions.matches(ViewMatchers.withText(dummyTvShow.vote_average.toString())))

    }
}