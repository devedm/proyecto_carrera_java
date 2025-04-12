/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

import com.mycompany.proyectofinalgrupo8.Librerias.Arbol.ArbolBinario;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.ListaArbol;

/**
 *
 * @author minio
 */
public class ArbolChat extends ArbolBinario{
    public void pregargarArbol(){
        // Lista Preguntas
        // Lista Soy nuevo en videojuegos
        ListaArbol lista1111 = new ListaArbol();
        lista1111.insertaOrdenado(1, "¿Cuántos Jugadores pueden participar simultáneamente?", "Se tiene un máximo de 4 jugadores.");
        lista1111.insertaOrdenado(2, "¿Hay un tiempo máximo por partida?", "No, el juego termina cuando un jugador alcance la posición máxima.");
        
        // nivel 1
        insertar("1", "Preguntas Frecuentes (FAQ)", null);
        // nivel 2
        insertar("11", "Preguntas para jugadores", null);
        insertar("12", "Preguntas para Administradores", null);
        // nivel 3
        insertar("111", "Primera vez que juego", null);
        insertar("112", "Jugador Experimentado", null);
        insertar("121", "Preguntas para Administradores", null);
        // nivel 4      
        insertar("1111", "Soy nuevo en videojuegos", lista1111);
        insertar("1112", "Ya he jugado otros juegos similares", null);
        insertar("1211", "Administrador preguntas", null);
        insertar("1212", "Mejorar Juego", null);
        
        
    }
}
