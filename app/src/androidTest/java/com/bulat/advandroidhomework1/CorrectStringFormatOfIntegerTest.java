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


@RunWith(Parameterized.class)
@SmallTest
public class CorrectStringFormatOfIntegerTest {
    @Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "один"},
                {15, "пятнадцать"},
                {315, "триста пятнадцать"},
                {22, "двадцать два"},
                {888, "восемьсот восемьдесят восемь"},
                {220, "двести двадцать"},
                {502, "пятьсот два"},
                {1000, "тысяча"},
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
    public void checkCorrectStrings() {
        Assert.assertEquals(stringFormatOfInteger, record.getIndexStringFormat());
    }

}