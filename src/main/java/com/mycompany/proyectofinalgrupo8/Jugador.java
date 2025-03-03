/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author Eddy Mena Lopez
 */
public class Jugador {
    private String nombre;
    private int numeroJugador;
    private int posicion;

    public Jugador(String nombre, int numeroJugador, int posicion) {
        this.nombre = nombre;
        this.numeroJugador = numeroJugador;
        this.posicion = posicion;
    }

    public int moverJugador(int movimientos){
        int nuevaPos = this.posicion + movimientos; 
        if(nuevaPos < 0){
            setPosicion(0);
            return getPosicion();
        } else {
            setPosicion((this.posicion + movimientos));
            return getPosicion();
        }
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

    /**
     * Obtiene la posición actual del jugador en el juego.
     * 
     * @return La posición del jugador.
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Establece la posición actual del jugador en el juego.
     * 
     * @param posicion La posición que se asignará al jugador.
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    
    @Override
    public String toString(){
        return getNombre();
    }

}
