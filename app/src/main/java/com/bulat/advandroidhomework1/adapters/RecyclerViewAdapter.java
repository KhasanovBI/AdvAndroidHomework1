package com.bulat.advandroidhomework1.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bulat.advandroidhomework1.R;

import java.util.List;

/**
 * Created by bulat on 08.10.15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecordHolder> {
    private List<Integer> records;

    public RecyclerViewAdapter(List<Integer> records) {
        this.records = records;
    }

    @Override
    public RecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_item, parent, false);
        return new RecordHolder(view);
    }

    @Override
    public void onBindViewHolder(RecordHolder holder, int position) {
        Integer number = records.get(position);
        Log.d("str", number.toString());
        holder.record.setText(getStringFormatOfNumber(number));
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    class RecordHolder extends RecyclerView.ViewHolder {
        private TextView record;

        public RecordHolder(View itemView) {
            super(itemView);
            record = (TextView) itemView.findViewById(R.id.recycler_view_record);
        }
    }

    private String getStringFormatOfNumber(Integer number) {
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
