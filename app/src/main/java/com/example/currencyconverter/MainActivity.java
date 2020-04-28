package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText value1, value2;
    Spinner spinner1, spinner2;
    Button convert;
    String currency1, currency2;
    void setupListeners() {
        spinner1.setOnItemSelectedListener(new spinner1());
        spinner2.setOnItemSelectedListener(new spinner2());
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value1 = findViewById(R.id.currency1);
        value2 = findViewById(R.id.currency2);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        convert = findViewById(R.id.convert);
        setupListeners();
    }
}
