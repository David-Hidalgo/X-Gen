/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.program3.xgen;

import com.program3.xgen.view.*;
import com.program3.xgen.model.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author David
 */
public class XGen{

    private static String contraseña="amigo";
    private static String nombreCliente;

    public static String getContraseña() {
        return contraseña;
    }

    public static void setContraseña(String aContraseña) {
        contraseña = aContraseña;
    }

    public static String getNombreCliente() {
        return nombreCliente;
    }

    public static void setNombreCliente(String aNombreCliente) {
        nombreCliente = aNombreCliente;
    }
    private Bienvenida interfazBienvenida;
    private ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();

    public static void llenarUsuario(String dato) {
        nombreCliente = dato;
        System.out.print(dato);
    }
    
    public static boolean compararContraseña(String dato){
        if(contraseña.equals(dato)){
        System.out.print(dato);
        return true;    
        }else return false; 
    }   

    public Bienvenida getInterfazBienvenida() {
        return interfazBienvenida;
    }

    public void setInterfazBienvenida(Bienvenida interfazBienvenida) {
        this.interfazBienvenida = interfazBienvenida;
    }

    public ArrayList<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }

    public void setListaMedicamentos(ArrayList<Medicamento> nueva) {
        listaMedicamentos = nueva;
    }
    
    public Object[][] obtenerLista(){
        int contador=0;
        int m=4;
        Object[][] data=new Object[listaMedicamentos.size()][m];
        for (Medicamento medicamento : listaMedicamentos) {
            Object[] nuevo={medicamento.getNombreMedicamento(), medicamento.getCodigoMedicamento(), medicamento.getCosteProduccion(), medicamento.getExistencia()};
            data[contador]=nuevo;
            contador++;
        }
        return data;
    }
    
    public void editarMedicamento(int indice, javax.swing.JTabbedPane g){
        MedicamentoAmbiente medicamentoA;
        Object medicamento;
        PanelMedicamento panelEditar;
        medicamento = this.getListaMedicamentos().get(indice);
        if(this.getListaMedicamentos().get(indice) instanceof MedicamentoRefrigerado medicamentoR){
            panelEditar = new PanelMedicamento<MedicamentoRefrigerado>(this, medicamentoR);
        }else{
            medicamentoA=(MedicamentoAmbiente)this.getListaMedicamentos().get(indice);
            panelEditar = new PanelMedicamento<MedicamentoAmbiente>(this, medicamentoA);
        }
        g.addTab("editar: "+medicamento.toString(), panelEditar);
        g.setSelectedIndex(g.indexOfComponent(panelEditar));
        
    }
    
    public <t extends Medicamento> void actualizarMedicamento(t medicamento, javax.swing.JFormattedTextField nombre, javax.swing.JFormattedTextField codigo, javax.swing.JFormattedTextField nLote, javax.swing.JFormattedTextField coste){
        
    }

    public static void main(String[] args) {
        GregorianCalendar fecha1 = new GregorianCalendar(2030, 10, 10);
        GregorianCalendar fecha2 = new GregorianCalendar(2023, 10, 10);
        
        MedicamentoRefrigerado fuerte = new MedicamentoRefrigerado("Paracetamol", 12345678, 1000, fecha1, 20, 1000, 0, 1, 1, 0, 10, " nevera", "baja", "baja", "en camión refrigerado", 4);
        MedicamentoAmbiente basico = new MedicamentoAmbiente("Ibuprofeno", 87654321, 1000, fecha1, 25, 50, 1, 1, 1, "En el motor de un carro", "En lugares húmedos", "Cerca de niños");
        MedicamentoRefrigerado frio = new MedicamentoRefrigerado("Acetaminofen", 123453432, 1000, fecha2, 21, 1000, 0, 1, 1, 0, 10, " nevera", "baja", "baja", "en camión refrigerado", 4);
        
        XGen controlador =new XGen();
        controlador.listaMedicamentos.add(fuerte);
        controlador.listaMedicamentos.add(basico);
        controlador.listaMedicamentos.add(frio);

        System.out.println("Hello World!");
        controlador.setInterfazBienvenida(new Bienvenida(controlador));
        controlador.getInterfazBienvenida().setEnabled(true);
        controlador.getInterfazBienvenida().setVisible(true);
        
        System.out.println("A VER!");
    }
}
