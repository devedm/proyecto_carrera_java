/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author fernandafajardo
 */
public class NodoCola {
    
    private Jugador jugador;
    private NodoCola sig;

    public NodoCola() {
    }

    /**
    * Constructor de la clase NodoCola.
    * Crea un nodo con un jugador y referencia nula al siguiente nodo.
    * @param nombre Jugador que se almacenará en el nodo.
    */
    public NodoCola(Jugador nombre) {
        this.jugador = nombre;
        this.sig = null;
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
     * @param jugador Jugador a almacenar en el nodo.
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    /**
     * Obtiene el siguiente nodo en la cola.
     * @return El siguiente nodo en la cola.
     */
    public NodoCola getSig() {
        return sig;
    }

    /**
     * Establece el siguiente nodo en la cola.
     * @param sig Nodo que será el siguiente en la cola.
     */
    public void setSig(NodoCola sig) {
        this.sig = sig;
    }
}
