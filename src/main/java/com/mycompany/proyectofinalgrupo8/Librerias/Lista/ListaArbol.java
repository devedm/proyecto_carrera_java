/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8.Librerias.Lista;

/**
 *
 * @author Eddy Mena Lopez
 */
public class ListaArbol {
     
    private NodoListaArbol primero;


    public ListaArbol() {
    }

    public NodoListaArbol getPrimero() {
        return primero;
    }

    public void setPrimero(NodoListaArbol primero) {
        this.primero = primero;
    }
    
    public void insertaOrdenado(int codigo, String pregunta, String respuesta){
        NodoListaArbol nuevo = new NodoListaArbol(codigo, pregunta, respuesta);   
        if (this.getPrimero() == null){     
            this.setPrimero(nuevo);    
        }else if (this.getPrimero().getCodigo() > codigo) { 
            nuevo.setSiguiente(primero);    
            this.setPrimero(nuevo);           
        } else {      
            NodoListaArbol aux = this.getPrimero(); 
            while (aux.getSiguiente()!= null &&
                   aux.getSiguiente().getCodigo() <= codigo){
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);  
        }
    }
    

    public void eliminarNodo(int codigo){
        NodoListaArbol actual = primero;  
        NodoListaArbol anterior = null; 

        while (actual != null && actual.getCodigo()!= codigo){                                                                  
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

    public boolean eliminarNodoRetorno(int codigo){
        NodoListaArbol actual = primero;  
        NodoListaArbol anterior = null;  
        boolean valorEliminado = false;
        while (actual != null && actual.getCodigo() != codigo){ 
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

    public boolean buscar (int codigo){
        NodoListaArbol actual = primero;   
        while ( actual != null){  
            if (actual.getCodigo() == codigo){
                return true;      
            }
            actual = actual.getSiguiente();
        }
        return false; 
    }  
  
    public void recorrer (){
        NodoListaArbol actual = primero;  
        while ( actual != null){ 
            System.out.print("Codigo: " + actual.getCodigo()+ ", Pregunta: " + actual.getPregunta()+ ", Respuesta: " +  actual.getRespuesta()+  "\n");
            actual = actual.getSiguiente(); 
        }
    }
}
