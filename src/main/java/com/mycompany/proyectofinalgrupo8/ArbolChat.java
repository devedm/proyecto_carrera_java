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
    public void pregargarArbol(){
        // Lista Preguntas
        // Lista Soy nuevo en videojuegos
        ListaArbol lista1111 = new ListaArbol();
        lista1111.insertaOrdenado(1, "¿Cuántos Jugadores pueden participar simultáneamente?", "Se tiene un máximo de 4 jugadores.");
        lista1111.insertaOrdenado(2, "¿Hay un tiempo máximo por partida?", "No, el juego termina cuando un jugador alcance la posición máxima.");
        
        ListaArbol lista1112 = new ListaArbol();
        lista1112.insertaOrdenado(1, "¿Puedo jugar en línea?", "No, en la versión liberada no se permite jugar en línea.");
        lista1112.insertaOrdenado(2, "¿Si hay un ganador, los demás jugadores pueden continuar?", "Si, no hay restricción que les impida continuar.");
        
        ListaArbol lista112 = new ListaArbol();
        lista112.insertaOrdenado(1, "Hay una comunidad de jugadores para enriquecer el juego.", "No, pero es una excelente idea. Te invito a fundarla.");
        lista112.insertaOrdenado(2, "En que lenguaje fue implementado", "El juego fue implementado en JAVA.");
        lista112.insertaOrdenado(3, "¿Cuándo liberan una nueva versión?", "Esperamos liberar una nueva versión en noviembre de 2024.");
        
        // nivel 1
        insertar("1", "Preguntas Frecuentes (FAQ)", null);
        // nivel 2
        insertar("1", "Preguntas para jugadores", null);
        insertar("1", "Preguntas para Administradores", null);
        // nivel 3
        insertar("11", "Primera vez que juego", null);
        insertar("11", "Jugador Experimentado", lista112);
        insertar("12", "Preguntas para Administradores", null);
        // nivel 4      
        insertar("111", "Soy nuevo en videojuegos", lista1111);
        insertar("111", "Ya he jugado otros juegos similares", lista1112);
        insertar("121", "Administrador preguntas", null);
        insertar("121", "Mejorar Juego", null);
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
//            actual.getListaPreguntas().recorrer();
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
        
    public void insertarOModificarPreguntaPadre(String codigoPadre, String nombre) {
        if (codigoPadre == null || codigoPadre.isEmpty()) {
            if (getRaiz() == null) {
                insertar("1", nombre, null);
                System.out.println("Nodo raíz insertado con código 1.");
            } else {
                System.out.println("Ya existe una raíz. Debe especificar un código padre para agregar más nodos.");
            }
            return;
        }

        NodoArbol padre = buscarNodo(getRaiz(), codigoPadre);
        if (padre == null) {
            System.out.println("Error: No se encontró el nodo padre con código " + codigoPadre);
            return;
        }

        String nuevoCodigo = generarCodigoHijo(codigoPadre);
        NodoArbol existente = buscarNodo(getRaiz(), nuevoCodigo);

        if (existente != null) {
            existente.setNombre(nombre);
            System.out.println("Nodo existente modificado: " + nuevoCodigo);
        } else {
            insertar(nuevoCodigo, nombre, null); // Método heredado
            System.out.println("Nuevo nodo insertado con código: " + nuevoCodigo);
        }
    }

    private String generarCodigoHijo(String codigoPadre) {
        int maxConsecutivo = obtenerMaxConsecutivo(codigoPadre);
        return codigoPadre + (maxConsecutivo + 1);
    }

    private int obtenerMaxConsecutivo(String prefijo) {
        return obtenerMaxRecursivo(getRaiz(), prefijo, 0);
    }

    private int obtenerMaxRecursivo(NodoArbol actual, String prefijo, int max) {
        if (actual == null) return max;

        if (actual.getCodigo().startsWith(prefijo) && actual.getCodigo().length() > prefijo.length()) {
            try {
                int subCodigo = Integer.parseInt(actual.getCodigo().substring(prefijo.length()));
                max = Math.max(max, subCodigo);
            } catch (NumberFormatException e) {
                // Ignorar si el sufijo no es numérico
            }
        }

        max = obtenerMaxRecursivo(actual.getIzquierda(), prefijo, max);
        max = obtenerMaxRecursivo(actual.getDerecha(), prefijo, max);
        return max;
    }

    public static void main(String[] args) {
        ArbolChat chat = new ArbolChat();

        chat.pregargarArbol();
        chat.iniciarChatBot();
    }
}

