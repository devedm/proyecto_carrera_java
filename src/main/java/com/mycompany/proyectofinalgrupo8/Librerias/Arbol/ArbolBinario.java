/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8.Librerias.Arbol;

import com.mycompany.proyectofinalgrupo8.Librerias.Lista.ListaArbol;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.NodoListaArbol;

/**
 *
 * @author minio
 */
public class ArbolBinario {
        private NodoArbol raiz;

    public ArbolBinario() {
         raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }
    
    
    // Método wrapper.
    public void insertar (String codigoPadre, String nombre, ListaArbol listaArbol){
        if (raiz == null) {
        // Si el árbol está vacío, la raíz se asigna con código "1"
        raiz = new NodoArbol("1", nombre, listaArbol);
        return;
        }
        
        NodoArbol padre = buscarNodo(raiz, codigoPadre);
        if (padre == null) {
            System.out.println("Padre no encontrado");
            return;
        }

        // Verificar si ya hay hijo izquierdo
        if (padre.getIzquierda() == null) {
            String nuevoCodigo = padre.getCodigo() + "1";
            padre.setIzquierda(new NodoArbol(nuevoCodigo, nombre, listaArbol));
        } else if (padre.getDerecha() == null) {
            String nuevoCodigo = padre.getCodigo() + "2";
            padre.setDerecha(new NodoArbol(nuevoCodigo, nombre, listaArbol));
        } else {
            System.out.println("El nodo padre ya tiene dos hijos.");
        }
    }
    
    // Método recursivo
    NodoArbol insertarRec(NodoArbol nodoActual, String codigo, String nombre, ListaArbol listaArbol){
        // Caso 1: El nodo actual está vacío
        if (nodoActual == null){        // Condición de parada.
            return new NodoArbol(codigo, nombre, listaArbol);
        }
        else{
            // Caso 2: Que el nodo a insertar sea menor a la rama actual
            if (Integer.parseInt(codigo) < Integer.parseInt(nodoActual.getCodigo())){
                nodoActual.setIzquierda(insertarRec(nodoActual.getIzquierda(), codigo, nombre, listaArbol));
            }else if (Integer.parseInt(codigo) > Integer.parseInt(nodoActual.getCodigo())) {
                nodoActual.setDerecha(insertarRec(nodoActual.getDerecha(), codigo, nombre, listaArbol));
            }
        }
        return nodoActual;
    }
    
    // Recorridos de árboles
    public void inOrden(){
        inOrdenRec(raiz);
    }
    
    // Método recursivo que recorre el árbol en inorden
    private void inOrdenRec(NodoArbol actual){
        if (actual != null){
            inOrdenRec(actual.getIzquierda()); // Vuelva a entrar recursivamente, pero evaluando el hijo izq.
            System.out.print(actual.toString());
            inOrdenRec(actual.getDerecha()); // Vuelva a entrar recursivamente, pero evaluando el hijo der.
        }
    }

    public void preOrden(){
        preOrdenRec(raiz);
    }


    // Método recursivo que recorre el árbol en preorden
    private void preOrdenRec(NodoArbol actual){
        if (actual != null){
            System.out.println(actual.toString());
            preOrdenRec(actual.getIzquierda()); // Vuelva a entrar recursivamente, pero evaluando el hijo izq.
            preOrdenRec(actual.getDerecha()); // Vuelva a entrar recursivamente, pero evaluando el hijo der.
        }
    }

    public void postOrden(){
        postOrdenRec(raiz);
    }


    // Método recursivo que recorre el árbol en postorden
    private void postOrdenRec(NodoArbol actual){
        if (actual != null){
            postOrdenRec(actual.getIzquierda()); // Vuelva a entrar recursivamente, pero evaluando el hijo izq.
            postOrdenRec(actual.getDerecha()); // Vuelva a entrar recursivamente, pero evaluando el hijo der.
            System.out.println(actual.toString());
        }
    }
    
    // Método envoltura que invoca el métodos recursivo.
    public void eliminar (String codigo){
        raiz = eliminarRec(raiz, codigo);
    }
    
