package com.program3lab.xgen;

import java.util.Scanner;
public class MedicamentoAmbiente extends Medicamento{
    //Atributos
    private String[] lugaresNoAlmacenamiento;
    //Constructores
    MedicamentoAmbiente(){
        super();
        this.lugaresNoAlmacenamiento = new String[3];
    }
    //Getters y Setters

    public String[] getCondicionesAlmacenamiento() {
        return lugaresNoAlmacenamiento;
    }

    public void setCondicionesAlmacenamiento(String[] lugaresNoAlmacenamiento) {
        this.lugaresNoAlmacenamiento = lugaresNoAlmacenamiento;
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
        String info;
        System.out.println("Ingrese por favor lugares donde no se debe almacenar el producto:");
        for (int i = 0; i < 3; i++) {
            info = cambiarVariableString(sc, "el lugar (" + (i + 1) + "):");
            this.lugaresNoAlmacenamiento[i] = "El producto no debe ser almacenado en " + info;
        }
    }
    
}
