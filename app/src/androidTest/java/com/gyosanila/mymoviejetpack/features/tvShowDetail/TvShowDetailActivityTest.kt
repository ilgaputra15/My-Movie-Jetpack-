package com.gyosanila.mymoviejetpack.features.tvShowDetail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.gyosanila.mymoviejetpack.R
import com.gyosanila.mymoviejetpack.core.utils.EspressoIdlingResource
import com.gyosanila.mymoviejetpack.data.model.TvShowItem
import com.gyosanila.mymoviejetpack.features.utils.FakeDataDummy
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by ilgaputra15
 * on Saturday, 09/11/2019 21:28
 * Division Mobile - PT.Homecareindo Global Medika
 */
@RunWith(AndroidJUnit4::class)
class TvShowDetailActivityTest {

    @Rule
    @JvmField var activityRule = ActivityTestRule(TvShowDetailActivity::class.java, true, false)
    private var  dummyTvShow: TvShowItem = FakeDataDummy.getTvShowItem()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
        val intent = Intent()
        intent.putExtra(TvShowDetailActivity.TV_SHOW, dummyTvShow)
        activityRule.launchActivity(intent)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
    }

    @Test
    fun loadMovieDetail() {
        onView(withId(R.id.textTitle)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textPublishAt)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textValueGenres)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textValueOverview)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textValueCreatedBy)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textValuePopularity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.textValueVoteAverage)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}