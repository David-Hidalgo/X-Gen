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

    //Metodos

}
