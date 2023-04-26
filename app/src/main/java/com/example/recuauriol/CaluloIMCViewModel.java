
package com.example.recuauriol;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CaluloIMCViewModel extends AndroidViewModel {
    private MutableLiveData<String> estadoIMC;

    public CaluloIMCViewModel(@NonNull Application application) {
        super(application);
        estadoIMC = new MutableLiveData<>();
    }

    public void calcularIMC(double peso, double altura) {
        double imc = peso / Math.pow(altura, 2);
        String estadoIMCString = "";

        if (imc < 20) {
            estadoIMCString = "Ud. esta por debajo de su peso ideal";
        } else if (imc >= 20 && imc <= 25) {
            estadoIMCString = "Ud. esta en su peso ideal";
        } else {
            estadoIMCString = "Ud. esta con sobrepeso";
        }

        estadoIMC.setValue(estadoIMCString);
    }

    public MutableLiveData<String> getEstadoIMC() {
        return estadoIMC;
    }
}