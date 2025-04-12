/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8.Librerias.Pila;

/**
 *
 * @author fernandafajardo
 */
public class NodoPila {
    
    private String operacion;
    private int numero;
    private String descripcion;
    private NodoPila sig;

    public NodoPila() {
    }

    public NodoPila(String operacion, int numero, String descripcion) {
        this.operacion = operacion;
        this.numero = numero;
        this.descripcion = descripcion;
        this.sig = null;
    }

    /**
    * Obtiene la operación almacenada en el nodo.
    * @return La operación en forma de cadena.
    */
    public String getOperacion() {
        return operacion;
    }
    
    /**
     * Establece la operación en el nodo.
     * @param operacion La operación a asignar.
     */
    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }
    
    /**
     * Obtiene el número almacenado en el nodo.
     * @return El número entero almacenado.
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * Establece el número en el nodo.
     * @param numero El número a asignar.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el siguiente nodo en la pila.
     * @return El siguiente nodo en la pila.
     */
    public NodoPila getSig() {
        return sig;
    }

    /**
     * Establece el siguiente nodo en la pila.
     * @param sig El nodo que será el siguiente en la pila.
     */
    public void setSig(NodoPila sig) {
        this.sig = sig;
    }

    /**
     * Obtiene la descripción almacenada en el nodo.
     * @return La descripción en forma de cadena.
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Establece la descripción en el nodo.
     * @param descripcion La descripción a asignar.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Devuelve una representación en cadena del nodo, incluyendo la operación,
     * el número y la descripción.
     * @return Una cadena con la información del nodo.
     */
    @Override
    public String toString() {
        return "Operacion: " + operacion + ", valor: " + numero +
               ", descripcion: " + descripcion;
    }
}
