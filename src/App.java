import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Medicamento foo = new Medicamento();
        menu();
        foo.leerDatos();
    }

    private static boolean menu() {
        System.out.flush();
        Scanner in = new Scanner(System.in);
        String opcion;
        boolean bandera;
        ArrayList<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();        
        int numeroOpcion;
        System.out.println("Bienvenido al programa Medicamentos");
        System.out.println("¿Qué desea hacer?");
        System.out.println("1. Crear un medicamento");
        System.out.println("2. mostrar medicamentos.");
        System.out.println("3. Mostrar la secuencia de nodos insertados");
        System.out.println("4. Mostrar el árbol");
        System.out.println("5. Salir");
        do {
            System.out.println("Ingrese una opción valida");
            opcion = in.nextLine();
        } while (!Validaciones.validarNumero(opcion));
        numeroOpcion = Integer.parseInt(opcion);
        System.out.println();
        switch (numeroOpcion) {
            case 1:
                String condition;
                System.out.println("Menú de creación");
                
                do {
                    Medicamento foo = new Medicamento();
                    foo.leerDatos();
                    do {
                        System.out.println("¿Desea ingresar otro nodo? (S/N)");
                        condition = in.nextLine();
                        if (condition.equalsIgnoreCase("S"))
                            bandera = true;
                            else if (condition.equalsIgnoreCase("N")) {
                            bandera = true;
                        } else {
                            bandera = false;
                            System.out.println("Error escoja una opcion valida");
                        }
                        
                    } while (bandera == false);
                    listaMedicamentos.add(foo);
                } while (condition.equalsIgnoreCase("S"));
                break;
            case 2:
                do {
                    System.out.println("¿Qué nivel desea consultar?");
                    System.out.print(listaMedicamentos);
                    condition = in.nextLine();
                    if (condition.equalsIgnoreCase("S"))
                        bandera = true;
                        else if (condition.equalsIgnoreCase("N")) {
                        bandera = true;
                    } else {
                        bandera = false;
                        System.out.println("Error escoja una opcion valida");
                    }
                } while (bandera == false);
                listaMedicamentos.get(numeroOpcion);
                System.out.println("Presione enter para continuar");
                in.nextLine();
                break;
            case 3:
                System.out.println("mostrar la secuencia de nodos insertados");
                System.out.println("Presione enter para continuar");
                in.nextLine();
                break;
            case 4:
                System.out.println("¿Qué recorrido desea hacer?");
                System.out.println("1. Preorden");
                System.out.println("2. Inorden");
                System.out.println("3. Postorden");
                System.out.println("Presione enter para continuar");
                in.nextLine();
                break;
            case 5:
                System.out.println("Gracias por usar el programa");
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        in.close();
        if (numeroOpcion == 5) {
            return false;
        } else {
            return true;
        }
    }

    }
