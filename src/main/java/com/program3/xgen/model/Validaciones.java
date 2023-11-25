package com.program3.xgen.model;

public class Validaciones {
    /**función que devuelve verdadero o falso si un String es un número entero o no
     * @param cambiar
     * @return
     */
    public static boolean validarNumero(String cambiar) {
        try {
            Double.parseDouble(cambiar);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }    
}
