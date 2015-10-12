package com.bulat.advandroidhomework1;


import android.test.suitebuilder.annotation.SmallTest;

import com.bulat.advandroidhomework1.model.Record;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@SmallTest
public class StringFormatOfIntegerTest {
    private Record record;
    private int index = 888;

    @BeforeClass
    public void init() {
        //Record.buildStringFormatOfIntegers();
    }

    @Before
    public void recordInit() {
        record = new Record(index);
    }

    @Test
    public void isCorrectString() throws Exception {
        Assert.assertEquals("восемьсот восемьдесят восемь", record.getIndexStringFormat());
    }
}