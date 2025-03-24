/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author fernandafajardo
 * @author William Bastos
 */
public class ColaJugadores extends ColaGenerica{

    /**
     * *
     * Muestra los jugadores en cola.
     */
    public void mostrarJugadores() {

        if (esVacia()) {
            System.out.println("No hay jugadores inscritos.");
            return;
        }

        NodoCola actual = getFrente();
        while (actual != null) {
            System.out.println("- " + actual.getJugador().toString());
            actual = actual.getSig();
        }
    }

    /**
     * Metodo para determinar cuantos jugadores hay en la cola
     * @return cantidad de jugadores en la cola
     */
    public int tamanoCola() {
        int cantidadJugadores = 0;

        if (esVacia()) {
            System.out.println("La cola esta vacia.");
            return cantidadJugadores;
        } 
        else {
            NodoCola actual = getFrente();
            while (actual != null) {
                cantidadJugadores++;
                actual = actual.getSig();
            }
        }
        return cantidadJugadores;
    }

    /**
     * Muestra la posicion de cada jugador en la cola
     */
    public void mostrarPosicionCola() {
        if (esVacia()) {
            System.out.println("No hay jugadores en la cola.");
            return;
        }

        NodoCola actual = getFrente();
        int posicion = 1;
        while (actual != null) {
            System.out.println("El jugador " + actual.getJugador().getNombre() + " esta en la posicion " + posicion + " de la cola");
            posicion++;
            if (posicion > tamanoCola()) {
                posicion = 1;
            }
        }
    }

    /**
     * Muestra el jugador que tiene el turno en la cola
     */
    public void mostrarTurno() {
        if (esVacia()) {
            System.out.println("La cola esta vacia.");
            return;
        }

        NodoCola actual = getFrente();
        System.out.println("\nEs el turno del jugador: " + actual.getJugador().getNombre());
    }

    
    /**
     * Remueve de la cola el jugador cuyo ID coincide con el parametro dado
     * @param id id del jugador que quiere salir del juego
     * @return {@code true} si encontro y removio un jugador con el ID especificado
     *         {@code false} no encontro un jugador con el ID especificado
     * @throws java.lang.Exception si la cola esta vacia ya que utiliza el metodo desencolar()
     */
    public boolean removerJugadorPorId(int id) throws Exception{
        if (esVacia()){
            return false;
        }
        
        // si el jugador a remover es el de la cabeza de la cola
        if (getFrente().getJugador().getNumeroJugador() == id){
            desencolar();
            return true;
        }
        NodoCola anterior = getFrente();
        NodoCola actual = getFrente().getSig();
        
        while (actual != null){
            if (actual.getJugador().getNumeroJugador() == id){
                anterior.setSig(actual.getSig());
                // si se elimina el ultimo
                if (actual == getUltimo()){
                    setUltimo(anterior);
                }
                return true;
            }
            anterior = actual;
            actual = actual.getSig();
        }
        return false;
    }
}
