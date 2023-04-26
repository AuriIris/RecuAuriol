package com.example.recuauriol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.annotation.SuppressLint;
import android.content.Intent;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.widget.TextView;

public class CalculoIMC extends AppCompatActivity {
    private TextView estadoIMCTextView;
    private TextView datosPersonaTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        estadoIMCTextView = findViewById(R.id.tvPersona);
        datosPersonaTextView = findViewById(R.id.tvDetalle);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        int edad = intent.getIntExtra("edad", 0);
        String sexo = intent.getStringExtra("sexo");
        double peso = intent.getDoubleExtra("peso", 0);
        double altura = intent.getDoubleExtra("altura", 0);

        Persona person = new Persona(nombre, edad, sexo, peso, altura);
        CaluloIMCViewModel viewModel = new ViewModelProvider(this).get(CaluloIMCViewModel.class);
        viewModel.getEstadoIMC().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String estadoIMC) {
                estadoIMCTextView.setText(person.toString());
                datosPersonaTextView.setText(estadoIMC);
            }
        });
        viewModel.calcularIMC(person.getPeso(), person.getAltura());
    }
}