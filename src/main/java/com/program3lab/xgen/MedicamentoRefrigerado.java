package com.program3lab.xgen;

import java.util.ArrayList;

public class MedicamentoRefrigerado extends Medicamento{
    //Atributos
    private double temperaturaMinima;
    private double temperaturaMaxima;
    private double temperaturaRecomendada;
    private double temperaturaActual;
    private ArrayList<Double> listaDetemperaturas;

    //Constructores

    public MedicamentoRefrigerado(){
        super();
        this.temperaturaMinima = 0;
        this.temperaturaMaxima = 0;
        this.temperaturaRecomendada = 0;
        this.temperaturaActual = 0;
        this.listaDetemperaturas = new ArrayList<Double>();
    }

    //Getters y Setters

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public double getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public void setTemperaturaRecomendada(double temperaturaRecomendada) {
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    public double getTemperaturaActual() {
        return temperaturaActual;
    }

    public void setTemperaturaActual(double temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
        listaDetemperaturas.add(temperaturaActual);
    }

    public ArrayList<Double> getListaDetemperaturas() {
        return listaDetemperaturas;
    }

    public void setListaDetemperaturas(ArrayList<Double> listaDetemperaturas) {
        this.listaDetemperaturas = listaDetemperaturas;
    }

    //Metodos

}
