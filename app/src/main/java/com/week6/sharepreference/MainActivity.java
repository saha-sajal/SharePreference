package com.week6.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences("sp-file", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();


        EditText keyEditText = findViewById(R.id.editTextKey);
        EditText valueEditText = findViewById(R.id.editTextValue);

        Button save = findViewById(R.id.buttonSave);
        Button read = findViewById(R.id.buttonRead);

        TextView result = findViewById(R.id.textViewRead);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = keyEditText.getText().toString();
                int value = Integer.parseInt(valueEditText.getText().toString());

                editor.putInt(key, value);
                editor.apply();

                Log.e("Saved", "SP");
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int defaultValue = 0;
                int highScore = sharedPref.getInt("Score", defaultValue);

                result.setText(String.valueOf(highScore));


            }
        });



    }
}