/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8.Librerias.Cola;

import com.mycompany.proyectofinalgrupo8.Jugador;

/**
 *
 * @author fernandafajardo
 */
public class NodoCola {
    
    private Jugador jugador;
    private NodoCola sig;

    public NodoCola() {
    }

    public NodoCola(Jugador nombre) {
        this.jugador = nombre;
        this.sig = null;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public NodoCola getSig() {
        return sig;
    }

    public void setSig(NodoCola sig) {
        this.sig = sig;
    }
}
