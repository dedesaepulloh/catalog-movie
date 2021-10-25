package com.dedesaepulloh.catalogmovie

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dedesaepulloh.catalogmovie.ui.genre.GenreActivity
import com.dedesaepulloh.catalogmovie.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CatalogActivityTest {

    @get:Rule
    var activityRule = ActivityScenarioRule(GenreActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadGenre() {
        onView(withId(R.id.rv_genre))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        pressBack()
    }

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_genre))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        pressBack()
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_genre))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        onView(withId(R.id.ri_poster))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_title))
            .check(matches(isDisplayed()))
        onView(withId(R.id.label_release))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_release))
            .check(matches(isDisplayed()))
        onView(withId(R.id.label_popularity))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_popularity))
            .check(matches(isDisplayed()))
        onView(withId(R.id.label_rate))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_rate))
            .check(matches(isDisplayed()))
        onView(withId(R.id.label_vote))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote))
            .check(matches(isDisplayed()))
        onView(withId(R.id.label_overview))
            .check(matches(isDisplayed()))
        onView(withId(R.id.tv_overview))
            .check(matches(isDisplayed()))
        onView(withId(R.id.label_trailer))
            .check(matches(isDisplayed()))
//        onView(withId(R.id.main_webview))
//            .check(matches(isDisplayed()))
        onView(withId(R.id.btn_review))
            .check(matches(isDisplayed()))

        pressBack()
    }

    @Test
    fun loadReview() {
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        onView(withId(R.id.btn_review))
            .check(matches(isDisplayed()))

        onView(withId(R.id.btn_review))
            .perform(click())

        onView(withId(R.id.rv_review))
            .check(matches(isDisplayed()))

        pressBack()
    }

    @Test
    fun loadReviewDetail() {
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        onView(withId(R.id.rv_genre)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                3
            )
        )
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                3,
                click()
            )
        )
        onView(withId(R.id.btn_review))
            .perform(click())

        onView(withId(R.id.rv_review))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_review)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                1
            )
        )
        onView(withId(R.id.rv_review)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                click()
            )
        )
        pressBack()
    }
}