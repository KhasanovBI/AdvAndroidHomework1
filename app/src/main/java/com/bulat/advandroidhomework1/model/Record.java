package com.bulat.advandroidhomework1.model;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;

import com.bulat.advandroidhomework1.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by bulat on 08.10.15.
 */
public class Record {
    private int index;
    private String indexString;
    private static Map<Integer, String> stringFormatIntegerMap = null;

    public Record(int index) {
        if (stringFormatIntegerMap == null) {
            try {
                throw new Exception("Run buildStringFormatOfIntegers method in Record class first");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        setIndex(index);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
        indexString = getStringFormatOfInteger(index);
    }

    public String getIndexStringFormat() {
        return indexString;
    }

    public static void buildStringFormatOfIntegers(Context context) {
        XmlResourceParser xmlResourceParser = context.getResources().getXml(R.xml.string_format_integer_map);
        stringFormatIntegerMap = new HashMap<>();
        Integer key = null;
        String value = null;
        try {
            int eventType = xmlResourceParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (xmlResourceParser.getName().equals("entry")) {
                            key = Integer.valueOf(xmlResourceParser.getAttributeValue(null, "key"));
                            if (key == null) {
                                xmlResourceParser.close();
                                return;
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (xmlResourceParser.getName().equals("entry")) {
                            stringFormatIntegerMap.put(key, value);
                            key = null;
                            value = null;
                        }
                        break;
                    case XmlPullParser.TEXT:
                        if (key != null) {
                            value = xmlResourceParser.getText();
                        }
                        break;
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getStringFormatOfInteger(Integer number) {
        if (number > 1000 || number < 0) {
            return null;
        }
        LinkedList<Integer> roundedIntegersList = new LinkedList<>();
        int multiplier = 1;
        if (number / 10 % 10 == 1) {
            multiplier = 100;
            roundedIntegersList.push(number % multiplier);
            number /= multiplier;
        }
        for (; number > 0; multiplier *= 10) {
            int roundedInteger = number % 10 * multiplier;
            if (roundedInteger != 0) {
                roundedIntegersList.push(roundedInteger);
            }
            number = number / 10;
        }
        List<String> stringsList = new ArrayList<>();
        while (roundedIntegersList.size() > 0) {
            stringsList.add(stringFormatIntegerMap.get(roundedIntegersList.pop()));
        }
        return TextUtils.join(" ", stringsList);
    }
}
