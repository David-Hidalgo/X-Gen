import java.util.Date;
import java.util.Scanner;

public class Medicamento {
    //Atributos
    
    private String nombreMedicamento;
    private int codigoMedicamento;
    private double costeProduccion;
    private Date caducidad;
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
        this.caducidad = new Date();
        this.precio = 0;
        this.existencia = 0;
        this.unidadesVendidas = 0;
        this.numeroLote = 0;
        this.vigencia = 0;
    }

    public Medicamento(String nombre, int codigo, double coste, Date caducidad, double precio, int existencia, int unidadesVendidas, int numeroLote, int vigencia) {
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

        public Date getCaducidad() {
            return caducidad;
        }
        public void setCaducidad(Date caducidad) {
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
        this.precio=cambiarVariableNumero(sc, "precio del medicamento");
        this.codigoMedicamento=(int)cambiarVariableNumero(sc, "codigo del medicamento");
        this.existencia=(int)(cambiarVariableNumero(sc, "numero de unidades existencia del medicamento"));
        this.numeroLote=(int)cambiarVariableNumero(sc, "numero de lote del medicamento");
        this.unidadesVendidas=(int)cambiarVariableNumero(sc, "numero de unidades vendidas del medicamento");
        this.vigencia=(int)cambiarVariableNumero(sc, "la vigencia, que debe estar entre 0, 1 y 2");
        sc.close();
        return ;
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
                bandera = true;
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
        } while (!Validaciones.validarNumero(opcion) && (condition.equalsIgnoreCase("N")));
        double valor = Double.parseDouble(opcion);
        System.out.println("El dato se ha insertado correctamente");
        return valor;
    }

    private void cambiarFecha() {
        
    }

    public void determinarVencido(){
        Date fechaActual = new Date();
        if (this.caducidad.compareTo(fechaActual) < 0) {
            System.out.println("El medicamento " + this.nombreMedicamento + " esta vencido");
        } else {
            System.out.println("El medicamento " + this.nombreMedicamento + " aun no esta vencido");
        }
    }

    public double precioAPagar( double porcentaje) {
        double precioAPagar = 0;
        precioAPagar = this.costeProduccion * porcentaje;
        return precioAPagar;
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
        Date actual = new Date();
        Date nueva = null;
        int mes = actual.getMonth();
        int año = actual.getYear();
        int dia = actual.getDay();
        if (mes > 9){
            if(mes==10){
                nueva = new Date(año+1, 1, dia);
            }else if(mes==11){
                nueva = new Date(año+1, 2, dia);
            }else{
                nueva = new Date(año+1, 3, dia);
            }
        }else{
            nueva = new Date(año, mes, dia);
        }
        if (this.caducidad.compareTo(nueva) < 0) {
            return true;
        } else {
            return false;
        }

    }

    public void colocarOferta(){
        if (this.verificar3Meses()){
            this.precio = this.precio * 0.70;
        }
        
    }


    public void imprimirInformacion(){
    System.out.println("Nombre: " + this.nombreMedicamento);
    System.out.println("Código: " + this.codigoMedicamento);
    System.out.println("Coste de producción: " + this.costeProduccion);
    System.out.println("Fecha de caducidad: " + this.caducidad);
    if (this.precio==0){ System.out.println("Precio: " + this.precio);}
    else {System.out.println("El precio de venta aun no ha sido establecido");}
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
}
