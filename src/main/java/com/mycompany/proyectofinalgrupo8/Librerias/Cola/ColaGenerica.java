/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8.Librerias.Cola;

import com.mycompany.proyectofinalgrupo8.Jugador;

/**
 *
 * @author Eddy Mena
 */
public class ColaGenerica {
    
    private NodoCola frente; //Primer jugador en la cola
    private NodoCola ultimo; //Último jugador en la cola
    private int tamano; //Número de jugadores en la cola
    private static int maxJugadores = 4; //Máximo permitido

    public ColaGenerica() {
        this.frente = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public NodoCola getFrente() {
        return frente;
    }

    /**
     * *
     * Obtiene el primer jugador en la cola.
     *
     * @return Nodo que representa al primer jugador de la cola.
     */
    public void setFrente(NodoCola frente) {
        this.frente = frente;
    }

    /**
     * *
     * Obtiene el último jugador en la cola.
     *
     * @return Nodo que representa al último jugador de la cola.
     */
    public NodoCola getUltimo() {
        return ultimo;
    }

    /**
     * *
     * Establece el último jugador en la cola.
     *
     * @param ultimo Nodo que será el nuevo último jugador.
     */
    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * *
     * Obtiene el número de jugadores en la cola.
     *
     * @return Cantidad de jugadores en la cola.
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * *
     * Establece el tamaño de la cola.
     *
     * @param tamano Nuevo número de jugadores en la cola.
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    /**
     * *
     * Obtiene el número máximo permitido de jugadores en la cola.
     *
     * @return Límite de jugadores permitido en la cola.
     */
    public static int getMaxJugadores() {
        return maxJugadores;
    }

    /**
     * *
     * Modifica el número máximo de jugadores permitidos en la cola.
     *
     * @param maxJugadores Nuevo límite de jugadores en la cola.
     */
    public static void setMaxJugadores(int maxJugadores) {
        ColaGenerica.maxJugadores = maxJugadores;
    }
    
    /**
     * *
     * Agrega un jugador a la cola si no ha alcanzado el límite permitido (4).
     *
     * @param jugador        Objeto de tipo Jugador que será añadido a la cola.
     * @param mostrarMensaje Indica si se debe mostrar un mensaje de confirmación.
     */
    public void encolar(Jugador jugador, boolean mostrarMensaje) {

        if (tamano >= maxJugadores) {
            System.out.println("No se pueden inscribir más jugadores. Límite alcanzado!");
            return;
        }

        NodoCola nuevoJugador = new NodoCola(jugador);
        if (esVacia()) {
            this.frente = nuevoJugador;
            this.ultimo = nuevoJugador;
        } else {
            this.ultimo.setSig(nuevoJugador);
            this.ultimo = nuevoJugador;
        }
        this.tamano++;

        //System.out.println("Jugador " + jugador + " añadido correctamente.");
        if (mostrarMensaje) {
            System.out.println("Jugador " + jugador.getNombre() + " añadido correctamente.");
        }

    }

    /**
     * *
     * Elimina y retorna el primer jugador de la cola.
     *
     * @return Objeto de tipo Jugador que fue eliminado de la cola.
     * @throws Exception Si la cola está vacía, lanza una excepción con el mensaje "Error: No hay jugadores en la cola.".
     */
    public Jugador desencolar() throws Exception {

        if (esVacia()) {
            throw new Exception("Error: No hay jugadores en la cola.");
        }

        NodoCola aux = this.frente; // Guardamos el nodo a eliminar
        this.frente = this.frente.getSig(); // Movemos el frente al sig nodo

        if (this.frente == null) {
            this.ultimo = null; // Si la cola queda vacía, el último también deber ser null
        }
        this.tamano--; // Disminuimos el tamaño de la cola
        return aux.getJugador(); // Retornamos el nombre del jugador eliminado
    }

    /**
     * *
     * Verifica que la cola esta vacía.
     *
     * @return true si está vacía, false si hay jugadores.
     */
    public boolean esVacia() {

        if (this.frente == null) {
            return true;
        } else {
            return false;
        }
    }
}
