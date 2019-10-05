package com.example.convertcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ConversationActivity extends AppCompatActivity {

    private List<String> listOfKilometers;
    private TextView itemQuontity;
    private TextView itemResultQuontity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        if (getIntent().getStringExtra("Distance").equals("Расстояние")) {
        setTitle(getIntent().getStringExtra("Distance"));}
        itemResultQuontity = findViewById(R.id.item_quantity_result_tv);
        itemQuontity = findViewById(R.id.item_quantity_tv);
        initKilometerRVAdapter();
        initKilometerResultRVAdapter();
    }

    private void initKilometerRVAdapter() {
        RecyclerView recyclerView = findViewById(R.id.from_rv);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        listOfKilometers = Arrays.asList(getResources().getStringArray(R.array.kilometres_values));
        KilometerAdapter kilometerAdapter = new KilometerAdapter(listOfKilometers, itemQuontity);
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(kilometerAdapter);
    }

    private void initKilometerResultRVAdapter() {
        RecyclerView recyclerView = findViewById(R.id.in_rv);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        listOfKilometers = Arrays.asList(getResources().getStringArray(R.array.kilometres_values));
        KilometerAdapter kilometerAdapter = new KilometerAdapter(listOfKilometers, itemResultQuontity);
        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(kilometerAdapter);
    }
}
