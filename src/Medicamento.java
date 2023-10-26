import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
  
public class Medicamento {
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

    public void leerDatos() {
        Scanner sc = new Scanner(System.in);
        this.nombreMedicamento=cambiarVariableString(sc, "nombre del Medicamento");
        this.costeProduccion=(int)cambiarVariableNumero(sc, "coste de producción del medicamento");
        this.codigoMedicamento=(int)cambiarVariableNumero(sc, "codigo del medicamento");
        this.numeroLote=(int)cambiarVariableNumero(sc, "numero de lote del medicamento");
        this.existencia=(int)(cambiarVariableNumero(sc, "numero de unidades existencia del medicamento"));
        this.cambiarFecha(sc);
        this.unidadesVendidas=(int)cambiarVariableNumero(sc, "numero de unidades vendidas del medicamento");
        this.vigencia=(int)cambiarVariableNumero(sc, "la vigencia, que debe estar entre 0, 1 y 2");
        return ;
    }

    private void cambiarFecha(Scanner sc) {
        int año = (int)cambiarVariableNumero(sc, "año de caducidad del medicamento");
        int mes = (int)cambiarFecha(sc, "mes de caducidad del medicamento");
        this.caducidad.set(mes, año, 1);
        return ;
    }
    private double cambiarFecha(Scanner sc,String cosa) {
        String condition="n";
        String opcion;
        boolean bandera;
        do {
            System.out.printf("Ingrese el %s \n", cosa);
            opcion = sc.nextLine();
            if (!Validaciones.validarNumero(opcion) || (Double.parseDouble(opcion)<0 || Double.parseDouble(opcion)>12)) {
                System.out.println("Error escoja un numero");
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

    private String cambiarVariableString(Scanner sc, String cosa) {
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
    private double cambiarVariableNumero(Scanner sc, String cosa) {
        String condition="n";
        String opcion;
        boolean bandera;
        do {
            System.out.printf("Ingrese el %s \n", cosa);
            opcion = sc.nextLine();
            if (!Validaciones.validarNumero(opcion)) {
                System.out.println("Error escoja un numero");
            } else if ((cosa.equals("la vigencia, que debe estar entre 0, 1 y 2")) && (Double.parseDouble(opcion)<0 || Double.parseDouble(opcion)>2)){
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
        } while (!Validaciones.validarNumero(opcion) || (condition.equalsIgnoreCase("N")));
        double valor = Double.parseDouble(opcion);
        System.out.println("El dato se ha insertado correctamente");
        return valor;
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

    public void retirarLote(int numeroLote){
        if (this.numeroLote == numeroLote) {
            this.vigencia = 0;
        }

    }

    public void reponerInventario(){
        if(this.existencia < 5){
            System.out.println("Es necesario reponer el inventario de " + this.nombreMedicamento);
        }
    }

    private boolean verificar3Meses(){
        GregorianCalendar actual = new GregorianCalendar();
        actual.add(actual.MONTH, 3);
        if (this.caducidad.compareTo(actual) < 0) {
            return true;
        } else {
            return false;
        }
        /*
        int año = actual.get(actual.YEAR);
        int mes = actual.get(actual.MONTH);
        int día = actual.get(actual.DAY_OF_MONTH);
        if (mes > 9){
            if(mes==10){
                nueva = new GregorianCalendar(año+1, 1, día);
            }else if(mes==11){
                nueva = new GregorianCalendar(año+1, 2, día);
            }else{
                nueva = new GregorianCalendar(año+1, 3, día);
            }
        }else{
            nueva = new GregorianCalendar(año, mes, día);
        }
        if (this.caducidad.compareTo(nueva) < 0) {
            return true;
        } else {
            return false;
        }
        */
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
    System.out.println("Fecha de caducidad: " + this.caducidad.get(GregorianCalendar.MONTH) + "/" + this.caducidad.get(GregorianCalendar.YEAR));
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

    @Override
    public String toString() {
        return nombreMedicamento;
    }
}

