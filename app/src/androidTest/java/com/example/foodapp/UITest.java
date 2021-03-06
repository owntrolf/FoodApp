package com.example.foodapp;

import android.support.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITest {
    private String foodToSearch;
    private String notWanted;

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);
    @Before
    public void initValidString() {
        foodToSearch = "chicken";
        notWanted = "beef";
    }

    @Test
    public void testSearch() throws InterruptedException {
        onView(withId(R.id.editTextIngred)).perform(typeText(foodToSearch), closeSoftKeyboard());
        onView(withId(R.id.editTextNiR)).perform(typeText(notWanted), closeSoftKeyboard());

        onView(withId(R.id.cbTreeNut)).perform(click());
        onView(withId(R.id.cbPeanutFree)).perform(click());
        onView(withId(R.id.cbVegetarian)).perform(click());
        onView(withId(R.id.cbVegan)).perform(click());
        onView(withId(R.id.cbAlcoholFree)).perform(click());

        onView(withId(R.id.btnSearch)).perform(click());

        onView(withId(R.id.btnPrev)).perform(click());
        onView(withId(R.id.imageView1)).perform(click());
        pressBack();
        onView(withId(R.id.imageView2)).perform(click());
        onView(withId(R.id.btnSource)).perform(click());
    }

}
