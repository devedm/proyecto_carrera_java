/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinalgrupo8;

import java.util.Scanner;

/**
 *
 * @author Eddy Mena Lopez
 */
public class ProyectoFinalGrupo8 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String opcionMenu = "";
        FlujoJuego flujoJ = new FlujoJuego();
        
        do {            
            System.out.println("1.Jugar\n2.Versión del juego\n3.Salir\nSeleccione la opcion deseada: ");
            opcionMenu = scanner.next();
            int numeroJugadores = 0;
            switch (opcionMenu) {
                case "1" -> {
                    do {                        
                        System.out.println("Ingrese el numero de jugadores: ");
                        numeroJugadores = scanner.nextInt();
                        scanner.nextLine();
                        if (numeroJugadores > 1 && numeroJugadores < 5){
                            flujoJ.setNumJugadores(numeroJugadores);
                            flujoJ.setJugadoresArray(new Jugador[numeroJugadores]);
                            // Solicitar la opción de agregar jugadores durante la partida.
                            System.out.print("Desea permitir agregar jugadores durante la partida? (si/no): ");
                            String permite = scanner.nextLine();
                            flujoJ.setPermiteAgregarJugadores(permite.equalsIgnoreCase("si"));
                            // Solicitar el nombre o alias para cada jugador.
                            for (int i = 0; i < numeroJugadores; i++) {
                                System.out.print("Ingrese el nombre o alias del jugador " + (i + 1) + ": ");
                                String nombreJugador = scanner.nextLine();
                                flujoJ.encolarJugador(new Jugador(nombreJugador, (i+1), 0));
                            }
                            
                        } else {
                            System.out.println("Error: Numero incorrecto de jugadores.");
//                            scanner.next();
                        }
                    } while (numeroJugadores <= 1 || numeroJugadores >= 5);
                    flujoJ.llenarPilasBonus();
                    flujoJ.juego();
                }
                case "2" -> {
                    Ayuda.mostrarAyuda();
                }
                case "3" -> {
                    System.out.println("Gracias por jugar\nSaliendo..");
                    opcionMenu = "3";
                }
                default -> System.out.println("Error intente de nuevo");
            }
            
        } while (opcionMenu != "3");
        
        scanner.close();
    }
}