    private NodoArbol eliminarRec (NodoArbol actual, String codigo){
        // Condición de parada
        if (actual == null) return actual;
        
        //Buscar el nodo a la izquierda o a la derecha.
        if (Integer.parseInt(codigo) < Integer.parseInt(actual.getCodigo())){  // Vamos a busarlo en la izquierda del arbol
            actual.setIzquierda(eliminarRec(actual.getIzquierda(),codigo));
        }else if (Integer.parseInt(codigo) > Integer.parseInt(actual.getCodigo())){    // Vamos a buscarlo a la derecha del arbol.
            actual.setDerecha(eliminarRec(actual.getDerecha(),codigo));
        }else{      // YA lo encontré. Es igual.
            // Caso 1: Nodo sin hijos. (Hoja)
            if (actual.getIzquierda() == null && actual.getDerecha() == null){
                return null;   // Elimina la hoja y la sustituye por un null.
            }
            // Caso 2: Nodo con un hijo
            if (actual.getIzquierda() == null)
                return actual.getDerecha();
            else if (actual.getDerecha() == null)
                return actual.getIzquierda();
            
            // Caso 3: Nodo con 2 hijos.
            NodoArbol sucesor = minValorSucedor(actual.getDerecha()); // Nos devuelve el sucedor del # que queremos eliminar.
            actual.setCodigo(sucesor.getCodigo()); 
            actual.setNombre(sucesor.getNombre()); 
            actual.setListaPreguntas(sucesor.getListaPreguntas()); 
            actual.setDerecha(eliminarRec(actual.getDerecha(), sucesor.getCodigo())); 
        }
        return actual;
    }
    
    private NodoArbol minValorSucedor(NodoArbol nodo){
        while (nodo.getIzquierda() != null){
            nodo = nodo.getDerecha();
        }
        return nodo;
    
    }
    
    public int obtenerNivel(String valor, int nivel){
        return obtenerNivelRec(raiz, valor,nivel);
    }
    
    public int obtenerNivelRec(NodoArbol actual, String codigo, int nivel){
        if (actual == null) return -1;
        if (Integer.parseInt(actual.getCodigo()) == Integer.parseInt(codigo)) return nivel;    // Si encuentro el codigo, retorno su nivel
        int nivelIzq = obtenerNivelRec(actual.getIzquierda(), codigo, nivel+1);
        if (nivelIzq != -1) return nivelIzq;    // Significa que encontré el codigo que ando buscando.
        return obtenerNivelRec(actual.getDerecha(),codigo, nivel+1);
    }
    
    public int obtenerAltura(NodoArbol actual){
        if (actual == null) return -1;
        int alturaIzq = obtenerAltura(actual.getIzquierda());
        int alturaDer = obtenerAltura(actual.getDerecha());
        int alturaMayor = Math.max(alturaIzq, alturaDer) + 1;   // Compara cual de las 2 ramas es mas larga.
        return alturaMayor;
    }
    
    //Preguntas hijas
    public void insertaroModificarPregHija(String codigoNodo, int codigoPregunta, String pregunta, String respuesta){
        NodoArbol nodo = buscarNodo(raiz, codigoNodo);
        
        if(nodo == null){
            System.out.println("Nodo no encontrado");
            return;
        }
        
        if(nodo.getIzquierda() != null || nodo.getDerecha() != null){
            System.out.println("Error: El nodo no es hoja. Solo los nodos hoja pueden tener preguntas.");
            return;
        }
        
        NodoListaArbol actual = nodo.getListaPreguntas().getPrimero();
        boolean modificada = false;
        
        while(actual != null){
            if(actual.getCodigo() == codigoPregunta){
                actual.setPregunta(pregunta);
                actual.setRespuesta(respuesta);
                modificada = true;
                break;
            }
            actual = actual.getSiguiente();
        }
        
        if(!modificada){
            nodo.getListaPreguntas().insertaOrdenado(codigoPregunta, pregunta, respuesta);
            System.out.println("Pregunta insertada correctamente");
        }else{
            System.out.println("Pregunta modificada correcamente");
        }
    }
    
    public NodoArbol buscarNodo(NodoArbol actual, String codigo){
//        if(actual == null) return null;
//        if(actual.getCodigo().equals(codigo)) return actual;
//        
//        NodoArbol izquierda = buscarNodo(actual.getIzquierda(), codigo);
//        return buscarNodo(actual.getDerecha(), codigo);

        if (actual == null) return null;
        if (actual.getCodigo().equals(codigo)) return actual;

        NodoArbol izquierda = buscarNodo(actual.getIzquierda(), codigo);
        if (izquierda != null) return izquierda;

        return buscarNodo(actual.getDerecha(), codigo);
    }
}
