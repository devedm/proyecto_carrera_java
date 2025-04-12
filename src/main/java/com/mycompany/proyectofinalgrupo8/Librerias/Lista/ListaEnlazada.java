/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8.Librerias.Lista;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author fernandafajardo
 */
public class ListaEnlazada {
    
    private NodoEnlazada primero;

    /**	 
     * Constructor de la clase ListaEnlazada.
     */
    public ListaEnlazada() {
    }

    /**	 
     * Obtiene el primer nodo de la lista.
     * @return El primer nodo de la lista.
     */
    public NodoEnlazada getPrimero() {
        return primero;
    }

    /**	 
     * Establece el primer nodo de la lista.
     * @param primero El nuevo primer nodo de la lista.
     */
    public void setPrimero(NodoEnlazada primero) {
        this.primero = primero;
    }
    
    /**	 
     * Inserta un nuevo nodo en la lista en orden ascendente.
     * @param valor El valor a insertar en la lista.
     */
    public void insertaOrdenado(int valor, String castigo){
        LocalDateTime hora = LocalDateTime.now();
        NodoEnlazada nuevo = new NodoEnlazada(valor, hora, castigo);   
        if (this.getPrimero() == null){     
            this.setPrimero(nuevo);    
        }else if (this.getPrimero().getPosicion() > valor) { 
            nuevo.setSiguiente(primero);    
            this.setPrimero(nuevo);           
        } else {      
            NodoEnlazada aux = this.getPrimero(); 
            while (aux.getSiguiente()!= null &&
                   aux.getSiguiente().getPosicion() <= valor){
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);  
        }
    }
    
    /**	 
     * Elimina un nodo de la lista que contenga el valor especificado.
     * @param valor El valor del nodo a eliminar.
     */
    public void eliminarNodo(int valor){
        NodoEnlazada actual = primero;  
        NodoEnlazada anterior = null; 

        while (actual != null && actual.getPosicion() != valor){                                                                  
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (actual == null){
            return;
        } 
        if (anterior == null){ 
            this.setPrimero(actual.getSiguiente());
        }else{
            anterior.setSiguiente(actual.getSiguiente());
        }
    }

    /**	 
     * Elimina un nodo de la lista que contenga el valor especificado y retorna un booleano indicando si se eliminó.
     * @param valor El valor del nodo a eliminar.
     * @return true si el nodo fue eliminado, false en caso contrario.
     */
    public boolean eliminarNodoRetorno(int valor){
        NodoEnlazada actual = primero;  
        NodoEnlazada anterior = null;  
        boolean valorEliminado = false;
        while (actual != null && actual.getPosicion() != valor){ 
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (actual == null){ 
            return valorEliminado;
        } 
        if (anterior == null){  
            valorEliminado = true;
            this.setPrimero(actual.getSiguiente());
        }else{
            valorEliminado = true;
            anterior.setSiguiente(actual.getSiguiente());
        }
        return valorEliminado;
    }
        
    /**	 
     * Busca un valor en la lista.
     * @param valor El valor a buscar en la lista.
     * @return true si el valor se encuentra en la lista, false en caso contrario.
     */
    public boolean buscar (int valor){
        NodoEnlazada actual = primero;   
        while ( actual != null){  
            if (actual.getPosicion() == valor){
                return true;      
            }
            actual = actual.getSiguiente();
        }
        return false; 
    }  
  
    /**	 
     * Recorre la lista y muestra los valores de los nodos.
     */
    public void recorrer (){
        NodoEnlazada actual = primero;  
        while ( actual != null){ 
            System.out.print("Hora: " + actual.stringHora() + ", Posicion: " + actual.getPosicion() + ", Castigo/Premio: " +  actual.getCastigo() +  "\n");
            actual = actual.getSiguiente(); 
        }
    }
    
}
