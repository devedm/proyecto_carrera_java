/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author Eddy Mena Lopez
 * @author fernandafajardo
 */
public class Jugador {
    private String nombre;
    private int numeroJugador;


    public Jugador(String nombre, int numeroJugador) {
        this.nombre = nombre;
        this.numeroJugador = numeroJugador;

    }

    /**
     * Obtiene el nombre del jugador.
     * 
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del jugador.
     * 
     * @param nombre El nombre que se asignará al jugador.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número identificador del jugador.
     * 
     * @return El número del jugador.
     */
    public int getNumeroJugador() {
        return numeroJugador;
    }

    /**
     * Establece el número identificador del jugador.
     * 
     * @param numeroJugador El número que se asignará al jugador.
     */
    public void setNumeroJugador(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }
    

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", numero de jugador: " + numeroJugador;
    }
}
