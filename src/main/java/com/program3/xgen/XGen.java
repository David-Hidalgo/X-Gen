/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.program3.xgen;

import com.program3.xgen.view.*;
import com.program3.xgen.model.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.ComponentInputMap;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author David
 */
public class XGen{

    private static String contraseña="amigo";
    private static String nombreCliente;
    private Bienvenida interfazBienvenida;
    private ArrayList<Medicamento> listaMedicamentos = new ArrayList<>();
    private PanelAdministrador panelAdministrador;
    private ArrayList<Medicamento> carrito =new ArrayList<>();
    

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
    
    public <t extends Medicamento >void añadirMedicamentoCliente(javax.swing.JTable table, t medicamento){
        Object[] nuevo={medicamento, medicamento.getPrecio(), medicamento.getExistencia(), 0};
        DefaultTableModel modelName = (DefaultTableModel) table.getModel();
        modelName.addRow(nuevo);
    }
    
    
    public void cerrarPanelEditar(javax.swing.JTabbedPane jTabbedPane, javax.swing.JPanel jPanel){
        int a= jTabbedPane.indexOfComponent(jPanel);
        System.out.println(a);
        System.out.println();
        jTabbedPane.removeTabAt(a);
        jTabbedPane.setSelectedIndex(0);
    }
    
    public void obtenerListaCliente(javax.swing.JTable table){
        for (Medicamento medicamento: listaMedicamentos){
            añadirMedicamentoCliente(table, medicamento);
        }
    }
    
    public Object[][] obtenerLista(){
        int contador=0;
        int m=4;
        Object[][] data=new Object[listaMedicamentos.size()][m];
        for (Medicamento medicamento : listaMedicamentos) {
            Object[] nuevo={medicamento.getNombreMedicamento(), medicamento.getCodigoMedicamento(), medicamento.getPrecio(), medicamento.getExistencia()};
            data[contador]=nuevo;
            contador++;
        }
        return data;
    }
        public void MostrarMedicamento(int indice, javax.swing.JTabbedPane g, javax.swing.JFrame frame){
        MedicamentoAmbiente medicamentoA;
        Object medicamento;
        PanelMedicamentoMostrar panelEditar;
        medicamento = this.getListaMedicamentos().get(indice);
        if(this.getListaMedicamentos().get(indice) instanceof MedicamentoRefrigerado medicamentoR){
            panelEditar = new PanelMedicamentoMostrar<MedicamentoRefrigerado>(this, medicamentoR);
        }else{
            medicamentoA=(MedicamentoAmbiente)this.getListaMedicamentos().get(indice);
            panelEditar = new PanelMedicamentoMostrar<MedicamentoAmbiente>(this, medicamentoA);
        }
        g.addTab("editar: "+medicamento.toString(), panelEditar);
        g.setSelectedIndex(g.indexOfComponent(panelEditar));
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    public void editarMedicamento(int indice, javax.swing.JTabbedPane g, javax.swing.JFrame frame){
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
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    public void crearPanelUsuario(Bienvenida bienvenida){
        bienvenida.dispose();
        PanelCliente pc= new PanelCliente(this);
        pc.setVisible(true);
    }
    public void crearPanelAdministrador(){
        PanelAdministrador pa= new PanelAdministrador(this);
        pa.setVisible(true);
        panelAdministrador=pa;
    }
    public <t extends Medicamento> void actualizarMedicamentoCrear(t medicamento, com.program3.xgen.view.PanelMedicamentoCrear panelMedicamento){
        int indice=listaMedicamentos.indexOf(medicamento);
        listaMedicamentos.set(indice, medicamento);
        panelAdministrador.dispose();
        this.crearPanelAdministrador();
    }

    public void comprar(){
        
    }

    public ArrayList<Medicamento> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Medicamento> carrito) {
        this.carrito = carrito;
    }
    
    public <t extends Medicamento> void actualizarMedicamento(t medicamento, com.program3.xgen.view.PanelMedicamento panelMedicamento){
        int indice=listaMedicamentos.indexOf(medicamento);
        listaMedicamentos.set(indice, medicamento);
        panelAdministrador.dispose();
        this.crearPanelAdministrador();
    }
    public void crearMedicamentoAmbiente(javax.swing.JTabbedPane g, javax.swing.JFrame frame){
        MedicamentoAmbiente medicamento= new MedicamentoAmbiente();
        PanelMedicamentoCrear panelCrear;
        panelCrear = new PanelMedicamentoCrear<MedicamentoAmbiente>(this, medicamento);
        g.insertTab("crear", null, panelCrear, "suerte", 1);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    public void crearMedicamentoRefrigerado(javax.swing.JTabbedPane g, javax.swing.JFrame frame){
        MedicamentoRefrigerado medicamento= new MedicamentoRefrigerado();
        PanelMedicamentoCrear panelCrear;
        panelCrear = new PanelMedicamentoCrear<MedicamentoRefrigerado>(this, medicamento);
        g.insertTab("crear", null, panelCrear, "suerte", 1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        
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
