/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

import java.util.Scanner;

/**
 *
 * @author fernandafajardo
 */
public class ListaDobleC {
    
    private NodoDoble top;
    private NodoDoble ultimo;

    public ListaDobleC() {
        this.top = null;
        this.ultimo = null;
    }
    /**
     * Obtiene el nodo superior (top) de la estructura.
     * @return NodoDoble que representa el nodo superior.
     */
    public NodoDoble getTop() {
        return top;
    }
    /**
     * Establece el nodo superior (top) de la estructura.
     * @param top NodoDoble que se asignará como el nodo superior.
     */
    public void setTop(NodoDoble top) {
        this.top = top;
    }
    /**
     * Obtiene el último nodo de la estructura.
     * @return NodoDoble que representa el último nodo.
     */
    public NodoDoble getUltimo() {
        return ultimo;
    }
    /**
     * Establece el último nodo de la estructura.
     * @param ultimo NodoDoble que se asignará como el último nodo.
     */
    public void setUltimo(NodoDoble ultimo) {
        this.ultimo = ultimo;
    }
    
    /***
     * Inserta un jugador en una lista doblemente enlazada circular
     * @param jugador El jugador que se va a insertar en la lista
     */
    public void insertarJugador(Jugador jugador){
        
        NodoDoble nuevoJugador = new NodoDoble(jugador);
        if(esVacia()){ // CASO 1: La lista esta vacía
            top = nuevoJugador;
            ultimo = nuevoJugador;
            top.setSig(top); // apunta a sí mismo
            top.setAnterior(top); // apunta a sí mismo
        }
        else if(jugador.getNombre().compareTo(top.getJugador().getNombre()) < 0){ // CASO 2: Insertar al principio
            nuevoJugador.setSig(top);
            nuevoJugador.setAnterior(ultimo);
            top.setAnterior(nuevoJugador);
            ultimo.setSig(nuevoJugador);
            top = nuevoJugador; // actualizamos el nuevo top
        }
        else if(jugador.getNombre().compareTo(ultimo.getJugador().getNombre()) >= 0){ // CASO 3: Inserta al final
            nuevoJugador.setAnterior(ultimo);
            nuevoJugador.setSig(top);
            ultimo.setSig(nuevoJugador);
            top.setAnterior(nuevoJugador);
            ultimo = nuevoJugador; // actualizamos el nuevo último
        }else { // CASO 4: Insertar en el medio
            NodoDoble aux = top;
            while(aux.getSig() != top && aux.getSig().getJugador().getNombre().compareTo(jugador.getNombre()) < 0){
                aux = aux.getSig();
            }
            nuevoJugador.setSig(aux.getSig());
            nuevoJugador.setAnterior(aux);
            aux.getSig().setAnterior(nuevoJugador);
            aux.setSig(nuevoJugador);
        }
    }
    /**
    * Busca un jugador en la estructura de nodos dobles.
    * @param jugador Jugador que se desea buscar.
    * @return NodoDoble que contiene al jugador si se encuentra, de lo contrario, retorna null.
    */
    public NodoDoble buscarJugador(Jugador jugador){
        NodoDoble actual = top;
    
        do {
            if (actual.getJugador().equals(jugador)) { // Comparamos el jugador del nodo con el buscado
                return actual; // Retorna el nodo si encuentra el jugador
            }
            actual = actual.getSig(); // Avanza al siguiente nodo
        } while (actual != top); // Se detiene cuando da la vuelta completa
            return null; // Si no lo encuentra, devuelve null
    }
    
    /***
     * Muestra la bitácora de jugadores registrados, permitiendo navegar entre ellos
     */
    public void verBitacora(){
        if(esVacia()){
            System.out.println("No hay jugadores registrados.");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        NodoDoble actual = top;
        String opcion;
        
        do{
            System.out.println("Nombre: " + actual.getJugador().getNombre());
            System.out.println("Posiciones historicas:");
            actual.getHistorial().recorrer();
            
            System.out.println("\nNavegador: [Siguiente: S | Anterior: A | Salir: X]");
            opcion = scanner.nextLine().toUpperCase();
            
            switch(opcion){
                case "S":
                    actual = actual.getSig();
                    break;
                case "A":
                    actual = actual.getAnterior();
                    break;
            }
            
        }while(!opcion.equals("X"));
    }
    
    /***
     * Verifica si la lista esta vacía
     * @return Cumprueba si el puntero (top) es nulo, lo que indica que no hay elementos en la lista
     */
    public boolean esVacia(){
        return top == null;
    }
 
}
