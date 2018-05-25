package com.beesham.weatherapp

import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toolbar
import com.beesham.weatherapp.ui.activities.MainActivity
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test

class SimpleImplementationTest {

    @get: Rule val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun itemClick_navigatesToDetail() {
        onView(withId(R.id.forecastList)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        onView(withId(R.id.weatherDescription))
                .check(matches(isAssignableFrom(TextView::class.java)))
    }

    @Test
    fun modifyZipCode_changesToolbarTitle() {
        openActionBarOverflowOrOptionsMenu(activityRule.activity)
        onView(withText(R.string.settings)).perform(click())
        onView(withId(R.id.cityCode)).perform(replaceText("28830"))
        pressBack()
        onView(isAssignableFrom(Toolbar::class.java))
                .check(matches(withToolbarTitle(`is`("San Fernando de Henares (ES)"))))
    }

    private fun withToolbarTitle(textMathcer: Matcher<CharSequence>): Matcher<Any> =
            object: BoundedMatcher<Any, Toolbar>(Toolbar::class.java) {
                override fun describeTo(description: Description?) {
                    description?.appendText("with toolbar title: ")
                    textMathcer.describeTo(description)
                }

                override fun matchesSafely(toolbar: Toolbar?): Boolean =
                        textMathcer.matches(toolbar?.title)


            }
}