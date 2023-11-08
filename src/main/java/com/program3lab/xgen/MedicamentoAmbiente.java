package com.program3lab.xgen;

import java.util.Scanner;
import java.util.ArrayList;
public class MedicamentoAmbiente extends Medicamento{
    //Atributos
    private String[] condicionesAlmacenamiento;
    //Constructores
    MedicamentoAmbiente(){
        super();
        this.condicionesAlmacenamiento = new String[3];
    }
    //Getters y Setters

    public String[] getCondicionesAlmacenamiento() {
        return condicionesAlmacenamiento;
    }

    public void setCondicionesAlmacenamiento(String[] condicionesAlmacenamiento) {
        this.condicionesAlmacenamiento = condicionesAlmacenamiento;
    }
    //Metodos

    public void leerDatos() {
        Scanner sc = new Scanner(System.in);
        super.leerDatosBasico();
        this.leerDatosAlmacenamiento(sc);
    }

    public void precioAPagarFinal(Scanner sc) {
        super.precioAPagar(sc);
    }

    protected void leerDatosAlmacenamiento(Scanner sc) {
        System.out.println("Ingrese las condiciones de almacenamiento del medicamento: ");
        System.out.println("Temperatura: ");
        this.condicionesAlmacenamiento[0] = sc.nextLine();
        System.out.println("Humedad: ");
        this.condicionesAlmacenamiento[1] = sc.nextLine();
        System.out.println("Luz: ");
        this.condicionesAlmacenamiento[2] = sc.nextLine();
    }
    
}
