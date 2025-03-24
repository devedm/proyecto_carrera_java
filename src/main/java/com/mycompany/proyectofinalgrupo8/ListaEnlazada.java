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
     * Inserta una nueva posición en la lista al principio del historial
     * @param posicion La posición a registrar en la lista.
     */
    public void insertarPosicion(int posicion){
        
        NodoDoble nuevaPos = new NodoDoble(posicion); // Nodo almancena un int posicion del jugador
        
        if(top == null){
            top = nuevaPos;
        }else{
            nuevaPos.setSig(top);
            top = nuevaPos;
        }
    }
    
}
