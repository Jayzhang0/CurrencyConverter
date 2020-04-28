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
    String from, to;
    void setupListeners() {
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
        value1 = findViewById(R.id.from);
        value2 = findViewById(R.id.to);
        convert = findViewById(R.id.convert);
    }
}
