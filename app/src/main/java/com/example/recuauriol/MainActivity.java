package com.example.recuauriol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private EditText etEdad;
    private EditText etSexo;
    private EditText etPeso;
    private EditText etAltura;
    private Button btnCalcular;
    private TextView errorTextView;
    private MainActivityViewModel viewModel;
    private boolean hasError = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre1);
        etEdad = findViewById(R.id.etEdad);
        etSexo = findViewById(R.id.etSexo);
        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        btnCalcular = findViewById(R.id.btValidar);
        errorTextView = findViewById(R.id.tvError);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getErrorMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String errorMessage) {
                showError(errorMessage);
            }
        });

        viewModel.getPersona().observe(this, new Observer<Persona>() {
            @Override
            public void onChanged(Persona persona) {
                if (persona != null) {
                    startResultActivity(persona);
                }
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona persona = null;
                try {
                    persona = new Persona(
                            etNombre.getText().toString(),
                            Integer.parseInt(etEdad.getText().toString()),
                            etSexo.getText().toString(),
                            Double.parseDouble(etPeso.getText().toString()),
                            Double.parseDouble(etAltura.getText().toString())
                    );
                } catch (NumberFormatException e) {
                    showError("Ingrese valores válidos para edad, peso y altura");
                    return;
                } catch (NullPointerException e) {
                    showError("Complete todos los campos");
                    return;
                }
                viewModel.validar(persona);
            }
        });
    }

    public void showError(String message) {
        errorTextView.setText(message);
    }

    public void startResultActivity(Persona person) {
        Intent intent = new Intent(this, CalculoIMC.class);
        intent.putExtra("nombre", person.getNombre());
        intent.putExtra("edad", person.getEdad());
        intent.putExtra("sexo", person.getSexo());
        intent.putExtra("peso", person.getPeso());
        intent.putExtra("altura", person.getAltura());
        startActivity(intent);
    }
}