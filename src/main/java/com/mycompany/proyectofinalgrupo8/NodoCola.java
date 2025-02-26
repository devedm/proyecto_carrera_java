/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author fernandafajardo
 */
public class NodoCola {
    
    private String nombre;
    private NodoCola sig;

    public NodoCola() {
    }

    public NodoCola(String nombre) {
        this.nombre = nombre;
        this.sig = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoCola getSig() {
        return sig;
    }

    public void setSig(NodoCola sig) {
        this.sig = sig;
    }
}
