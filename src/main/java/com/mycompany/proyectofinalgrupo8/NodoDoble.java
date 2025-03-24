/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

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

    public NodoDoble(int posicion) {
        this.posicion = posicion;
    }
    
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador Jugador) {
        this.jugador = Jugador;
    }

    public NodoDoble getSig() {
        return sig;
    }

    public void setSig(NodoDoble sig) {
        this.sig = sig;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public ListaEnlazada getHistorial() {
        return historial;
    }

    public void setHistorial(ListaEnlazada historial) {
        this.historial = historial;
    }
    
    
}
