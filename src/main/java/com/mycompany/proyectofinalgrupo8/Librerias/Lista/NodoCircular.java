/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8.Librerias.Lista;

/**
 *
 * @author Eddy Mena
 */
public class NodoCircular {
    private int posicion;
    private String nombreJugador;
    private NodoCircular siguiente;

    public NodoCircular(int posicion) {
        this.posicion = posicion;
        this.nombreJugador = "";
        this.siguiente = null;
    }
    
    /**
     * Obtiene la posición del nodo en la lista circular.
     * @return La posición del nodo.
     */
    public int getPosicion() {
        return posicion;
    }
    
    /**
     * Establece la posición del nodo en la lista circular.
     * @param posicion La nueva posición del nodo.
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
    * Obtiene el nombre del jugador asociado a este nodo.
    * @return Nombre del jugador.
    */
    public String getNombreJugador() {
        return nombreJugador;
    }

    /**
    * Establece el nombre del jugador en este nodo.
    * @param nombreJugador Nombre del jugador a asignar.
    */
    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }
    
    /**
     * Obtiene el siguiente nodo en la lista circular.
     * @return El siguiente nodo.
     */
    public NodoCircular getSiguiente() {
        return siguiente;
    }
    
    /**
     * Establece el siguiente nodo en la lista circular.
     * @param siguiente Nodo que será el siguiente en la lista.
     */
    public void setSiguiente(NodoCircular siguiente) {
        this.siguiente = siguiente;
    }
}
