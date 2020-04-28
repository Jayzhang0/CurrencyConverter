package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class frontpage extends AppCompatActivity {
    private Button openButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);

        openButton = findViewById(R.id.button);
        openButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View a) {
                openMainactivity();
            }
        });
    }
    public void openMainactivity() {
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}
