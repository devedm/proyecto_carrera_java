/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8.Librerias.Lista;

import com.mycompany.proyectofinalgrupo8.Jugador;

/**
 *
 * @author fernandafajardo
 */
public class NodoDoble {
    
    private Jugador jugador;
    private int posicion;
    private ListaEnlazada historial;
    private NodoDoble sig;
    private NodoDoble anterior;

    public NodoDoble(Jugador Jugador) {
        this.jugador = Jugador;
        this.historial = new ListaEnlazada();
        this.sig = null;
        this.anterior = null;
    }

    /**
    * Constructor de la clase NodoDoble.
    * Inicializa un nodo con una posición específica.
    * @param posicion La posición que tendrá el nodo.
    */
    public NodoDoble(int posicion) {
        this.posicion = posicion;
    }
    
    /**
    * Obtiene el jugador almacenado en el nodo.
    * @return El jugador del nodo.
    */
    public Jugador getJugador() {
        return jugador;
    }
    
    /**
     * Asigna un jugador al nodo.
     * @param Jugador El jugador a almacenar en el nodo.
     */
    public void setJugador(Jugador Jugador) {
        this.jugador = Jugador;
    }

    /**
     * Obtiene el siguiente nodo en la lista doblemente enlazada.
     * @return El siguiente nodo en la lista.
     */
    public NodoDoble getSig() {
        return sig;
    }

    /**
     * Establece el siguiente nodo en la lista doblemente enlazada.
     * @param sig Nodo que será el siguiente en la lista.
     */
    public void setSig(NodoDoble sig) {
        this.sig = sig;
    }

    /**
     * Obtiene el nodo anterior en la lista doblemente enlazada.
     * @return El nodo anterior en la lista.
     */
    public NodoDoble getAnterior() {
        return anterior;
    }

    /**
     * Establece el nodo anterior en la lista doblemente enlazada.
     * @param anterior Nodo que será el anterior en la lista.
     */
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    /**
     * Obtiene la posición del nodo.
     * @return La posición del nodo.
     */
    public int getPosicion() {
        return posicion;
    }
    
    /**
     * Asigna una posición al nodo.
     * @param posicion La posición a establecer en el nodo.
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    /**
     * Obtiene el historial asociado al nodo.
     * @return La lista enlazada que representa el historial.
     */
    public ListaEnlazada getHistorial() {
        return historial;
    }

    /**
     * Establece el historial asociado al nodo.
     * @param historial La lista enlazada que representará el historial.
     */
    public void setHistorial(ListaEnlazada historial) {
        this.historial = historial;
    }
}
