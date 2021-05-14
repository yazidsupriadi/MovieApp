package com.example.movieapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.movieapp.R
import com.example.movieapp.utils.DataDummy
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvshows()

    @Before
    fun setup(){
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }
    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.movie_name)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_name)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.detail_description)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_description)).check(matches(withText( dummyMovie[0].description)))
        onView(withId(R.id.detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_genre)).check(matches(withText( dummyMovie[0].genre)))
        onView(withId(R.id.detail_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_runtime)).check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.detail_director)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_director)).check(matches(withText( dummyMovie[0].director)))
        onView(withId(R.id.detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_rating)).check(matches(withText( dummyMovie[0].rating)))
        onView(withId(R.id.img_detail_profile)).check(matches(isDisplayed()))

    }


    @Test
    fun loadTvShows() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }


    @Test
    fun loadDetailTvshow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.movie_name)).check(matches(isDisplayed()))
        onView(withId(R.id.movie_name)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.detail_description)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_description)).check(matches(withText( dummyTvShow[0].description)))
        onView(withId(R.id.detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_genre)).check(matches(withText( dummyTvShow[0].genre)))
        onView(withId(R.id.detail_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_runtime)).check(matches(withText(dummyTvShow[0].duration)))
        onView(withId(R.id.detail_director)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_director)).check(matches(withText( dummyTvShow[0].director)))
        onView(withId(R.id.detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.detail_rating)).check(matches(withText( dummyTvShow[0].rating)))
        onView(withId(R.id.img_detail_profile)).check(matches(isDisplayed()))

    }

}