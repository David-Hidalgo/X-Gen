package com.program3.xgen.model;

import java.util.GregorianCalendar;
import java.util.Scanner;

public abstract class Medicamento{
    //Atributos
    
    private String nombreMedicamento;
    private int codigoMedicamento;
    private double costeProduccion;
    private GregorianCalendar caducidad;
    private double precio;
    private int existencia;
    private int unidadesVendidas;
    private int numeroLote;
    private int vigencia;

        final String mensajeVigencia ="la vigencia, que debe estar entre \n" +
    " 0. No está Disponible \n" +
    " 1. Está Disponible \n" +
    " 2. Fue retirado del mercado ";

    //Constructores

    public Medicamento() {
        this.nombreMedicamento = "";
        this.codigoMedicamento = 0;
        this.costeProduccion = 0;
        this.caducidad = new GregorianCalendar();
        this.precio = 0;
        this.existencia = 0;
        this.unidadesVendidas = 0;
        this.numeroLote = 0;
        this.vigencia = 0;
    }

    public Medicamento(String nombre, int codigo, double coste, GregorianCalendar caducidad, double porcentaje, int existencia, int unidadesVendidas, int numeroLote, int vigencia) {
        this.nombreMedicamento = nombre;
        this.codigoMedicamento = codigo;
        this.costeProduccion = coste;
        this.caducidad = caducidad;
        this.precio = coste *(1 +(porcentaje/100));
        this.existencia = existencia;
        this.unidadesVendidas = unidadesVendidas;
        this.numeroLote = numeroLote;
        this.vigencia = vigencia;
    }

    //Getters & Setters
        public String getNombreMedicamento() {
            return nombreMedicamento;
        }
        public void setNombreMedicamento(String nombreMedicamento) {
            this.nombreMedicamento = nombreMedicamento;
        }

        public int getCodigoMedicamento() {
            return codigoMedicamento;
        }
        public void setCodigoMedicamento(int codigoMedicamento) {
            this.codigoMedicamento = codigoMedicamento;
        }

        public double getCosteProduccion() {
            return costeProduccion;
        }
        public void setCosteProduccion(double costeProduccion) {
            this.costeProduccion = costeProduccion;
        }
        
        public double getPrecio() {
            return precio;
        }
        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public GregorianCalendar getCaducidad() {
            return caducidad;
        }
        public void setCaducidad(GregorianCalendar caducidad) {
            this.caducidad = caducidad;
        }
        
        public int getExistencia() {
            return existencia;
        }
        public void setExistencia(int existencia) {
            this.existencia = existencia;
        }

        public int getUnidadesVendidas() {
            return unidadesVendidas;
        }
        public void setUnidadesVendidas(int unidadesVendidas) {
            this.unidadesVendidas = unidadesVendidas;
        }
        

        public void setNumeroLote(int numeroLote) {
            this.numeroLote=numeroLote;
        }
        public int getNumeroLote() {
            return numeroLote;
        }

        public void setVigencia(int vigencia) {
            this.vigencia = vigencia;
        }
        public int getVigencia() {
            return vigencia;
        }

    //Métodos



    public abstract void leerDatos();

    protected void leerDatosBasico() {
        Scanner sc = new Scanner(System.in);
        this.nombreMedicamento=cambiarVariableString(sc, "nombre del Medicamento");
        this.costeProduccion=(int)cambiarVariableNumero(sc, "el coste de producción del medicamento");
        this.precioAPagarFinal(sc);
        do {
            this.codigoMedicamento=(int)cambiarVariableNumero(sc, "el codigo del medicamento");
            if (this.codigoMedicamento<1000000 || this.codigoMedicamento>999999999) {
                System.out.println("Error, el codigo debe ser de 7 a 9 digitos");
            }
        } while (this.codigoMedicamento<1000000 || this.codigoMedicamento>999999999);
        this.numeroLote=(int)cambiarVariableNumero(sc, "el numero de lote del medicamento");
        this.existencia=(int)(cambiarVariableNumero(sc, "el numero de unidades existencia del medicamento"));
        do {
            this.unidadesVendidas=(int)cambiarVariableNumero(sc, "el numero de unidades vendidas del medicamento");
            if (this.existencia<this.unidadesVendidas) {
                System.out.println("Error, las unidades vendidas no pueden ser mayores a las existentes");
            }
        } while (this.existencia<this.unidadesVendidas);
        do{
            this.cambiarFecha(sc);
            if (this.caducidad.compareTo(new GregorianCalendar())<0) {
                System.out.println("Error, la fecha de caducidad no puede ser menor a la fecha actual");
            }
        }while(this.caducidad.compareTo(new GregorianCalendar())<0);
        this.vigencia=(int)cambiarVariableNumero(sc, mensajeVigencia);
    }

