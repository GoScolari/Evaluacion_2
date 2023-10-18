package com.example.evaluacion_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    //Declarar variables
    private TextView tv_nombre;
    private Button btn_volver2;
    private Button btn_siguiente;
    private  TextView tv_generorespuesta;
    private Button gotoGaleria;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //Vincular variables a control de vista
        tv_nombre = findViewById(R.id.tv_nombre);
        btn_volver2 = findViewById(R.id.btn_volver);
        btn_siguiente = findViewById(R.id.btn_siguiente);
        tv_generorespuesta = findViewById(R.id.tv_generorespuesta);
        gotoGaleria = findViewById(R.id.btnGoGaleria);

        //Captura de INTENT
        Intent intent = getIntent();
        Intent intent5 = getIntent();

        //Captura de dato
        String nombre = intent.getStringExtra("nombre");
        String genero = intent5.getStringExtra("genero");

        tv_nombre.setText("Bienvenido " + nombre);
        //tv_generorespuesta.setText("Tu genero es " + genero);


        //setear boton volver
        btn_volver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);

                startActivity(intent);

            }
        });

        //Setear boton siguiente
        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SegundaActivity.this, TerceraActivity.class);

                startActivityForResult(intent, 1);

            }
        });

        gotoGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galeria = new Intent(SegundaActivity.this, GaleriaActivity.class);
                startActivity(galeria);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            if (data != null) {
                String genero = data.getStringExtra("genero");
                tv_generorespuesta.setText("Tu Genero es " + genero);
            }
        }
    }
}