import java.util.ArrayList;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        menu();
    }

    private static boolean menu() {
        System.out.flush();
        Scanner in = new Scanner(System.in);
        boolean bandera;
        ArrayList<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();        
        String opcion;
        int numeroOpcion;
        do {
            System.out.println("Bienvenido al programa Medicamentos");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Crear un medicamento");
            System.out.println("2. mostrar medicamentos.");
            System.out.println("3. Establecer Precio de venta en % de ganancias.");
            System.out.println("4. Colocar Ofertas");
            System.out.println("5. Verificar si está vencido");
            System.out.println("6. Verificar si es necesario reponer inventario");
            System.out.println("7. Remover lotes de inventario");
            System.out.println("8. Salir");
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
                        System.out.println("Mande una tecla para continuar");
                        in.nextLine();
                        do {
                            System.out.println("¿Desea ingresar otro Medicamento? (S/N)");
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
                        System.out.println("¿Qué medicamento desea consultar?");
                        System.out.print(listaMedicamentos);
                        do {
                            do {
                                System.out.println("Ingrese una opción valida");
                                opcion = in.nextLine();
                            } while (!Validaciones.validarNumero(opcion));
                        } while (Integer.parseInt(opcion)+1 > listaMedicamentos.size());
                        numeroOpcion = Integer.parseInt(opcion);
                        listaMedicamentos.get(numeroOpcion).imprimirInformacion();
                        do {
                            System.out.println("¿Desea ver otro Medicamento? (S/N)");
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
                    } while (condition.equalsIgnoreCase("S"));                
                    System.out.println("Presione enter para continuar");
                    in.nextLine();
                    break;
                case 3:
                    do {
                        System.out.println("¿Qué medicamento desea modificar?");
                        System.out.print(listaMedicamentos);
                        do {
                            do {
                                System.out.println("Ingrese una opción valida");
                                opcion = in.nextLine();
                            } while (!Validaciones.validarNumero(opcion));
                        } while (Integer.parseInt(opcion)+1 > listaMedicamentos.size());
                        numeroOpcion = Integer.parseInt(opcion);
                        System.out.println("ingrese el porcentaje de ganancia que desea establecer");
                        do{
                            do {
                                System.out.println("Ingrese una opción valida");
                                opcion = in.nextLine();
                            } while (!Validaciones.validarNumero(opcion));
                        }while((Integer.parseInt(opcion) < 20)||(Integer.parseInt(opcion) > 100));
                        int porcentaje = Integer.parseInt(opcion);
                        listaMedicamentos.get(numeroOpcion).precioAPagar(porcentaje);
                        do {
                            System.out.println("¿Desea establecer el precio de otro Medicamento? (S/N)");
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
                    } while (condition.equalsIgnoreCase("S"));                
                    System.out.println("Presione enter para continuar");
                    in.nextLine();
                    break;
                case 4:
                    System.out.println("¿Quiere colocar ofertas a los lotes de medicina que van a vencer?");
                    for (Medicamento medicamento : listaMedicamentos) {
                        medicamento.colocarOferta();
                    }
                    System.out.println("Presione enter para continuar");
                    in.nextLine();
                    System.out.println();
                    break;
                case 5:
                    for (Medicamento medicamento : listaMedicamentos) {
                        medicamento.determinarVencido();
                    }
                    System.out.println("Presione enter para continuar");
                    in.nextLine();
                    System.out.println();
                    break;
                case 6:
                    for (Medicamento medicamento : listaMedicamentos) {
                        medicamento.reponerInventario();
                    }
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Escriba el numero de lote a retirar.");
                    do {
                        System.out.println("Ingrese una opción valida");
                        opcion = in.nextLine();
                    } while (!Validaciones.validarNumero(opcion));
                    int loteRetirable = Integer.parseInt(opcion);
                    
                    for (Medicamento medicamento : listaMedicamentos) {
                        medicamento.retirarLote(loteRetirable);
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Gracias por usar el programa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (numeroOpcion != 8);
        in.close();
        return false;
    }
}
