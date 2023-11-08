package com.program3lab.xgen;
import java.util.Scanner;
import java.util.ArrayList;

public class MedicamentoRefrigerado extends Medicamento{
    //Atributos
    private double temperaturaMinima;
    private double temperaturaMaxima;
    private double temperaturaRecomendada;
    private double temperaturaActual;
    private ArrayList<Double> listaDetemperaturas;
    private String[] informacionCadenaDeFrio;

    //Constructores

    public MedicamentoRefrigerado(){
        super();
        this.temperaturaMinima = 0;
        this.temperaturaMaxima = 0;
        this.temperaturaRecomendada = 0;
        this.temperaturaActual = 0;
        this.listaDetemperaturas = new ArrayList<Double>();
        this.informacionCadenaDeFrio = new String[3];
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

    public String[] getInformacionCadenaDeFrio() {
        return informacionCadenaDeFrio;
    }

    public void setInformacionCadenaDeFrio(String[] informacionCadenaDeFrio) {
        this.informacionCadenaDeFrio = informacionCadenaDeFrio;
    }
    //Metodos

    public void leerDatos(){
        Scanner sc = new Scanner(System.in);
        super.leerDatosBasico();
        this.leerRestante(sc);
    }

    protected void leerRestante(Scanner sc){
        System.out.println("Ingrese la temperatura minima: ");
        this.temperaturaMinima = sc.nextDouble();
        System.out.println("Ingrese la temperatura maxima: ");
        this.temperaturaMaxima = sc.nextDouble();
        System.out.println("Ingrese la temperatura recomendada: ");
        this.temperaturaRecomendada = sc.nextDouble();
        System.out.println("Ingrese la temperatura actual: ");
        this.temperaturaActual = sc.nextDouble();
    }

    public void precioAPagarFinal(Scanner sc){
        super.precioAPagar(sc);
        this.setPrecio(this.getPrecio()*1.25);
    }

}