    public void modificarLote(){
    Scanner sc = new Scanner(System.in);
    this.numeroLote=(int)cambiarVariableNumero(sc, "el numero de lote del medicamento");
    }

    protected void cambiarFecha(Scanner sc) {
        int año = (int)cambiarVariableNumero(sc, "el año de caducidad del medicamento");
        int mes = (int)cambiarFecha(sc, "mes de caducidad del medicamento");
        this.caducidad.clear();
        this.caducidad.set(año, mes-1, 1);
        return ;
    }
    protected double cambiarFecha(Scanner sc,String cosa) {
        String condition="n";
        String opcion;
        boolean bandera;
        do {
            System.out.printf("Ingrese el %s \n", cosa);
            opcion = sc.nextLine();
            if (!Validaciones.validarNumero(opcion) || (Double.parseDouble(opcion)<1 || Double.parseDouble(opcion)>12)) {
                if(!Validaciones.validarNumero(opcion)){
                    System.out.println("Error escoja un numero");
                    }else{
                        System.out.println("Error escoja un numero entre 1 y 12 para representar el mes");
                    }
            } else {
                do  {
                    System.out.println("esto es lo que usted quiere ingresar: " + opcion);
                    System.out.println("¿Es correcto? (S/N)");
                    condition = sc.nextLine();
                    if (condition.equalsIgnoreCase("S"))
                        bandera = true;
                        else if (condition.equalsIgnoreCase("N")) {
                        bandera = true;
                    } else {
                        bandera = false;
                        System.out.println("Error escoja una opcion valida");
                    }
                    
                } while (bandera == false);
                }
        } while (!Validaciones.validarNumero(opcion) || (condition.equalsIgnoreCase("N")));
        double valor = Double.parseDouble(opcion);
        System.out.println("El dato se ha insertado correctamente");
        return valor;
    }

    protected String cambiarVariableString(Scanner sc, String cosa) {
        String condition="n";
        String opcion;
        boolean bandera;
        do  {
            System.out.printf("Ingrese %s \n", cosa);
            opcion = sc.nextLine();
            System.out.println("esto es lo que usted quiere ingresar: " + opcion);
            System.out.println("¿Es correcto? (S/N)");
            condition = sc.nextLine();
            if (condition.equalsIgnoreCase("S"))
                bandera = true;
                else if (condition.equalsIgnoreCase("N")) {
                bandera = false;
            } else {
                bandera = false;
                System.out.println("Error escoja una opcion valida");
            }
            
        } while (bandera == false);
        System.out.println("El dato se ha insertado correctamente");
        return opcion;
    }
    protected double cambiarVariableNumero(Scanner sc, String cosa) {
        String condition="n";
        String opcion;
        boolean bandera;
        do {
            System.out.printf("Ingrese %s \n", cosa);
            opcion = sc.nextLine();
            if (!Validaciones.validarNumero(opcion)) {
                System.out.println("Error escoja un numero");
            } else if ((cosa.equals(mensajeVigencia)) && (Double.parseDouble(opcion)<0 || Double.parseDouble(opcion)>2)){
                System.out.println("Error escoja un numero entre 0 y 2");
            } else {
                do  {
                    if (Double.parseDouble(opcion)>2000000000){
                        System.out.println("El dato es muy grande, escoja un valor razonable");}
                    System.out.println("esto es lo que usted quiere ingresar: " + opcion);
                    System.out.println("¿Es correcto? (S/N)");
                    condition = sc.nextLine();
                    if (condition.equalsIgnoreCase("S"))
                        bandera = true;
                    else if (condition.equalsIgnoreCase("N")) {
                        bandera = true;
                    } else {
                        bandera = false;
                        System.out.println("Error escoja una opcion valida");
                    }
                    
                } while (bandera == false);
                }
        } while (!Validaciones.validarNumero(opcion) || (condition.equalsIgnoreCase("N"))||(Double.parseDouble(opcion)>2000000000));
        double valor = Double.parseDouble(opcion);
        
        System.out.println("El dato se ha insertado correctamente");
        return valor;
    }

