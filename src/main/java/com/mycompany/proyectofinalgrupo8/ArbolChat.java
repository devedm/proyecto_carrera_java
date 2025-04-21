/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

import com.mycompany.proyectofinalgrupo8.Librerias.Arbol.ArbolBinario;
import com.mycompany.proyectofinalgrupo8.Librerias.Arbol.NodoArbol;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.ListaArbol;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.NodoListaArbol;

import java.util.Scanner;

/**
 *
 * @author minio
 */
public class ArbolChat extends ArbolBinario{
    public void pregargarArbol() {
        // Lista Preguntas
        // Lista Soy nuevo en videojuegos
        ListaArbol lista1111 = new ListaArbol();
        lista1111.insertaOrdenado(1, "¿Cuántos Jugadores pueden participar simultáneamente?", "Se tiene un máximo de 4 jugadores.");
        lista1111.insertaOrdenado(2, "¿Hay un tiempo máximo por partida?", "No, el juego termina cuando un jugador alcance la posición máxima.");
        // nivel 1
        NodoArbol root = new NodoArbol("1", "Preguntas frecuentes (FAQ)", null);
        setRaiz(root);
        // nivel 2
        NodoArbol node11 = new NodoArbol("11", "Preguntas para jugadores", null);
        NodoArbol node12 = new NodoArbol("12", "Preguntas para administradores", null);
        root.setIzquierda(node11);
        root.setDerecha(node12);
        // nivel 3
        NodoArbol node111 = new NodoArbol("111", "Primera vez que juego", null);
        NodoArbol node112 = new NodoArbol("112", "Jugador experimentado", null);
        NodoArbol node121 = new NodoArbol("121", "Preguntas para Administradores", null);
        node11.setIzquierda(node111);
        node11.setDerecha(node112);
        node12.setIzquierda(node121);
        // nivel 4      
        NodoArbol node1111 = new NodoArbol("1111", "Soy un nuevo en video juegos", lista1111);
        NodoArbol node1112 = new NodoArbol("1112", "Ya he jugado otros juegos similares", null);
        NodoArbol node1211 = new NodoArbol("1211", "Administrador preguntas", null);
        NodoArbol node1212 = new NodoArbol("1212", "Mejorar Juego", null);
        node111.setIzquierda(node1111);
        node111.setDerecha(node1112);
        node121.setIzquierda(node1211);
        node121.setDerecha(node1212);
    }

    public void iniciarChatBot() {
        Scanner scanner = new Scanner(System.in);
        NodoArbol actual = getRaiz();
        NodoArbol anterior = null;
        System.out.println("¡Bienvenido al ChatBot de preguntas frecuentes!");

        while (true) {
            if (actual == null) {
                System.out.println("No pudimos encontrar tu pregunta en este nivel.");
                break;
            }
            if (actual.getListaPreguntas() != null) {
                System.out.println("Preguntas disponibles:");
                actual.getListaPreguntas().recorrer();
            } else {
                System.out.println("No hay preguntas disponibles en este nivel.");
            }
            System.out.println("\nNivel actual: " + actual.getNombre());
            if (actual.getListaPreguntas() != null) {
                System.out.println("Preguntas disponibles:");
                actual.getListaPreguntas().recorrer();

                System.out.println("\nSelecciona el código de la pregunta para ver la respuesta, escribe '0' para regresar o '-1' para salir:");
                int opcion = scanner.nextInt();

                if (opcion == -1) {
                    break;
                } else if (opcion == 0) {
                    actual = anterior;
                } else {
                    NodoListaArbol pregunta = buscarPregunta(actual.getListaPreguntas(), opcion);
                    if (pregunta != null) {
                        System.out.println("Respuesta: " + pregunta.getRespuesta());
                    } else {
                        System.out.println("Código de pregunta no válido.");
                    }
                }
            } else {
                System.out.println("Opciones disponibles:");
                if (actual.getIzquierda() != null) {
                    System.out.println("1. " + actual.getIzquierda().getNombre());
                }
                if (actual.getDerecha() != null) {
                    System.out.println("2. " + actual.getDerecha().getNombre());
                }
                System.out.println("0. Regresar");
                System.out.println("-1. Salir");

                int opcion = scanner.nextInt();
                anterior = actual;

                switch (opcion) {
                    case 1:
                        actual = actual.getIzquierda();
                        break;
                    case 2:
                        actual = actual.getDerecha();
                        break;
                    case 0:
                        actual = anterior;
                        break;
                    case -1:
                        System.out.println("Gracias por usar el ChatBot. ¡Hasta luego!");
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }

        System.out.println("Gracias por usar el ChatBot. ¡Hasta luego!");
    }

    private NodoListaArbol buscarPregunta(ListaArbol lista, int codigo) {
        NodoListaArbol actual = lista.getPrimero();
        while (actual != null) {
            if (actual.getCodigo() == codigo) {
                return actual;
            }else{
                actual = actual.getSiguiente();
            }
        }
        return null;
    }

    private void validarArbol(NodoArbol nodo) {
        if (nodo == null) {
            System.out.println("El árbol está vacío.");
            return;
        } else if (nodo.getListaPreguntas() == null) {
            nodo.setListaPreguntas(new ListaArbol());
        }
        validarArbol(nodo.getIzquierda());
        validarArbol(nodo.getDerecha());
    }


    public static void main(String[] args) {
        ArbolChat chat = new ArbolChat();

        chat.pregargarArbol();
        System.out.println(chat.getRaiz() != null);
        chat.iniciarChatBot();
    }
}

