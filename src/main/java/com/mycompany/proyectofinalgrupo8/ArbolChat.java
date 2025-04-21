package com.mycompany.proyectofinalgrupo8;

import com.mycompany.proyectofinalgrupo8.Librerias.Arbol.ArbolBinario;
import com.mycompany.proyectofinalgrupo8.Librerias.Arbol.NodoArbol;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.ListaArbol;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.NodoListaArbol;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Eddy Mena Lopez
 * @author William Bastos
 * @author fernandafajardo
 */
public class ArbolChat extends ArbolBinario {

    /**
     * Inicializa y carga el árbol binario con preguntas frecuentes (FAQ) predeterminadas.
     * El árbol contiene preguntas y respuestas organizadas jerárquicamente.
     */
    public void preCargarArbol() {
        //Lista: Soy nuevo en videojuegos
        ListaArbol lista1111 = new ListaArbol();
        lista1111.insertaOrdenado(1, "¿Cuántos Jugadores pueden participar simultáneamente?", "Se tiene un máximo de 4 jugadores.");
        lista1111.insertaOrdenado(2, "¿Hay un tiempo máximo por partida?", "No, el juego termina cuando un jugador alcance la posición máxima.");

        //Lista: Ya he jugado otros juegos similares
        ListaArbol lista1112 = new ListaArbol();
        lista1112.insertaOrdenado(1, "¿Puedo jugar en línea?", "No, en la versión liberada no se permite jugar en línea.");
        lista1112.insertaOrdenado(2, "¿Si hay un ganador, los demás jugadores pueden continuar?", "Si, no hay restricción que les impida continuar.");

        //Lista: Jugador experimentado (preguntas asociadas directamente al nodo 112)
        ListaArbol lista112 = new ListaArbol();
        lista112.insertaOrdenado(1, "Hay una comunidad de jugadores para enriquecer el juego.", "No, pero es una excelente idea. Te invito a fundarla.");
        lista112.insertaOrdenado(2, "¿En qué lenguaje fue implementado?", "El juego fue implementado en JAVA.");
        lista112.insertaOrdenado(3, "¿Cuándo liberan una nueva versión?", "Esperamos liberar una nueva versión en noviembre de 2024.");

        //Lista: Administrador preguntas (nodo 1211)
        ListaArbol lista1211 = new ListaArbol();
        lista1211.insertaOrdenado(1, "¿Cómo puedo reiniciar una partida?", "Desde el menú principal, selecciona 'Reiniciar Partida'.");
        lista1211.insertaOrdenado(2, "¿Puedo ver estadísticas de todos los usuarios?", "Sí, desde el panel de administración.");

        //Lista: Mejorar juego (nodo 1212)
        ListaArbol lista1212 = new ListaArbol();
        lista1212.insertaOrdenado(1, "¿Dónde sugiero mejoras al juego?", "En la pestaña de 'Sugerencias' en el menú principal.");
        lista1212.insertaOrdenado(2, "¿Se pueden añadir más niveles?", "Estamos trabajando para agregar más niveles en futuras versiones.");

        //Creación del árbol
        // Nivel 1
        NodoArbol root = new NodoArbol("1", "Preguntas frecuentes (FAQ)", null);
        setRaiz(root);

        // Nivel 2
        NodoArbol node11 = new NodoArbol("1", "Preguntas para jugadores", null);
        NodoArbol node12 = new NodoArbol("1", "Preguntas para administradores", null);
        root.setIzquierda(node11);
        root.setDerecha(node12);

        // Nivel 3
        NodoArbol node111 = new NodoArbol("11", "Primera vez que juego", null);
        NodoArbol node112 = new NodoArbol("11", "Jugador experimentado", lista112); //Asignar aquí
        NodoArbol node121 = new NodoArbol("12", "Funcionalidades", null);
        node11.setIzquierda(node111);
        node11.setDerecha(node112);
        node12.setIzquierda(node121);

        // Nivel 4
        NodoArbol node1111 = new NodoArbol("111", "Soy un nuevo en video juegos", lista1111);
        NodoArbol node1112 = new NodoArbol("111", "Ya he jugado otros juegos similares", lista1112);
        NodoArbol node1211 = new NodoArbol("121", "Administrador preguntas", lista1211);
        NodoArbol node1212 = new NodoArbol("121", "Mejorar Juego", lista1212);
        node111.setIzquierda(node1111);
        node111.setDerecha(node1112);
        node121.setIzquierda(node1211);
        node121.setDerecha(node1212);
}


