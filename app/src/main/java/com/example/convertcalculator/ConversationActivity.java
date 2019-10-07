package com.example.convertcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ConversationActivity extends AppCompatActivity {

    private List<String> listOfKilometers;
    private TextView itemQuontity;
    private TextView itemResultQuontity;
    private EditText valueInsertET;
    private EditText displayValueET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        valueInsertET = findViewById(R.id.value_insert_et);
        displayValueET = findViewById(R.id.display_value_et);

        itemResultQuontity = findViewById(R.id.item_quantity_result_tv);
        itemQuontity = findViewById(R.id.item_quantity_tv);
        initKilometerRVAdapter();
        initKilometerResultRVAdapter();

        valueInsertET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String outputValue = convertor(valueInsertET.getText().toString(), itemQuontity.getText().toString(), itemResultQuontity.getText().toString());
                displayValueET.setText(outputValue);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        if (getIntent().getStringExtra("Distance").equals("Расстояние")) {
            setTitle(getIntent().getStringExtra("Distance"));
        }

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

    private String convertor(String incomeValue, String incomeMeasurement, String resultMeasurment) {
        double incomeValueInKilometres = converterInKilometres(Integer.parseInt(incomeValue), incomeMeasurement);
        String outputValue = "";
        double out;

        if (resultMeasurment.equals("Милиметр")) {
            out = incomeValueInKilometres * 1000000.0;
                outputValue = Double.toString(out);}
        else if (resultMeasurment.equals("Сантиметр")) {
            out = incomeValueInKilometres * 100000.0;
            outputValue = Double.toString(out);}
        else if (resultMeasurment.equals("Дециметр")) {
            out = incomeValueInKilometres * 10000.0;
            outputValue = Double.toString(out);}
        else if (resultMeasurment.equals("Метр")) {
            out = incomeValueInKilometres * 1000.0;
            outputValue = Double.toString(out);}
        else if (resultMeasurment.equals("Километр")) {
            out = incomeValueInKilometres * 1.0;
            outputValue = Double.toString(out);}

        return outputValue;
    }

    private double converterInKilometres(int incomeValue, String incomeMeasurment) {

        double output = 0.0;

        if (incomeMeasurment.equals("Милиметр")) {
                output = incomeValue / 1000000.0;}
        else if (incomeMeasurment.equals("Сантиметр")) {
            output = incomeValue / 100000.0;}
        else if (incomeMeasurment.equals("Дециметр")) {
            output = incomeValue / 10000.0;}
        else if (incomeMeasurment.equals("Метр")) {
            output = incomeValue / 1000.0;}
        else if (incomeMeasurment.equals("Километр")) {
            output = incomeValue / 1.0;}

   return output;
    }
}


