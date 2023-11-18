package com.program3.clases;

import java.util.Scanner;
import java.util.GregorianCalendar;
public class MedicamentoAmbiente extends Medicamento{
    //Atributos
    private String[] lugaresNoAlmacenamiento;
    //Constructores
    public MedicamentoAmbiente(){
        super();
        this.lugaresNoAlmacenamiento = new String[3];
    }
    public MedicamentoAmbiente(String nombre, int codigo, double coste, GregorianCalendar caducidad,double porcentaje, int existencia, int unidadesVendidas, int numeroLote, int vigencia, String lugaresNoAlmacenamiento1, String lugaresNoAlmacenamiento2, String lugaresNoAlmacenamiento3){
        super(nombre, codigo, coste, caducidad, porcentaje, existencia, unidadesVendidas, numeroLote, vigencia);
        this.lugaresNoAlmacenamiento = new String[3];
        this.lugaresNoAlmacenamiento[0] = lugaresNoAlmacenamiento1;
        this.lugaresNoAlmacenamiento[1] = lugaresNoAlmacenamiento2;
        this.lugaresNoAlmacenamiento[2] = lugaresNoAlmacenamiento3;
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
            System.out.println("9. Editar lugares donde no se debe almacenar el producto");
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
                    this.leerDatosAlmacenamiento(sc);
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

    public void imprimirInformacion() {
        super.imprimirInformacionBasico();
        System.out.println("Condiciones de almacenamiento: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(this.lugaresNoAlmacenamiento[i]);
        }
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
            System.out.println("10. Mostrar las condiciones de almacenamiento");
            System.out.println("11. Mostrar toda la informacion");
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
                    System.out.println("Condiciones de almacenamiento: ");
                    for (int i = 0; i < 3; i++) {
                        System.out.println(this.lugaresNoAlmacenamiento[i]);
                    }
                    break;
                case 11:
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
}
