
package com.example.recuauriol;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<Persona> persona = new MutableLiveData<>();
    private MutableLiveData<Boolean> hasError = new MutableLiveData<>(false);

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public LiveData<Persona> getPersona() {
        return persona;
    }

    public LiveData<Boolean> hasError() {
        return hasError;
    }

    public void validar(Persona persona) {

        boolean res = true;

        if (persona.getNombre().isEmpty()) {
            errorMessage.setValue("Por favor ingrese su nombre");
            res = false;
        }

        if (persona.getEdad() <= 0) {
            errorMessage.setValue("Por favor ingrese una edad válida");
            res = false;
        }

        if (!(persona.getSexo().equals("H") || persona.getSexo().equals("M") || persona.getSexo().equals("O"))) {
            errorMessage.setValue("Por favor ingrese un sexo válido");
            res = false;
        }

        if (persona.getPeso() <= 0) {
            errorMessage.setValue("Por favor ingrese un peso válido");
            res = false;
        }

        if (persona.getAltura() <= 0) {
            errorMessage.setValue("Por favor ingrese una altura válida");
            res = false;
        }

        if (res) {
            this.persona.setValue(persona);
        }

        hasError.setValue(!res);
    }
}