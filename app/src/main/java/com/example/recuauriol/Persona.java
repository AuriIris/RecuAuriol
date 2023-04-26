package com.example.recuauriol;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;
    private String sexo;
    private Double peso;
    private Double altura;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String  sexo, Double peso, Double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                " Edad: " + edad +
                " Sexo: " + sexo +
                " Peso: " + peso +
                " Altura: " + altura;
    }
}