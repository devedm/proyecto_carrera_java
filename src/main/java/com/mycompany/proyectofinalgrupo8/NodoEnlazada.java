/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Eddy Mena
 */
public class NodoEnlazada {
    private int posicion;
    private LocalDateTime hora;
    private String castigo;
    private NodoEnlazada siguiente;

    /**	 
     * Constructor de la clase Nodo.
     * @param dato El valor que se almacenará en el nodo.
     */
    public NodoEnlazada(int dato, LocalDateTime hora, String castigo) {
        this.posicion = dato;
        this.hora = hora;
        this.castigo = castigo;
        this.siguiente = siguiente;
    }

    /**
    * Obtiene la posición del nodo.
    * @return La posición del nodo.
    */
    public int getPosicion() {
        return posicion;
    }

    /**
    * Establece la posición del nodo.
    * @param posicion La nueva posición a asignar.
    */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
    * Obtiene la hora asociada al nodo.
    * @return La hora almacenada en el nodo.
    */
    public LocalDateTime getHora() {
        return hora;
    }
    
    /**
    * Convierte la hora almacenada en el nodo a una cadena con formato HH:mm:ss.
    * @return La hora en formato de cadena.
    */
    public String stringHora() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatoFecha);
    }
    
    /**
     * Establece la hora en el nodo.
     * @param hora La hora a asignar al nodo.
     */
    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el castigo asociado al nodo.
     * @return El castigo almacenado en el nodo.
     */
    public String getCastigo() {
        return castigo;
    }

    /**
     * Establece un castigo en el nodo.
     * @param castigo El castigo a asignar.
     */
    public void setCastigo(String castigo) {
        this.castigo = castigo;
    }

    /**
     * Obtiene el siguiente nodo en la lista enlazada.
     * @return El siguiente nodo en la lista.
     */
    public NodoEnlazada getSiguiente() {
        return siguiente;
    }

    /**
     * Establece el siguiente nodo en la lista enlazada.
     * @param siguiente El nodo que será el siguiente en la lista.
     */
    public void setSiguiente(NodoEnlazada siguiente) {
        this.siguiente = siguiente;
    }

    
}
