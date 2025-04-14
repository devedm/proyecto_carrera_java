/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8.Librerias.Arbol;

import com.mycompany.proyectofinalgrupo8.Librerias.Lista.ListaArbol;

/**
 *
 * @author Eddy Mena Lopez
 */
public class NodoArbol {
    private String codigo;
    private String nombre;
    private ListaArbol listaPreguntas;
    private NodoArbol izquierda;
    private NodoArbol derecha;

    public NodoArbol(String codigo, String nombre, ListaArbol listaEnlazada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaPreguntas = listaEnlazada;
        this.izquierda = null;
        this.derecha = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaArbol getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(ListaArbol listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public NodoArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol derecha) {
        this.derecha = derecha;
    }

    @Override
    public String toString() {
        return "Codigo: " + getCodigo() + ", Nombre: " + getNombre() + ", Lista: " + getListaPreguntas().toString();
    }
    
    
}
