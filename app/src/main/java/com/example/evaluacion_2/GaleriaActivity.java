package com.example.evaluacion_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class GaleriaActivity extends AppCompatActivity {

    ImageView imageView;
    Spinner imageSpinner;
    Button btnInicio;


    private static final String[] imageNames = {"image1", "image2", "image3"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);

        imageView = findViewById(R.id.imageView);
        imageSpinner = findViewById(R.id.imageSpinner);
        btnInicio = findViewById(R.id.btnInicio);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, imageNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        imageSpinner.setAdapter(adapter);

        imageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedImageName = imageNames[position];
                int imageResource = getResources().getIdentifier(selectedImageName, "drawable", getPackageName());
                imageView.setImageResource(imageResource);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goinicio = new Intent(GaleriaActivity.this, MainActivity.class);
                startActivity(goinicio);
            }
        });
    }
}