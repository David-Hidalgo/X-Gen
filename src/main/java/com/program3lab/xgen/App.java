package com.program3lab.xgen;

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
                System.out.println("Ingrese un número entre 1 y 8");
                opcion = in.nextLine();
            } while (!Validaciones.validarNumero(opcion));
            numeroOpcion = Integer.parseInt(opcion);
            System.out.println();
            switch (numeroOpcion) {
                case 1:
                    String condition;
                    System.out.println("Menú de creación");
                    do {
                        Medicamento foo = new MedicamentoRefrigerado();
                        
                        foo.leerDatos();
                        while (verificarLoteRepetido(listaMedicamentos, foo)) {
                            System.out.println("El lote ingresado ya existe, ingrese otro");
                            foo.modificarLote();
                        }
                        System.out.println("Medicamento creado con éxito");
                        System.out.println("Presione una tecla para continuar");
                        in.nextLine();
                        listaMedicamentos.add(foo);
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
                    } while (condition.equalsIgnoreCase("S"));
                    break;
                case 2:
                    do {
                        System.out.println("¿Qué medicamento desea consultar?");
                        System.out.print(listaMedicamentos);
                        do {
                            do {
                                opcion = in.nextLine();
                                if(!Validaciones.validarNumero(opcion))
                                    System.out.println("Ingrese un numero por favor");
                            } while (!Validaciones.validarNumero(opcion));
                            if(Integer.parseInt(opcion)+1 > listaMedicamentos.size())
                                System.out.println("Ingrese un numero valido");
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
                        System.out.println("¿Qué medicamento desea modificarle el precio?");
                        System.out.print(listaMedicamentos);
                        do {
                            do {
                                opcion = in.nextLine();
                                if(!Validaciones.validarNumero(opcion))
                                    System.out.println("Ingrese un numero por favor");
                            } while (!Validaciones.validarNumero(opcion));
                            if(Integer.parseInt(opcion)+1 > listaMedicamentos.size())
                                System.out.println("Ingrese un numero valido");
                        } while (Integer.parseInt(opcion)+1 > listaMedicamentos.size());
                        numeroOpcion = Integer.parseInt(opcion);
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
                                System.out.println("Error ingrese una opcion valida");
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
                        opcion = in.nextLine();
                        if(!Validaciones.validarNumero(opcion))
                            System.out.println("Ingrese un numero por favor");
                    } while (!Validaciones.validarNumero(opcion));
                    int loteRetirable = Integer.parseInt(opcion);
                    int i = 0;
                    for (Medicamento medicamento : listaMedicamentos) {
                        if (medicamento.retirarLote(loteRetirable))
                            i++;
                    }
                    if (i==0) {
                        System.out.println("el numero ingresado no es un lote valido, debe coincidir con el numero de lote de algun medicamento");
                    }else{
                        System.out.println("Se retiraron "+i+" lotes");
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

    public static boolean verificarLoteRepetido(ArrayList<Medicamento> listaMedicamentos, Medicamento foo) {
        Boolean bLote = false;
        if(listaMedicamentos!=null){
            for (Medicamento medicamento : listaMedicamentos) {
                if (medicamento.getCodigoMedicamento() == foo.getCodigoMedicamento()) {
                    if(medicamento.getNumeroLote() == foo.getNumeroLote()){
                    bLote = true;
                    }
                }
            }
        }
        return bLote;
    }
}