/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author fernandafajardo
 */
public class ListaEnlazada {
    
    public NodoDoble top;

    public ListaEnlazada() {
        this.top = null;
    }

    public NodoDoble getTop() {
        return top;
    }

    public void setTop(NodoDoble top) {
        this.top = top;
    }
    
    /***
     * Inserta un nuevo nodo con un jugador en la posición especificada al principio de la lista
     * @param posicion La posición que el jugador ocupará en la lista
     */
    public void insertarPosicion(int posicion){
        
        NodoDoble nPosicion = new NodoDoble(new Jugador("Posición " + posicion, 0 , posicion));
        
        if(top == null){
            top = nPosicion;
        }else{
            nPosicion.setSig(top);
            top = nPosicion;
        }
    }
    
    /***
     * Muestra la posición en la cual se encuentra el jugador
     */
    public void mostrarPosicion(){
        
        NodoDoble actual = top;
        while(actual != null){
            System.out.println("Posición histórica: "+ actual.getJugador().getPosicion());
            actual = actual.getSig();
        }
    }
}