    public boolean verificarRepetido(Medicamento medicamento ) {
        if (this.codigoMedicamento == medicamento.getCodigoMedicamento()) {
            if (this.numeroLote == medicamento.getNumeroLote()) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    public void determinarVencido(){
        GregorianCalendar fechaActual = new GregorianCalendar();
        if (this.caducidad.compareTo(fechaActual) < 0) {
            System.out.println("El medicamento " + this.nombreMedicamento + " esta vencido");
        } else {
            System.out.println("El medicamento " + this.nombreMedicamento + " aun no esta vencido");
        }
    }

    public abstract void precioAPagarFinal(Scanner sc);

    protected void precioAPagar(Scanner in){
        String opcion, condition;
        boolean bandera = false;
        int porcentaje;
        do  {
            System.out.println("ingrese el porcentaje de ganancia que desea establecer (20-100))");
            do{
                do {
                    opcion = in.nextLine();
                    if(!Validaciones.validarNumero(opcion))
                        System.out.println("Ingrese un numero por favor");
                } while (!Validaciones.validarNumero(opcion));
                if((Integer.parseInt(opcion) < 20)||(Integer.parseInt(opcion) > 100))
                    System.out.println("Ingrese un numero entre 20 y 100");
            }while((Integer.parseInt(opcion) < 20)||(Integer.parseInt(opcion) > 100));
            porcentaje = Integer.parseInt(opcion);
            System.out.println("esto es lo que usted quiere ingresar: " + opcion);
            System.out.println("¿Es correcto? (S/N)");
            condition = in.nextLine();
            if (condition.equalsIgnoreCase("S"))
                bandera = true;
                else if (condition.equalsIgnoreCase("N")) {
                bandera = false;
            } else {
                bandera = false;
                System.out.println("Error escoja una opcion valida");
            }
        } while (bandera == false);
        this.precio = this.costeProduccion * (porcentaje/100);
        System.out.println("El dato se ha insertado correctamente");
}

    public boolean retirarLote(int numeroLote){
        if (this.numeroLote == numeroLote) {
            this.vigencia = 2;
            return true;
        }
        else {
            return false;
        }
    }

    public void reponerInventario(){
        Scanner in = new Scanner(System.in);
        String opcion;
        if((this.existencia-this.unidadesVendidas) <= 5){
            System.out.println("Es necesario reponer el inventario de " + this.nombreMedicamento + ",codigo: " + this.codigoMedicamento);
            System.out.println("¿Cuántas unidades desea reponer?");
            do {
            opcion = in.nextLine();
                if (!Validaciones.validarNumero(opcion))
                    System.out.println("Error, ingrese un número");
            } while (!Validaciones.validarNumero(opcion));
            this.existencia = this.existencia + Integer.parseInt(opcion);
            System.out.println("El inventario de " + this.nombreMedicamento + " ha sido reabastecido");
        }else{
            System.out.println("El inventario de " + this.nombreMedicamento + " no necesita ser reabastecido");}
    }

    protected boolean verificar3Meses(){
        GregorianCalendar actual = new GregorianCalendar();
        actual.add(GregorianCalendar.MONTH, 3);
        if (this.caducidad.compareTo(actual) < 0) {
            return true;
        } else {
            return false;
        }
    }

    public void colocarOferta(){
        if (this.verificar3Meses()){
            this.precio = this.precio * 0.70;
            System.out.println("El medicamento " + this.nombreMedicamento + " esta en oferta");
        }else{
            System.out.println("El medicamento " + this.nombreMedicamento + " aun no esta cerca de vencer");
        }
        
    }

    protected void imprimirInformacionBasico(){
        System.out.println("Nombre: " + this.nombreMedicamento);
        System.out.println("Código: " + this.codigoMedicamento);
        System.out.println("Coste de producción: " + this.costeProduccion);
        System.out.println("Fecha de caducidad: " + this.caducidad.get(GregorianCalendar.YEAR) + "/" + this.caducidad.get(GregorianCalendar.MONTH));
        if (this.precio==0){ System.out.println("el precio de venta aun no ha sido establecido");}
        else {System.out.println("Precio: " + this.precio);}
        System.out.println("Unidades existentes: " + this.existencia);
        System.out.println("Número de lote: " + this.numeroLote);
        if(this.vigencia==0)
            System.out.println("El medicamento no se encuentra en el mercado");
        else if(this.vigencia==1)
            System.out.println("El medicamento esta disponible");
        else
            System.out.println("El medicamento fue retirado del mercado");
    }

    public abstract void imprimirInformacion    ();
    public abstract void imprimirEspecifico();
    public abstract void menuCambiarDatos();

    @Override
    public String toString() {
        return nombreMedicamento;
    }
}

