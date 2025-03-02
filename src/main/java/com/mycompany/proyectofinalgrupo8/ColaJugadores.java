/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author fernandafajardo
 */
public class ColaJugadores {
    
    private NodoCola frente; //Primer jugador en la cola
    private NodoCola ultimo; //Último jugador en la cola
    private int tamano; //Número de jugadores en la cola
    private static int maxJugadores = 4; //Máximo permitido

    public ColaJugadores() {
        this.frente = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public NodoCola getFrente() {
        return frente;
    }

    public void setFrente(NodoCola frente) {
        this.frente = frente;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public static int getMaxJugadores() {
        return maxJugadores;
    }

    public static void setMaxJugadores(int maxJugadores) {
        ColaJugadores.maxJugadores = maxJugadores;
    }
    
    
    
    /***
     * Agrega un jugador a la cola si no ha alcanzado el límite permitido (4).
     * @param jugador Nombre o alías del jugador
     */
    public void encolar(Jugador jugador){
        
        if(tamano >= maxJugadores){
            System.out.println("No se pueden inscribir más jugadores. Límite alcanzado!");
            return;
        }
        
        NodoCola nuevoJugador = new NodoCola(jugador);
        if(esVacia()){
            this.frente = nuevoJugador;
            this.ultimo = nuevoJugador;
        }else{
            this.ultimo.setSig(nuevoJugador);
            this.ultimo = nuevoJugador;
        }
        this.tamano++;
        System.out.println("Jugador " + jugador + " añadido correctamente.");
    }
    
    
    /***
     * Elimina y retorna el primer jugador de la cola
     * @return Nombre del jugador eliminado
     * @throws Exception Si la cola está vacía, lanza una excepción con el mensaje "Error...".
     */
    public Jugador desencolar() throws Exception{
       
        if(esVacia()){
            throw new Exception("Error: No hay jugadores en la cola.");
        }
        
        NodoCola aux = this.frente; // Guardamos el nodo a eliminar
        this.frente = this.frente.getSig(); // Movemos el frente al sig nodo
        
        if(this.frente == null){
            this.ultimo = null; // Si la cola queda vacía, el último también deber ser null
        }
        this.tamano--; // Disminuimos el tamaño de la cola
        return aux.getJugador(); // Retornamos el nombre del jugador eliminado
    }
    
    
    /***
     * Verifica que la cola esta vacía.
     * @return true si está vacía, false si hay jugadores.
     */
    public boolean esVacia(){
        
        if(this.frente == null){
            return true;
        }else{
            return false;
        }
    }
    
    /***
     * Muestra los jugadores en cola.
     */
    public void mostrarJugadores(){
        
        if(esVacia()){
            System.out.println("No hay jugadores inscritos.");
            return;
        }
        
        NodoCola actual = this.frente;
        while(actual != null){
            System.out.println("- " + actual.getJugador().getNombre());
            actual = actual.getSig();
        }
    }
}
