package com.program3lab.xgen;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
        this.informacionCadenaDeFrio = new String[4];
        this.durabilidadLuegoDeAbierto = 0;
    }

    public MedicamentoRefrigerado(String nombre, int codigo, double coste, GregorianCalendar caducidad,double porcentaje, int existencia, int unidadesVendidas, int numeroLote, int vigencia, double temperaturaMinima, double temperaturaMaxima, String almacenamiento, String expoLuz, String expoHumedad, String transporte, int durabilidadLuegoDeAbierto){
        super(nombre, codigo, coste, caducidad, porcentaje, existencia, unidadesVendidas, numeroLote, vigencia);
        this.setPrecio(this.getPrecio()*1.25);
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaActual = 0;
        this.registroDeTemperaturas = new ArrayList<Double>();
        this.informacionCadenaDeFrio = new String[4];
        this.informacionCadenaDeFrio[0] = almacenamiento;
        this.informacionCadenaDeFrio[1] = expoLuz;
        this.informacionCadenaDeFrio[2] = expoHumedad;
        this.informacionCadenaDeFrio[3] = transporte;
        this.durabilidadLuegoDeAbierto = durabilidadLuegoDeAbierto;

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
        this.informacionCadenaDeFrio[0] = "el producto debe ser almacenado en " + info ;
        info = cambiarVariableString(sc, "exposicion a la luz (baja, media, alta)");
        this.informacionCadenaDeFrio[1] = "el producto debe tener una" + info + "exposicion a la luz";
        info = cambiarVariableString(sc, "exposicion a la humedad (baja, media, alta)");
        this.informacionCadenaDeFrio[2] = "el producto debe tener una" + info + "exposicion a la humedad";
        info = cambiarVariableString(sc, "metodo de transportacion");
        this.informacionCadenaDeFrio[3] = "el producto debe ser transportado " + info;
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

    public void imprimirInformacion(){
        super.imprimirInformacionBasico();
        System.out.println("Temperatura minima: " + this.getTemperaturaMinima());
        System.out.println("Temperatura maxima: " + this.getTemperaturaMaxima());
        System.out.println("Informacion de la cadena de frio: ");
        System.out.println(this.informacionCadenaDeFrio[0]);
        System.out.println(this.informacionCadenaDeFrio[1]);
        System.out.println(this.informacionCadenaDeFrio[2]);
        System.out.println(this.informacionCadenaDeFrio[3]);
        System.out.println("Utilicese mejor antes de transcurridas " + this.getDurabilidadLuegoDeAbierto() + " semanas de ser abierto");
    }
    public void imprimirEspecifico(){
        System.out.flush();
        System.out.print("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        String opcion;
        int numeroOpcion;
        do {
            System.out.println("¿Qué desea consultar?");
            System.out.println("1. Mostrar el nombre del Medicamento");
            System.out.println("2. Mostrar el codigo del medicamento");
            System.out.println("3. Mostrar el numero de lote");
            System.out.println("4. Mostrar el coste de Produccion");
            System.out.println("5. Mostrar el precio de Venta");
            System.out.println("6. Mostrar la caducidad");
            System.out.println("7. Mostrar la existencia");
            System.out.println("8. Mostrar las unidades vendidas");
            System.out.println("9. Mostrar la vigencia");
            System.out.println("10. Mostrar la temperatura minima y maxima");
            System.out.println("11. Mostrar la informacion de la cadena de frio");
            System.out.println("12. Mostrar la durabilidad luego de abierto");
            System.out.println("13. Mostrar toda la informacion");
            System.out.println("0. Salir");
            do {
                System.out.println("Ingrese un número entre 1 y 10");
                opcion = sc.nextLine();
            } while (!Validaciones.validarNumero(opcion));
            numeroOpcion = Integer.parseInt(opcion);
            System.out.println();
            switch (numeroOpcion) {
                case 1:
                    System.out.println("Nombre: " + this.getNombreMedicamento());
                    break;
                case 2:
                    System.out.println("Código: " + this.getCodigoMedicamento());
                    break;
                case 3:
                    System.out.println("Número de lote: " + this.getNumeroLote());
                    break;
                case 4:
                    System.out.println("Coste de producción: " + this.getCodigoMedicamento());
                    break;
                case 5:
                    if (this.getPrecio()==0){ System.out.println("el precio de venta aun no ha sido establecido");}
                    else {System.out.println("Precio: " + this.getPrecio());}
                    break;
                case 6:
                    System.out.println("Fecha de caducidad: " + super.getCaducidad().get(GregorianCalendar.YEAR) + "/" + this.getCaducidad().get(GregorianCalendar.MONTH));
                    break;
                case 7:
                    System.out.println("Unidades existentes: " + this.getExistencia());
                    break;
                case 8:
                    System.out.println("Unidades vendidas: " + this.getUnidadesVendidas());
                    break;
                case 9:
                    if(this.getVigencia()==0)
                    {System.out.println("El medicamento no se encuentra en el mercado");
                    }else if(this.getVigencia()==1){
                        System.out.println("El medicamento esta disponible");
                    }else{
                        System.out.println("El medicamento fue retirado del mercado");
                    }
                    break;
                case 10:
                    System.out.println("Temperatura minima: " + this.getTemperaturaMinima());
                    System.out.println("Temperatura maxima: " + this.getTemperaturaMaxima());
                    break;
                case 11:
                    System.out.println("Informacion de la cadena de frio: ");
                    System.out.println(this.informacionCadenaDeFrio[0]);
                    System.out.println(this.informacionCadenaDeFrio[1]);
                    System.out.println(this.informacionCadenaDeFrio[2]);
                    System.out.println(this.informacionCadenaDeFrio[3]);
                    break;
                case 12:   
                    System.out.println("Utilicese mejor antes de transcurridas " + this.getDurabilidadLuegoDeAbierto() + " semanas de ser abierto");
                    break;
                case 13:
                    this.imprimirInformacion();
                    System.out.println("Presione enter para continuar");
                    sc.nextLine();
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
            
        } while (numeroOpcion != 0);
    }

    public void menuCambiarDatos(){
        System.out.flush();
        System.out.print("\033[H\033[2J");
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
            System.out.println("9. Editar la temperatura minima y maxima");
            System.out.println("10. Editar la informacion de la cadena de frio");
            System.out.println("11. Editar la durabilidad luego de abierto");
            System.out.println("0. Salir");
            do {
                System.out.println("Ingrese un número entre 1 y 8");
                opcion = sc.nextLine();
            } while (!Validaciones.validarNumero(opcion));
            numeroOpcion = Integer.parseInt(opcion);
            System.out.println();
            switch (numeroOpcion) {
                case 1:
                    this.setNombreMedicamento(cambiarVariableString(sc, "nombre del Medicamento"));
                    break;
                case 2:
                    do {
                        this.setCodigoMedicamento((int)cambiarVariableNumero(sc, "el codigo del medicamento"));
                        if (this.getCodigoMedicamento()<1000000 || this.getCodigoMedicamento()>999999999) {
                            System.out.println("Error, el codigo debe ser de 7 a 9 digitos");
                        }
                    } while (this.getCodigoMedicamento()<1000000 || this.getCodigoMedicamento()>999999999);
                break;
                case 3:
                    this.setNumeroLote((int)cambiarVariableNumero(sc, "el numero de lote del medicamento"));
                break;
                case 4:
                    this.setCosteProduccion((int)cambiarVariableNumero(sc, "el coste de producción del medicamento"));
                    break;
                case 5:
                    do{
                        super.cambiarFecha(sc);
                        if (this.getCaducidad().compareTo(new GregorianCalendar())<0) {
                            System.out.println("Error, la fecha de caducidad no puede ser menor a la fecha actual");
                        }
                    }while(this.getCaducidad().compareTo(new GregorianCalendar())<0);
                    break;
                case 6:
                    this.setExistencia((int)(cambiarVariableNumero(sc, "el numero de unidades existencia del medicamento")));
                    break;
                case 7:
                    do {
                        this.setUnidadesVendidas((int)cambiarVariableNumero(sc, "el numero de unidades vendidas del medicamento"));
                        if (this.getExistencia()<this.getUnidadesVendidas()) {
                            System.out.println("Error, las unidades vendidas no pueden ser mayores a las existentes");
                        }
                    } while (this.getExistencia()>this.getUnidadesVendidas());
                    break;
                case 8:
                    this.setVigencia((int)cambiarVariableNumero(sc, mensajeVigencia));
                    break;
                case 9:
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
                break;
                case 10:
                    String info;
                    info = cambiarVariableString(sc, "donde se almacena especificamente el producto");
                    this.informacionCadenaDeFrio[0] = "el producto debe ser almacenado en " + info ;
                    info = cambiarVariableString(sc, "exposicion a la luz (baja, media, alta)");
                    this.informacionCadenaDeFrio[1] = "el producto debe tener una" + info + "exposicion a la luz";
                    info = cambiarVariableString(sc, "exposicion a la humedad (baja, media, alta)");
                    this.informacionCadenaDeFrio[2] = "el producto debe tener una" + info + "exposicion a la humedad";
                    info = cambiarVariableString(sc, "metodo de transportacion");
                    this.informacionCadenaDeFrio[3] = "el producto debe ser transportado " + info;
                break;
                case 11:
                    do{
                        this.durabilidadLuegoDeAbierto= (int)cambiarVariableNumero(sc, "el tiempo de duracion luego de abierto (en semanas)");
                        if(this.durabilidadLuegoDeAbierto<0||this.durabilidadLuegoDeAbierto>104)
                            System.out.println("Por favor coloque un tiempo de duracion razonable, no mayor a 104 semanas (2 años) ni menor a 0");
                    }while(this.durabilidadLuegoDeAbierto<0||this.durabilidadLuegoDeAbierto>104);
                case 0:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (numeroOpcion != 0);
    }

}
