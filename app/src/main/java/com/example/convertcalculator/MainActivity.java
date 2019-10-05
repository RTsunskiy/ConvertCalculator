package com.example.convertcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView quantitiesRV = findViewById(R.id.quantities_rv);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        quantitiesRV.setLayoutManager(manager);
        QuantitiesAdapter adapter = new QuantitiesAdapter(Arrays.asList(getResources().getStringArray(R.array.quantities_array)), this);
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        quantitiesRV.addItemDecoration(decoration);
        quantitiesRV.setAdapter(adapter);
    }
}
