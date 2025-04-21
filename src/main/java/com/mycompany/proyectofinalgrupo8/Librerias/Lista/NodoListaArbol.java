/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8.Librerias.Lista;

/**
 *
 * @author Eddy Mena Lopez
 */
public class NodoListaArbol {
    private int codigo;
    private String pregunta;
    private String respuesta;
    private NodoListaArbol siguiente;


    public NodoListaArbol(int codigo, String pregunta, String respuesta) {
        this.codigo = codigo;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.siguiente = siguiente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public NodoListaArbol getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaArbol siguiente) {
        this.siguiente = siguiente;
    }



}
