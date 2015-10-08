package com.bulat.advandroidhomework1;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bulat.advandroidhomework1.adapters.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> list = new ArrayList<>();
        populateIntegers(list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();

        mRecyclerView.setAdapter(recyclerViewAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(itemAnimator);
    }

    private void populateIntegers(List<Integer> list) {
        for (int i = 1; i <= 1000; ++i) {
            list.add(i);
        }
    }

}
