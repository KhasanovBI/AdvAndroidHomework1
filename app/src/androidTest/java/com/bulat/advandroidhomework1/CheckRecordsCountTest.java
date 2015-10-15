package com.bulat.advandroidhomework1;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;

/**
 * Created by bulat on 11.10.15.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class CheckRecordsCountTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void isRecordsCountCorrect() {
        Activity mainActivity = mActivityRule.getActivity();
        RecyclerView recyclerView = (RecyclerView) mainActivity.findViewById(R.id.recycler_view);
        int RECORDS_COUNT = 0;
        try {
            Field field = mainActivity.getClass().getDeclaredField("RECORDS_COUNT");
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            RECORDS_COUNT = (int) field.get(mainActivity);
            field.setAccessible(isAccessible);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(RECORDS_COUNT, recyclerView.getAdapter().getItemCount());
    }
}
