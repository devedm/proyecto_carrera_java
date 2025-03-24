/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author fernandafajardo
 */
public class EstadoJuego {
    
    /***
     * Imprime el estado actual del juego, mostrando las posiciones de los jugadores en el laberinto
     * @param colaJugadores La cola de jugadores en el juego, donde cada jugador tiene una posición.
     * @param laberinto La lista circular que representa el laberinto y contiene las posiciones.
     * @param estaJugando Indica si el juego está en curso (true) o no (false).
     */
    public static void imprimirEstadoJuego(ColaJugadores colaJugadores, ListaCircular laberinto, boolean estaJugando) {
        if (estaJugando) {
            System.out.println(" --------- Estado de juego --------- ");
            NodoCola actual = colaJugadores.getFrente();
            System.out.println(" - Jugador | Posicion - ");
            
            // Obtener el tamaño total del laberinto
            int totalPosiciones = laberinto.tamanioLaberinto();
            
            // Calcular los límites para cada sección (40%, 40%, 20%)
            int limiteVerde = (int) (totalPosiciones * 0.4);
            int limiteAmarillo = limiteVerde + (int) (totalPosiciones * 0.4);
            
            // Recorrer la cola de jugadores
            for (int i = 0; i < colaJugadores.tamanoCola(); i++) {
                int posicion = laberinto.buscarJugador(actual.getJugador());
                
                // Calcular el emoji de color según la posición
                String colorEmoji = "";
                if (posicion <= limiteVerde) {
                    colorEmoji = "🟩"; // Verde
                } else if (posicion <= limiteAmarillo) {
                    colorEmoji = "🟨"; // Amarillo
                } else {
                    colorEmoji = "🟥"; // Rojo
                }
                
                // Imprimir el jugador con el color de la posición
                System.out.println(colorEmoji + " Jugador: " + actual.getJugador().getNombre() + " | Posición: " + posicion);
                
                actual = actual.getSig();
            }
            
            // Imprimir las posiciones vacías
            NodoCircular actualLaberinto = laberinto.getPrimero();
            for (int i = 0; i < totalPosiciones; i++) {
                String color = "";
                if (i <= limiteVerde) {
                    color = "🟩"; // Verde
                } else if (i <= limiteAmarillo) {
                    color = "🟨"; // Amarillo
                } else {
                    color = "🟥"; // Rojo
                }

                // Verificar si la posición está vacía
                if (actualLaberinto.getNombreJugador() == null) {
                    // Si la posición está vacía, imprimir "VACÍA"
                    System.out.println(color + " Posición " + (i + 1) + ": VACÍA");
                } else {
                    // Si hay un jugador en la posición, imprimir el nombre del jugador
                    System.out.println(color + " Posición " + (i + 1) + ": " + actualLaberinto.getNombreJugador());
                }

                // Mover al siguiente nodo del laberinto
                actualLaberinto = actualLaberinto.getSiguiente();
            }
        } else {
            System.out.println("No hay una partida en curso.\n");
        }
    }
}
