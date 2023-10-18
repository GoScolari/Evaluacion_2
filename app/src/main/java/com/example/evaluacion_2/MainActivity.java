package com.example.evaluacion_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declarar variables
    private Button btn_inicio;
    private EditText pt_nombre;
    private TextView tv_instrucciones;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vincular botones
        btn_inicio = findViewById(R.id.btn_inicio);
        pt_nombre = findViewById(R.id.pt_nombre);
        tv_instrucciones = findViewById(R.id.tv_instrucciones);

        //Creacion de metodo LISTENER en el btn_inicio
        btn_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Capturar datos tipo texto
                String nombre = pt_nombre.getText().toString();

                //Creacion de INTENT
                Intent intent = new Intent(MainActivity.this,SegundaActivity.class);

                //Envio de datos a la segundaActivity
                intent.putExtra("nombre", nombre);

                startActivity(intent);

            }
        });

    }
}