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

    public NodoDoble getTop() {
        return top;
    }

    public void setTop(NodoDoble top) {
        this.top = top;
    }

    public NodoDoble getUltimo() {
        return ultimo;
    }

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
            System.out.println("Posiciones históricas:");
//            actual.getJugador().getPosicionesHistoricas().mostrarPosicion(); // arreglar
            
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
