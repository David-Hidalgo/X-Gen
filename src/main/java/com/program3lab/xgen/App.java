package com.program3lab.xgen;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();        
        Scanner in = new Scanner(System.in);
        int numeroOpcion;
        GregorianCalendar fecha1 = new GregorianCalendar(2030, 10, 10);
        GregorianCalendar fecha2 = new GregorianCalendar(2023, 10, 10);
        
        MedicamentoRefrigerado fuerte = new MedicamentoRefrigerado("Paracetamol", 12345678, 1000, fecha1, 20, 1000, 0, 1, 1, 0, 10, " nevera", "baja", "baja", "en camion refrigerado", 4);
        MedicamentoAmbiente basico = new MedicamentoAmbiente("Ibuprofeno", 87654321, 1000, fecha1, 25, 50, 1, 1, 1, "En el motor de un carro", "En lugares humedos", "Cerca de niños");        
        MedicamentoRefrigerado frio = new MedicamentoRefrigerado("Acetaminofen", 123453432, 1000, fecha2, 21, 1000, 0, 1, 1, 0, 10, " nevera", "baja", "baja", "en camion refrigerado", 4);

        listaMedicamentos.add(fuerte);
        listaMedicamentos.add(basico);
        listaMedicamentos.add(frio);

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Hello, World!");
            System.out.println("Bienvenido al programa Medicamentos");
            System.out.println("¿Qué tipo de usuario es usted?");
            System.out.println("1. Comprador");
            System.out.println("2. Administrador");
            System.out.println("0. Salir");
            String opcion;
            boolean bContinuar;
            do {
                System.out.println("Ingrese un número entre 0 y 2");
                opcion = in.nextLine();
            } while (!Validaciones.validarNumero(opcion));
            numeroOpcion = Integer.parseInt(opcion);
            switch (numeroOpcion) {
                case 1:
                    do {
                        menuComprador(listaMedicamentos, in);
                        bContinuar=continuar(in, "¿Quiere volver al menu principal?");
                    } while (!bContinuar);
                    break;
                case 2:
                    do {
                        menuAdmin(listaMedicamentos, in);
                        bContinuar=continuar(in, "¿Quiere volver al menu principal?");
                    } while (!bContinuar);
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    break;
            }
        } while (numeroOpcion != 0);
        in.close();
    }

    private static boolean menuComprador(ArrayList<Medicamento> listaMedicamentos, Scanner in) {
        
        if (!listaMedicamentos.isEmpty()) {
            int numeroOpcion;
            String opcion;
            do {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Bienvenido al programa Medicamentos");
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. mostrar todos los medicamentos.");
                System.out.println("2. Seleccionar un medicamento para ver su informacion.");
                System.out.println("3. comprar medicamentos.");
                System.out.println("0. Salir");
                do {
                    System.out.println("Ingrese un número entre 0 y 3");
                    opcion = in.nextLine();
                } while (!Validaciones.validarNumero(opcion));
                numeroOpcion = Integer.parseInt(opcion);
                switch (numeroOpcion) {
                    case 1:
                        for (Medicamento medicamento : listaMedicamentos) {
                        medicamento.toString();
                        System.out.println();
                        }
                        break;

                    case 2:
                        imprimirInformcaiónString(listaMedicamentos, in);
                        break;

                    case 3:
                            comprar(in, listaMedicamentos);
                        break;

                    default:
                        break;
                }
            } while (numeroOpcion!=0);
        return true;
        }else{
        System.out.println("No hay medicamentos en el inventario");
        System.out.println("Presione enter para continuar");
        in.nextLine();
        return false;
        }
    }


    private static void comprar(Scanner in ,ArrayList<Medicamento> listaMedicamentos) {
        String continuar;
        boolean bContinuar;
        if (listaMedicamentos.isEmpty()) {
            System.out.println("No hay medicamentos en el inventario");
            System.out.println("Presione enter para continuar");
            in.nextLine();
        }else{
            do {
                int contador = 0;
                System.out.println("Selecciones el medicamento que quiere comprar");
                contador=listaMedicamentos.indexOf(seleccionarMedicamento(listaMedicamentos, in));
                listaMedicamentos.get(contador).imprimirInformacion();
                System.out.println("Cuantas unidades quiere comprar?");
                do {
                    continuar = in.nextLine();
                    if(!Validaciones.validarNumero(continuar))
                    System.out.println("Ingrese un numero por favor");
                } while (!Validaciones.validarNumero(continuar));
                int unidades = Integer.parseInt(continuar);
                System.out.println("El precio total a pagar es de "+listaMedicamentos.get(contador).getPrecio()*unidades);
                bContinuar=continuar(in, "¿Quiere comprar este medicamento?");
                if (bContinuar) {
                    listaMedicamentos.get(contador).setUnidadesVendidas(listaMedicamentos.get(contador).getUnidadesVendidas()+unidades);
                    System.out.println("Medicamento comprado con exito");
                }else{
                    System.out.println("Medicamento no comprado");
                }
                System.out.println("Presione enter para continuar");
                in.nextLine();
                bContinuar=continuar(in, "¿Quiere comprar otro medicamento?");
            } while (bContinuar);
        }
    }

    private static boolean menuAdmin(ArrayList<Medicamento> listaMedicamentos, Scanner in) {
        String opcion;
        int numeroOpcion;
        do {
            do{
            System.out.println();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Bienvenido al programa Medicamentos");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Crear un medicamento");
            System.out.println("2. mostrar medicamentos.");
            System.out.println("3. Establecer Precio de venta en % de ganancias.");
            System.out.println("4. Colocar Ofertas");
            System.out.println("5. Verificar si está vencido");
            System.out.println("6. Verificar si es necesario reponer inventario");
            System.out.println("7. Remover lotes de inventario");
            System.out.println("8. Eliminar medicamento");
            System.out.println("9. editar un medicamento.");
            System.out.println("0. Salir");
                do {
                    System.out.println("Ingrese un número entre 0 y 8");
                    opcion = in.nextLine();
                } while (!Validaciones.validarNumero(opcion));
                numeroOpcion = Integer.parseInt(opcion);
                if((numeroOpcion!=1 && numeroOpcion!=0)&& (listaMedicamentos.isEmpty())){
                    System.out.println("No hay medicamentos en el inventario");
                    System.out.println("Presione enter para continuar");
                    in.nextLine();
                }
            }while((numeroOpcion!=1 && numeroOpcion!=0) && (listaMedicamentos.isEmpty()));
            System.out.println();
            switch (numeroOpcion) {
                case 1:
                    boolean condition;
                    System.out.println("Menú de creación");
                    do {
                        System.out.println("¿Qué tipo de medicamento desea crear?");
                        System.out.println("1. Medicamento Ambiente");
                        System.out.println("2. Medicamento Refrigerado");
                        do {
                            do {
                                System.out.println("Ingrese un número entre 1 y 2");
                                opcion = in.nextLine();
                            } while (!Validaciones.validarNumero(opcion));
                            numeroOpcion = Integer.parseInt(opcion);
                            if(numeroOpcion>2 || numeroOpcion<1){
                                System.out.println("Error");
                                condition =false;
                            }else{
                                condition = true;}
                        } while (!condition);
                        switch (numeroOpcion) {
                            case 1:
                                Medicamento foo = new MedicamentoAmbiente();
                                foo.leerDatos();
                                while (verificarLoteRepetido(listaMedicamentos, foo)) {
                                    System.out.println("El lote ingresado ya existe, ingrese otro");
                                    foo.modificarLote();
                                }
                                System.out.println("Medicamento creado con éxito");
                                System.out.println("Presione una tecla para continuar");
                                in.nextLine();
                                listaMedicamentos.add(foo);
                            break;
                            case 2:
                                Medicamento foo2 = new MedicamentoRefrigerado();
                                foo2.leerDatos();
                                while (verificarLoteRepetido(listaMedicamentos, foo2)) {
                                    System.out.println("El lote ingresado ya existe, ingrese otro");
                                    foo2.modificarLote();
                                }
                                System.out.println("Medicamento creado con éxito");
                                System.out.println("Presione una tecla para continuar");
                                in.nextLine();
                                listaMedicamentos.add(foo2);
                            break;
                        }
                        System.out.println("Medicamento creado con éxito");
                        System.out.println("Presione una tecla para continuar");
                        in.nextLine();
                        condition = continuar(in, "¿Desea crear otro Medicamento?");
                    } while (condition);
                    break;
                case 2:
                    imprimirInformcaiónString(listaMedicamentos, in);
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
                        listaMedicamentos.get(numeroOpcion).precioAPagar(in);
                        condition = continuar(in, "¿Desea modificar el precio de otro Medicamento?");
                    } while (condition);                
                    System.out.println("Presione enter para continuar");
                    in.nextLine();
                    
                break;
                case 4:
                    if (listaMedicamentos.isEmpty()) {
                        System.out.println("No hay medicamentos en el inventario");
                        System.out.println("Presione enter para continuar");
                        in.nextLine();
                    }else{
                        System.out.println("¿Quiere colocar ofertas a los lotes de medicina que van a vencer?");
                        for (Medicamento medicamento : listaMedicamentos) {
                            medicamento.colocarOferta();
                        }
                        System.out.println("Presione enter para continuar");
                        in.nextLine();
                        System.out.println();
                    }
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
                    int contador2 = 0;
                    for (Medicamento medicamento : listaMedicamentos) {
                        if (medicamento.retirarLote(loteRetirable))
                            contador2++;
                    }
                    if (contador2==0) {
                        System.out.println("el numero ingresado no es un lote valido, debe coincidir con el numero de lote de algun medicamento");
                    }else{
                        System.out.println("Se retiraron "+contador2+" lotes");
                    }
                    System.out.println();
                    break;
                case 8:
                    eliminarMedicamento(in, listaMedicamentos);
                    break;
                case 9:
                    do {
                        System.out.println("¿Qué medicamento desea editar?");
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
                        listaMedicamentos.get(numeroOpcion).menuCambiarDatos();
                        System.out.println("Medicamento editado con éxito");
                        System.out.println("Presione una tecla para continuar");
                        in.nextLine();
                        condition = continuar(in, "¿Desea editar otro Medicamento?");
                    } while (condition);
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (numeroOpcion != 0);
        return false;
    }

    public static void eliminarMedicamento(Scanner in, ArrayList<Medicamento> listaMedicamentos){
        if (listaMedicamentos.isEmpty()) {
            System.out.println("No hay medicamentos en el inventario");
            System.out.println("Presione enter para continuar");
            in.nextLine();
        }else{
            String continuar;
            Boolean bContinuar = false;
            do {
                int contador = 0;
                System.out.println("Selecciones el medicamento que quiere eliminar");
                contador=listaMedicamentos.indexOf(seleccionarMedicamento(listaMedicamentos, in));
            continuar = "Está seguro de que quiere eliminar el medicamento "+listaMedicamentos.get(contador).getNombreMedicamento()+" con numero de lote "+listaMedicamentos.get(contador).getNumeroLote()+"? ";
            bContinuar=continuar(in, continuar);
            if (bContinuar) {
                listaMedicamentos.remove(contador);
                System.out.println("Medicamento eliminado con exito");
            }else{
                System.out.println("Medicamento no eliminado");
            }
            bContinuar=continuar(in, "¿Quiere Eliminar otro medicamento? ");
            System.out.println();
            } while (bContinuar);
        }
    }

    public static Medicamento seleccionarMedicamento(ArrayList<Medicamento> listaMedicamentos ,Scanner in) {
        System.out.flush();
        String opcion;
        int numeroOpcion;
            System.out.println("¿Qué medicamento desea seleccionar?");
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

        return listaMedicamentos.get(numeroOpcion);
    }

    public static boolean continuar(Scanner in, String MensajeEntrada){
        String continuar;
        Boolean bContinuar = false;
        do {
            System.out.println(MensajeEntrada + " (S/N)");
            continuar = in.nextLine();
            if (continuar.equalsIgnoreCase("S"))
                bContinuar = true;
            else if (continuar.equalsIgnoreCase("N")) {
                bContinuar = false;
            } else {
                continuar = "error";
                System.out.println("Error escoja una opcion valida");
                }
        } while (continuar.equalsIgnoreCase("error"));
        return bContinuar;
    }

    private static void imprimirInformcaiónString(ArrayList<Medicamento> listaMedicamentos, Scanner in) {
        if (listaMedicamentos.isEmpty()) {
            System.out.println("No hay medicamentos en el inventario");
            System.out.println("Presione enter para continuar");
            in.nextLine();
        }else{
        boolean condition;
        int contador = 0;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            contador=listaMedicamentos.indexOf(seleccionarMedicamento(listaMedicamentos, in));
            listaMedicamentos.get(contador).imprimirEspecifico();
            condition = continuar(in, "¿Desea ver la informacion de otro Medicamento?");
        } while (condition);
        System.out.println("Presione enter para continuar");
        in.nextLine();
        }
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