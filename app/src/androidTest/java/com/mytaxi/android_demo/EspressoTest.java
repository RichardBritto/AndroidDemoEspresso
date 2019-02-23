package com.mytaxi.android_demo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.*;

import android.support.test.rule.ActivityTestRule;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        //Before Test case execution
        mActivity = mActivityRule.getActivity();
    }

    @Test
    public void aensureLoginScreen() {
        // Type text and then press the button.
        onView(withId(R.id.edt_password)).check(matches(isDisplayed()));
        onView(withId(R.id.edt_username)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_login)).perform(click());
    }

    @Test
    public void benterTextInField() {
        onView((withId(R.id.edt_username)))
                .perform(typeText("crazydog335"));
        onView(withId(R.id.edt_password))
                .perform(typeText("venture"));
        onView(withId(R.id.btn_login)).perform(click());
    }

    @Test
    public void censureLandingScreen() {
        onView(withId(R.id.textSearch)).check(matches(isDisplayed()));
    }

    @Test
    public void denterTextInSearchField() {
        //onView((withId(R.id.textSearch)))
                //.perform(typeText("sa"));
        onView(withId(R.id.textSearch))
                .perform(typeText("sa"));
        onView(withText("Sarah Scott")).inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))));
        onView(withText("Sarah Scott"))
                .inRoot(withDecorView(not(is(mActivity.getWindow().getDecorView()))))
                .perform(click());
        onView(withId(R.id.fab)).perform(click());

    }
    @Test
    public void eclickLogoutButton(){
        onView(withClassName(endsWith("ImageButton"))).perform(click());
        onView(withId(R.id.design_menu_item_text)).perform(click());
    }

    @After
    public void tearDown() throws Exception {
        //After Test case Execution
    }
}

