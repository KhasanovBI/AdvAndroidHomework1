package com.bulat.advandroidhomework1;

import android.support.test.rule.ActivityTestRule;
import android.test.suitebuilder.annotation.SmallTest;

import com.bulat.advandroidhomework1.model.Record;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

/**
 * Created by bulat on 15.10.15.
 */
@RunWith(Parameterized.class)
@SmallTest
public class IncorrectStringFormatOfIntegerTest {
    @Parameters(name = "{index}:test({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, "ноль"},
                {-1, "минус один"},
                {1001, "тысяча один"},
                {1, "один "},
                {55, "пятьдесят  пять"},
                {342, "триста сорок  два"},
        });
    }

    @Parameter
    public int index;
    @Parameter(value = 1)
    public String stringFormatOfInteger;
    private Record record;

    @ClassRule
    public static ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @BeforeClass
    public static void init() {
        Record.buildStringFormatOfIntegers(mActivityRule.getActivity());
    }

    @Before
    public void initRecord() {
        record = new Record(index);
    }

    @Test
    public void checkIncorrectStrings() {
        Assert.assertFalse(stringFormatOfInteger.equals(record.getIndexStringFormat()));
    }
}
