/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author minio
 */
public class NodoEnlazada {
    private int posicion;
    private LocalDateTime hora;
    private String castigo;
    private NodoEnlazada siguiente;

    /**	 
     * Constructor de la clase Nodo.
     * @param dato El valor que se almacenará en el nodo.
     */
    public NodoEnlazada(int dato, LocalDateTime hora, String castigo) {
        this.posicion = dato;
        this.hora = hora;
        this.castigo = castigo;
        this.siguiente = siguiente;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public LocalDateTime getHora() {
        return hora;
    }
    
    public String stringHora() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatoFecha);
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public String getCastigo() {
        return castigo;
    }

    public void setCastigo(String castigo) {
        this.castigo = castigo;
    }

    public NodoEnlazada getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEnlazada siguiente) {
        this.siguiente = siguiente;
    }

    
}
