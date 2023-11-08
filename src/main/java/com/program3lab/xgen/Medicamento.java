package com.program3lab.xgen;

import java.util.ArrayList;
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

    public Medicamento(String nombre, int codigo, double coste, GregorianCalendar caducidad, double precio, int existencia, int unidadesVendidas, int numeroLote, int vigencia) {
        this.nombreMedicamento = nombre;
        this.codigoMedicamento = codigo;
        this.costeProduccion = coste;
        this.caducidad = caducidad;
        this.precio = precio;
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

    final String mensajeVigencia ="la vigencia, que debe estar entre \\n" +
    " 0. No está Disponible \n" +
    " 1. Está Disponible \n" +
    " 2. Fue retirado del mercado ";



    public void leerDatos() {
        Scanner sc = new Scanner(System.in);
        this.nombreMedicamento=cambiarVariableString(sc, "nombre del Medicamento");
        this.costeProduccion=(int)cambiarVariableNumero(sc, "coste de producción del medicamento");
        do {
            this.codigoMedicamento=(int)cambiarVariableNumero(sc, "codigo del medicamento");
            if (this.codigoMedicamento<1000000 || this.codigoMedicamento>999999999) {
                System.out.println("Error, el codigo debe ser de 7 a 9 digitos");
            }
        } while (this.codigoMedicamento<1000000 || this.codigoMedicamento>999999999);
        this.numeroLote=(int)cambiarVariableNumero(sc, "numero de lote del medicamento");
        this.existencia=(int)(cambiarVariableNumero(sc, "numero de unidades existencia del medicamento"));
        do {
            this.unidadesVendidas=(int)cambiarVariableNumero(sc, "numero de unidades vendidas del medicamento");
            if (this.existencia<this.unidadesVendidas) {
                System.out.println("Error, las unidades vendidas no pueden ser mayores a las existentes");
            }
        } while (this.existencia>this.unidadesVendidas);
        do{
            this.cambiarFecha(sc);
            if (this.caducidad.compareTo(new GregorianCalendar())<0) {
                System.out.println("Error, la fecha de caducidad no puede ser menor a la fecha actual");
            }
        }while(this.caducidad.compareTo(new GregorianCalendar())<0);
        this.vigencia=(int)cambiarVariableNumero(sc, mensajeVigencia);
    }

    protected void modificarLote(){
    Scanner sc = new Scanner(System.in);
    this.numeroLote=(int)cambiarVariableNumero(sc, "numero de lote del medicamento");
    }

    protected void cambiarFecha(Scanner sc) {
        int año = (int)cambiarVariableNumero(sc, "año de caducidad del medicamento");
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
            System.out.printf("Ingrese el %s \n", cosa);
            opcion = sc.nextLine();
            if (!Validaciones.validarNumero(opcion)) {
                System.out.println("Error escoja un numero");
            } else if ((cosa.equals(mensajeVigencia)) && (Double.parseDouble(opcion)<0 || Double.parseDouble(opcion)>2)){
                System.out.println("Error escoja un numero entre 0 y 2");
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
                if (Double.parseDouble(opcion)>2000000000){
                    System.out.println("El dato es muy grande, escoja un valor razonable");}
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

    public void precioAPagar( double porcentaje) {
        porcentaje= porcentaje/100;
        this.precio = this.getCosteProduccion()+(this.costeProduccion * porcentaje);
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
        if(this.existencia < 5){
            System.out.println("Es necesario reponer el inventario de " + this.nombreMedicamento + ",codigo: " + this.codigoMedicamento);
            System.out.println("¿Cuántas unidades desea reponer?");
            do {
            opcion = in.nextLine();
                if (!Validaciones.validarNumero(opcion))
                    System.out.println("Error, ingrese un número");
            } while (!Validaciones.validarNumero(opcion));
            this.existencia = this.existencia + Integer.parseInt(opcion);
            System.out.println("El inventario de " + this.nombreMedicamento + " ha sido reabastecido");
        }
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

    public void imprimirInformacion(){
    System.out.println("Nombre: " + this.nombreMedicamento);
    System.out.println("Código: " + this.codigoMedicamento);
    System.out.println("Coste de producción: " + this.costeProduccion);
    System.out.println("Fecha de caducidad: " + this.caducidad.get(GregorianCalendar.YEAR) + "/" + this.caducidad.get(GregorianCalendar.MONTH));
    if (this.precio==0){ System.out.println("el precio de venta aun no ha sido establecido");}
    else {System.out.println("Precio: " + this.precio);}
    System.out.println("Unidades existentes: " + this.existencia);
    System.out.println("Número de lote: " + this.numeroLote);
    if(this.vigencia==0)
    {System.out.println("El medicamento no se encuentra en el mercado");
    }else if(this.vigencia==1){
        System.out.println("El medicamento esta disponible");
    }else{
        System.out.println("El medicamento fue retirado del mercado");
    }
    }

    public void menuCambiarDatos(){
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        String opcion;
        int numeroOpcion;
        do {
            System.out.println("Bienvenido a la Edición de Medicamentos");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Editar el nombre del Medicamento");
            System.out.println("2. Editar el codigo del medicamento");
            System.out.println("3. Editar el numero de lote");
            System.out.println("4. Editar el coste de Produccion");
            System.out.println("5. Editar la caducidad");
            System.out.println("6. Editar la existencia");
            System.out.println("7. Editar las unidades vendidas");
            System.out.println("8. Editar la vigencia");
            System.out.println("9. Salir");
            do {
                System.out.println("Ingrese un número entre 1 y 9");
                opcion = sc.nextLine();
            } while (!Validaciones.validarNumero(opcion));
            numeroOpcion = Integer.parseInt(opcion);
            System.out.println();
            switch (numeroOpcion) {
                case 1:
                    this.nombreMedicamento=cambiarVariableString(sc, "nombre del Medicamento");
                    break;
                case 2:
                    do {
                        this.codigoMedicamento=(int)cambiarVariableNumero(sc, "codigo del medicamento");
                        if (this.codigoMedicamento<1000000 || this.codigoMedicamento>999999999) {
                            System.out.println("Error, el codigo debe ser de 7 a 9 digitos");
                        }
                    } while (this.codigoMedicamento<1000000 || this.codigoMedicamento>999999999);
                break;
                case 3:
                    this.numeroLote=(int)cambiarVariableNumero(sc, "numero de lote del medicamento");
                break;
                case 4:
                    this.costeProduccion=(int)cambiarVariableNumero(sc, "coste de producción del medicamento");
                    break;
                case 5:
                    do{
                        this.cambiarFecha(sc);
                        if (this.caducidad.compareTo(new GregorianCalendar())<0) {
                            System.out.println("Error, la fecha de caducidad no puede ser menor a la fecha actual");
                        }
                    }while(this.caducidad.compareTo(new GregorianCalendar())<0);
                    break;
                case 6:
                    this.existencia=(int)(cambiarVariableNumero(sc, "numero de unidades existencia del medicamento"));
                    break;
                case 7:
                    do {
                        this.unidadesVendidas=(int)cambiarVariableNumero(sc, "numero de unidades vendidas del medicamento");
                        if (this.existencia<this.unidadesVendidas) {
                            System.out.println("Error, las unidades vendidas no pueden ser mayores a las existentes");
                        }
                    } while (this.existencia>this.unidadesVendidas);
                    break;
                case 8:
                    this.vigencia=(int)cambiarVariableNumero(sc, mensajeVigencia);
                    break;
                case 9:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (numeroOpcion != 9);
    }
    public void imprimirEspecífico(){
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        String opcion;
        int numeroOpcion;
        do {
            System.out.println("Bienvenido a la Edición de Medicamentos");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Mostrar el nombre del Medicamento");
            System.out.println("2. Mostrar el codigo del medicamento");
            System.out.println("3. Mostrar el numero de lote");
            System.out.println("4. Mostrar el coste de Produccion");
            System.out.println("5. Mostrar el precio de Venta");
            System.out.println("6. Mostrar la caducidad");
            System.out.println("7. Mostrar la existencia");
            System.out.println("8. Mostrar las unidades vendidas");
            System.out.println("9. Mostrar la vigencia");
            System.out.println("10. Salir");
            do {
                System.out.println("Ingrese un número entre 1 y 10");
                opcion = sc.nextLine();
            } while (!Validaciones.validarNumero(opcion));
            numeroOpcion = Integer.parseInt(opcion);
            System.out.println();
            switch (numeroOpcion) {
                case 1:
                    System.out.println("Nombre: " + this.nombreMedicamento);
                    break;
                case 2:
                    System.out.println("Código: " + this.codigoMedicamento);
                    break;
                case 3:
                    System.out.println("Número de lote: " + this.numeroLote);
                    break;
                case 4:
                    System.out.println("Coste de producción: " + this.costeProduccion);
                    break;
                case 5:
                    if (this.precio==0){ System.out.println("el precio de venta aun no ha sido establecido");}
                    else {System.out.println("Precio: " + this.precio);}
                    break;
                case 6:
                    System.out.println("Fecha de caducidad: " + this.caducidad.get(GregorianCalendar.YEAR) + "/" + this.caducidad.get(GregorianCalendar.MONTH));
                    break;
                case 7:
                    System.out.println("Unidades existentes: " + this.existencia);
                    break;
                case 8:
                    System.out.println("Unidades vendidas: " + this.unidadesVendidas);
                    break;
                case 9:
                    if(this.vigencia==0)
                    {System.out.println("El medicamento no se encuentra en el mercado");
                    }else if(this.vigencia==1){
                        System.out.println("El medicamento esta disponible");
                    }else{
                        System.out.println("El medicamento fue retirado del mercado");
                    }
                    break;
                case 10:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (numeroOpcion != 10);
    }


    @Override
    public String toString() {
        return nombreMedicamento;
    }
}

