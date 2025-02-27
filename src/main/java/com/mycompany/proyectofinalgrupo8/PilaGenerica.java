/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author fernandafajardo
 */
public class PilaGenerica {
    
    private NodoPila top;
    
    public PilaGenerica() {
        top = null;
    }

    public NodoPila getTop() {
        return top;
    }

    public void setTop(NodoPila top) {
        this.top = top;
    }
    
    /***
     * Agrega un nuevo nodo a la pila con la operación y el número especificados.
     * @param operacion Nombre o descripción de la operación asociada al nodo.
     * @param numero Valor numérico asociado al nodo.
     */
    public void push(String operacion, int numero){
        
        NodoPila miNodo = new NodoPila(operacion, numero);
        if(isEmpty()){
            top = miNodo;
        }else{
            miNodo.setSig(top);
            top = miNodo;
        }
    }
    
    /**
     * Elimina y devuelve el nodo del top de la pila.
     * @return El nodo eliminado de la pila. Retorna {@code null} si la pila está vacía.
     */
    public NodoPila pop(){
        if(isEmpty()){
            System.out.println("Error: la pila esta vacía, no puede desapilar");
            return null;
        }else{
            NodoPila aux = top;
            top = top.getSig();
            return aux;
        }
    }
    
    /**
     * Verifica si la pila esta vacía.
     * @return {@code true} si la pila no tiene elementos, {@code false} en caso contrario.
     */
    public boolean isEmpty(){
        
        if(top == null){
            return true;
        }else{
           return false;
        }
    }
}
