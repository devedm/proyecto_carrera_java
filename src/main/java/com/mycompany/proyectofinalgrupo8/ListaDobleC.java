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
            setTop(nuevoJugador);
            setUltimo(nuevoJugador);
            top.setSig(top); // apunta a sí mismo
            top.setAnterior(top); // apunta a sí mismo
        }
        else if(jugador.getNombre().compareTo(top.getJugador().getNombre()) < 0){ // CASO 2: Insertar al principio
            nuevoJugador.setSig(top);
            top.setAnterior(nuevoJugador);
            top = nuevoJugador;
            nuevoJugador.setAnterior(ultimo);
            ultimo.setSig(top);
        }
        else if(jugador.getNombre().compareTo(ultimo.getJugador().getNombre()) >= 0){ // CASO 3: Inserta al final
            ultimo.setSig(nuevoJugador);
            nuevoJugador.setAnterior(ultimo);
            ultimo = nuevoJugador;
            nuevoJugador.setSig(top);
            top.setAnterior(ultimo);
        }else { // CASO 4: Insertar en el medio
            NodoDoble aux = top;
            while(aux.getSig() != top && aux.getSig().getJugador().getNombre().compareTo(jugador.getNombre()) < 0){
                aux = aux.getSig();
            }
            nuevoJugador.setSig(aux.getSig());
            nuevoJugador.setAnterior(aux);
            aux.setSig(nuevoJugador);
            nuevoJugador.getSig().setAnterior(nuevoJugador);
        }
    }
    
    public void verBitacora(){
        if(esVacia()){
            System.out.println("No hay jugadores registrados.");
        }
        
        Scanner scanner = new Scanner(System.in);
        NodoDoble actual = top;
        String opcion = "";
        
        do{
            System.out.println("Nombre: " + actual.getJugador().getNombre());
            System.out.println("Posiciones históricas:");
            actual.getJugador().getPosicionesHistoricas().mostrarPosicion();
            
            System.out.println("\nNavegador: [Siguiente: S | Anterior: A | Salir: X]");
            opcion = scanner.nextLine().toUpperCase();
            
            if(opcion.equals("S")){
                actual = actual.getSig(); // se mueve al siguente jugador
            }else if(opcion.equals("A")){
                actual = actual.getAnterior(); // se mueve al anterior jugador
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
