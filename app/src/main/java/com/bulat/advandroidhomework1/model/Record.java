package com.bulat.advandroidhomework1.model;

/**
 * Created by bulat on 08.10.15.
 */
public class Record {
    private int index;
    private String indexString;

    public Record(int index) {
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

    private String getStringFormatOfInteger(Integer number) {
        Integer copyOfNumber = number;
        int ones = copyOfNumber % 10;
        StringBuilder stringBuilder = new StringBuilder();
        copyOfNumber /= 10;
        int tens = 0;
        if (copyOfNumber != 0) {
            tens = copyOfNumber % 10;
            copyOfNumber /= 10;
            if (copyOfNumber != 0) {
                int hundreds = copyOfNumber % 10;
                copyOfNumber /= 10;
                if (copyOfNumber != 0) {
                    return "тысяча";
                }
                String hundredsStringFormat;
                switch (hundreds) {
                    case 1:
                        hundredsStringFormat = "сто";
                        break;
                    case 2:
                        hundredsStringFormat = "двести";
                        break;
                    case 3:
                        hundredsStringFormat = "триста";
                        break;
                    case 4:
                        hundredsStringFormat = "четыреста";
                        break;
                    case 5:
                        hundredsStringFormat = "пятьсот";
                        break;
                    case 6:
                        hundredsStringFormat = "шестьсот";
                        break;
                    case 7:
                        hundredsStringFormat = "семьсот";
                        break;
                    case 8:
                        hundredsStringFormat = "восемьсот";
                        break;
                    case 9:
                        hundredsStringFormat = "девятьсот";
                        break;
                    default:
                        hundredsStringFormat = "";
                        break;
                }
                stringBuilder.append(hundredsStringFormat);
                if (stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                    stringBuilder.append(" ");
                }
            }
            String tensStringFormat;
            switch (tens) {
                case 1:
                    switch (ones) {
                        case 1:
                            tensStringFormat = "одиннадцать";
                            break;
                        case 2:
                            tensStringFormat = "двенадцать";
                            break;
                        case 3:
                            tensStringFormat = "тринадцать";
                            break;
                        case 4:
                            tensStringFormat = "четырнадцать";
                            break;
                        case 5:
                            tensStringFormat = "пятнадцать";
                            break;
                        case 6:
                            tensStringFormat = "шестнадцать";
                            break;
                        case 7:
                            tensStringFormat = "семнадцать";
                            break;
                        case 8:
                            tensStringFormat = "восемнадцать";
                            break;
                        case 9:
                            tensStringFormat = "девятнадцать";
                            break;
                        default:
                            tensStringFormat = "десять";
                            break;
                    }
                    break;
                case 2:
                    tensStringFormat = "двадцать";
                    break;
                case 3:
                    tensStringFormat = "тридцать";
                    break;
                case 4:
                    tensStringFormat = "сорок";
                    break;
                case 5:
                    tensStringFormat = "пятьдесят";
                    break;
                case 6:
                    tensStringFormat = "шестьдесят";
                    break;
                case 7:
                    tensStringFormat = "семьдесят";
                    break;
                case 8:
                    tensStringFormat = "восемьдесят";
                    break;
                case 9:
                    tensStringFormat = "девяносто";
                    break;
                default:
                    tensStringFormat = "";
                    break;
            }
            stringBuilder.append(tensStringFormat);
            if (stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                stringBuilder.append(" ");
            }
        }
        String onesStringFormat;
        if (tens != 1) {
            switch (ones) {
                case 1:
                    onesStringFormat = "один";
                    break;
                case 2:
                    onesStringFormat = "два";
                    break;
                case 3:
                    onesStringFormat = "три";
                    break;
                case 4:
                    onesStringFormat = "четыре";
                    break;
                case 5:
                    onesStringFormat = "пять";
                    break;
                case 6:
                    onesStringFormat = "шесть";
                    break;
                case 7:
                    onesStringFormat = "семь";
                    break;
                case 8:
                    onesStringFormat = "восемь";
                    break;
                case 9:
                    onesStringFormat = "девять";
                    break;
                default:
                    onesStringFormat = "";
                    break;
            }
            stringBuilder.append(onesStringFormat);
            if (stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                stringBuilder.append(" ");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
