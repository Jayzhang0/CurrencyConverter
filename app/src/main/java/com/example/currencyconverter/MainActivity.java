package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    static EditText value1, value2;
    Spinner spinner1, spinner2;
    Button convert;
    static String currency1, currency2;
    void setupListeners() {
        spinner1.setOnItemSelectedListener(new spinner1());
        spinner2.setOnItemSelectedListener(new spinner2());
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetch a = new fetch();
                a.execute(value1.getText().toString());
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
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.option, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.option, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        convert = findViewById(R.id.convert);
        setupListeners();
    }

    class spinner1 implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> a, View b, int c, long d) {
            currency1 = a.getItemAtPosition(c).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> a) {}
    }

    class spinner2 implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> a, View b, int c, long d) {
            currency2 = a.getItemAtPosition(c).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> a) {}
    }

    static class fetch extends AsyncTask<String, Void, Void> {
        String result;
        @Override
        protected Void doInBackground(String... params) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("https://frankfurter.app/latest?amount=" +
                    params[0] + "&from=" + currency1 + "&to=" + currency2).build();
            try {
                Response response = client.newCall(request).execute();
                result = response.body().string();
            } catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void v) {
            try {
                value2.setText(new JSONObject(result).getJSONObject("rates").getString(currency2));
            } catch (Exception e) {
            }
            super.onPostExecute(v);
        }
    }
}
