package com.example.evaluacion_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TerceraActivity extends AppCompatActivity {

    private RadioGroup rg_genero;
    private Button btn_volver3;
    private Button btn_validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        rg_genero = findViewById(R.id.rg_genero);
        btn_volver3 = findViewById(R.id.btn_volver3);
        btn_validar = findViewById(R.id.btn_validar);

        btn_validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar();
            }

            private void validar() {
                // Inicializar una cadena para almacenar el género seleccionado
                String genero = "";

                // Obtener el ID del RadioButton seleccionado en el RadioGroup
                int selectedId = rg_genero.getCheckedRadioButtonId();

                // Comprobar cuál RadioButton se seleccionó y asignar el género correspondiente
                if (selectedId == R.id.rb_masculino) {
                    genero = "Masculino";
                } else if (selectedId == R.id.rb_femenino) {
                    genero = "Femenino";
                }

                // Crear un Intent
                Intent intent5 = new Intent(TerceraActivity.this, SegundaActivity.class);

                // Agregar el género al Intent como un extra
                intent5.putExtra("genero", genero);

                setResult(RESULT_OK, intent5);
                finish();
            }
        });

        btn_volver3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crear un Intent para volver a la SegundaActivity
                Intent intent4 = new Intent(TerceraActivity.this, SegundaActivity.class);
                startActivity(intent4);
            }
        });
    }
}