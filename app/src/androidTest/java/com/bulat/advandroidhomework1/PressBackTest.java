package com.bulat.advandroidhomework1;

import android.support.test.espresso.NoActivityResumedException;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class PressBackTest {
    @Rule
    public ActivityTestRule<FullscreenStartActivity> mActivityRule = new ActivityTestRule<>(
            FullscreenStartActivity.class);

    @Test
    public void isKilledWhenPressBack() {
        boolean isKilled = false;
        try {
            onView(withId(R.id.activity_main_layout)).perform(pressBack());
        } catch (NoActivityResumedException e) {
            isKilled = true;
        }
        if (!isKilled) {
            Assert.assertTrue("FullscreenStartActivity alive, but must die.", false);
        }
    }
}