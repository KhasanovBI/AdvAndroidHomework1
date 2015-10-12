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
        List<String> stringList = new ArrayList<>();
        int copyOfNumber = number;
        int thousandsCount = copyOfNumber / 1000;
        if (thousandsCount > 0) {
            stringList.add(stringFormatIntegerMap.get(1000 * thousandsCount));
        }
        copyOfNumber %= 1000;
        int hundredsCount = copyOfNumber / 100;
        if (hundredsCount > 0) {
            stringList.add(stringFormatIntegerMap.get(100 * hundredsCount));
        }
        copyOfNumber %= 100;
        if (copyOfNumber >= 10 && copyOfNumber<=19) {
            stringList.add(stringFormatIntegerMap.get(copyOfNumber));
        } else {
            int tensCount = copyOfNumber / 10;
            if (tensCount > 0) {
                stringList.add(stringFormatIntegerMap.get(10 * tensCount));
            }
            copyOfNumber %= 10;
            if (copyOfNumber > 0) {
                stringList.add(stringFormatIntegerMap.get(copyOfNumber));
            }
        }
        return TextUtils.join(" ", stringList);
    }
}
