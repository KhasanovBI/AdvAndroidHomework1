package com.bulat.advandroidhomework1;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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
        RecyclerView recyclerView = (RecyclerView) mActivityRule.getActivity().findViewById(R.id.recycler_view);
        Assert.assertEquals(1000, recyclerView.getAdapter().getItemCount());
    }
}
