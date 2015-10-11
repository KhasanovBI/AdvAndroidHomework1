package com.bulat.advandroidhomework1;


import android.test.suitebuilder.annotation.SmallTest;

import com.bulat.advandroidhomework1.model.Record;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@SmallTest
public class StringFormatOfIntegerTest {
    private Record record;
    private int index = 888;
    @Before
    public void init() {
        record = new Record(index);
    }
    @Test
    public void isCorrectString() throws Exception {
        assertEquals("восемьсот восемьдесят восемь", record.getIndexStringFormat());
    }
}