    /**
     * Inicia un chatbot en consola que guía al usuario a través de un árbol de preguntas frecuentes (FAQ).
     * El usuario puede navegar por categorías jerárquicas, seleccionar preguntas y visualizar respuestas.
     * Permite regresar a niveles anteriores o salir del sistema en cualquier momento.
     */
    public void iniciarChatBot() {
        Scanner scanner = new Scanner(System.in);
        NodoArbol actual = getRaiz();
        Stack<NodoArbol> historial = new Stack<>();

        System.out.println("Bienvenido al ChatBot de Preguntas Frecuentes (FAQ)");
        System.out.println("Puedes navegar por las categorías y ver respuestas. Escribe -1 para salir.");

        while (true) {
            System.out.println("\nEstás en: " + actual.getNombre());

            // Si es nodo hoja
            if (actual.getIzquierda() == null && actual.getDerecha() == null) {
                ListaArbol lista = actual.getListaPreguntas();

                if (lista == null || lista.getPrimero() == null) {
                    System.out.println("No hay preguntas disponibles en esta sección.");
                } else {
                    NodoListaArbol pregunta = lista.getPrimero();
                    System.out.println("Preguntas disponibles:");
                    while (pregunta != null) {
                        System.out.println("[" + pregunta.getCodigo() + "] " + pregunta.getPregunta());
                        pregunta = pregunta.getSiguiente();
                    }

                    System.out.print("Digite el código de la pregunta para ver la respuesta: ");
                    int codigo = scanner.nextInt();
                    pregunta = lista.getPrimero();
                    boolean encontrada = false;

                    while (pregunta != null) {
                        if (pregunta.getCodigo() == codigo) {
                            System.out.println("Respuesta: " + pregunta.getRespuesta());
                            encontrada = true;
                            break;
                        }
                        pregunta = pregunta.getSiguiente();
                    }

                    if (!encontrada) {
                        System.out.println("Pregunta no encontrada.");
                    }
                }

                System.out.println("\n0. Regresar\n-1. Salir");
                int opcion = scanner.nextInt();
                if (opcion == 0 && !historial.isEmpty()) {
                    actual = historial.pop();
                } else if (opcion == -1) {
                    System.out.println("Muchas gracias por usar el ChatBot... Hasta luego!");
                    return;
                }

            } else {
                // Nodo intermedio con opciones
                System.out.println("Seleccione una opción:");
                if (actual.getIzquierda() != null) {
                    System.out.println("1. " + actual.getIzquierda().getNombre());
                }
                if (actual.getDerecha() != null) {
                    System.out.println("2. " + actual.getDerecha().getNombre());
                }
                System.out.println("0. Regresar");
                System.out.println("-1. Salir");

                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        if (actual.getIzquierda() != null) {
                            historial.push(actual);
                            actual = actual.getIzquierda();
                        } else {
                            System.out.println("Opción no válida.");
                        }
                        break;
                    case 2:
                        if (actual.getDerecha() != null) {
                            historial.push(actual);
                            actual = actual.getDerecha();
                        } else {
                            System.out.println("Opción no válida.");
                        }
                        break;
                    case 0:
                        if (!historial.isEmpty()) {
                            actual = historial.pop();
                        } else {
                            System.out.println("Ya estás en el nivel más alto.");
                        }
                        break;
                    case -1:
                        System.out.println("Muchas gracias por usar el ChatBot... Hasta luego!");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            }
        }
    }


    /**
     * Inserta un nuevo nodo hijo debajo de un nodo padre especificado, o modifica un nodo existente si ya fue insertado.
     * @param codigoPadre Código del nodo padre al cual se desea agregar un nuevo hijo. Si es null o vacío, se intenta crear la raíz.
     * @param nombre Nombre o descripción que tendrá el nuevo nodo o el nodo a modificar.
     */
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

    /**
     * Genera un nuevo código para un nodo hijo basado en el código del nodo padre.
     * @param codigoPadre Código del nodo padre del cual se desea generar un nuevo hijo.
     * @return Un nuevo código único para el nodo hijo.
     */
    private String generarCodigoHijo(String codigoPadre) {
        int maxConsecutivo = obtenerMaxConsecutivo(codigoPadre);
        return codigoPadre + (maxConsecutivo + 1);
    }

    /**
     * Obtiene el valor numérico más alto usado como sufijo en los códigos de los nodos que inician con el prefijo dado.
     * @param prefijo Parte inicial del código (generalmente el código del nodo padre).
     * @return El valor numérico más alto encontrado como sufijo en los códigos hijos.
     */
    private int obtenerMaxConsecutivo(String prefijo) {
        return obtenerMaxRecursivo(getRaiz(), prefijo, 0);
    }

    /**
     * Recorre el árbol en forma recursiva para encontrar el mayor sufijo numérico entre los nodos cuyo código comienza con el prefijo dado.
     * @param actual Nodo actual que se está evaluando.
     * @param prefijo Prefijo del código padre para identificar los nodos hijos.
     * @param max Valor máximo encontrado hasta el momento.
     * @return El sufijo numérico más alto encontrado en los nodos hijos.
     */
    private int obtenerMaxRecursivo(NodoArbol actual, String prefijo, int max) {
        if (actual == null) {
            return max;
        }

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
    
    /**
     * Lista todas las preguntas y sus respectivas respuestas registradas en un nodo hoja específico del árbol.
     * Este método solo permite listar preguntas si el nodo indicado es una hoja (sin hijos).
     * @param codigoNodo Código del nodo hoja del cual se desean listar las preguntas.
     */
    public void listarPreguntasPorNodo(String codigoNodo) {
        NodoArbol nodo = buscarNodo(getRaiz(), codigoNodo);

        if (nodo == null) {
            System.out.println("No se encontró ningún nodo con el código: " + codigoNodo);
            return;
        }

        if (nodo.getIzquierda() != null || nodo.getDerecha() != null) {
            System.out.println("El nodo con código " + codigoNodo + " no es una hoja. Solo los nodos hoja tienen preguntas.");
            return;
        }

        ListaArbol lista = nodo.getListaPreguntas();
        NodoListaArbol actual = lista.getPrimero();

        if (actual == null) {
            System.out.println("No hay preguntas registradas en este nodo.");
            return;
        }

        System.out.println("Preguntas del nodo " + codigoNodo + " (" + nodo.getNombre() + "):");
        while (actual != null) {
            System.out.println("[" + actual.getCodigo() + "] " + actual.getPregunta() + " → " + actual.getRespuesta());
            actual = actual.getSiguiente();
        }
    }
}
