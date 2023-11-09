package com.program3lab.xgen;
import java.util.Scanner;
import java.util.ArrayList;

public class MedicamentoRefrigerado extends Medicamento{
    //Atributos
    private double temperaturaMinima;
    private double temperaturaMaxima;
    private double temperaturaActual;
    private ArrayList<Double> registroDeTemperaturas;
    private String[] informacionCadenaDeFrio;
    private int durabilidadLuegoDeAbierto;

    //Constructores

	public MedicamentoRefrigerado(){
        super();
        this.temperaturaMinima = 0;
        this.temperaturaMaxima = 0;
        this.temperaturaActual = 0;
        this.registroDeTemperaturas = new ArrayList<Double>();
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

    public double getTemperaturaActual() {
        return temperaturaActual;
    }

    public void setTemperaturaActual(double temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
        registroDeTemperaturas.add(temperaturaActual);
    }

    public ArrayList<Double> getregistroDeTemperaturas() {
        return registroDeTemperaturas;
    }

    public void setregistroDeTemperaturas(ArrayList<Double> registroDeTemperaturas) {
        this.registroDeTemperaturas = registroDeTemperaturas;
    }

    public String[] getInformacionCadenaDeFrio() {
        return informacionCadenaDeFrio;
    }

    public void setInformacionCadenaDeFrio(String[] informacionCadenaDeFrio) {
        this.informacionCadenaDeFrio = informacionCadenaDeFrio;
    }

    public int getDurabilidadLuegoDeAbierto() {
		return durabilidadLuegoDeAbierto;
	}

	public void setDurabilidadLuegoDeAbierto(int durabilidadLuegoDeAbierto) {
		this.durabilidadLuegoDeAbierto = durabilidadLuegoDeAbierto;
	}
    //Metodos

    public void leerDatos(){
        Scanner sc = new Scanner(System.in);
        super.leerDatosBasico();
        this.leerRestante(sc);
    }

    protected void leerRestante(Scanner sc){
        String info;
        do{
            this.temperaturaMinima = cambiarVariableNumero(sc, "la temperatura minima");
            do{
                this.temperaturaMaxima = cambiarVariableNumero(sc, "la temperatura maxima");
                if(this.temperaturaMaxima < this.temperaturaMinima)
                    System.out.println("La temperatura maxima debe ser mayor a la minima");
            }while(this.temperaturaMaxima < this.temperaturaMinima);
            if(this.temperaturaMaxima>15||this.temperaturaMinima<-274)
                System.out.println("La temperatura establecida no corresponde a un medicamento refrigerado \n La temperatura de refrigeracion esta por debajo de los 15 grados (recordar que el cero absoluto es -274 grados)");
        }while(this.temperaturaMaxima>15||this.temperaturaMinima<-274);
        info = cambiarVariableString(sc, "donde se almacena especificamente el producto");
        this.informacionCadenaDeFrio[0] = "el producto debe ser almacenado en" + info ;
        info = cambiarVariableString(sc, "exposicion a la luz (baja, media, alta)");
        this.informacionCadenaDeFrio[1] = "el producto debe tener una" + info + "exposicion a la luz";
        info = cambiarVariableString(sc, "exposicion a la humedad (baja, media, alta)");
        this.informacionCadenaDeFrio[2] = "el producto debe tener una" + info + "exposicion a la humedad";
        info = cambiarVariableString(sc, "metodo de transportacion");
        this.informacionCadenaDeFrio[3] = "el producto debe ser transportado por" + info;
        do{
            this.durabilidadLuegoDeAbierto= (int)cambiarVariableNumero(sc, "el tiempo de duracion luego de abierto (en semanas)");
            if(this.durabilidadLuegoDeAbierto<0||this.durabilidadLuegoDeAbierto>104)
                System.out.println("Por favor coloque un tiempo de duracion razonable, no mayor a 104 semanas (2 años) ni menor a 0");
        }while(this.durabilidadLuegoDeAbierto<0||this.durabilidadLuegoDeAbierto>104);
    }

    public void precioAPagarFinal(Scanner sc){
        super.precioAPagar(sc);
        this.setPrecio(this.getPrecio()*1.25);
    }

}
