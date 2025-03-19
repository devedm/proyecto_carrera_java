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
        String opcionMenu;
        int numeroJugadores = 0;
        FlujoJuego flujoJ = new FlujoJuego();
        flujoJ.llenarPilasBonus();
        flujoJ.informacionPilasBonus();
        do {            
            System.out.println("1.Jugar" +
                    "\n2.Versión del juego" +
                    "\n3.Salir" +
                    "\n4.Mantener pila" +
                    "\n5.Adicionar jugador" +
                    "\n6.Estado de juego" +
                    "\n7.Bitácora-Historial" +
                    "\nSeleccione la opcion deseada: ");
            opcionMenu = scanner.next();
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
                        }
                    } while (numeroJugadores <= 1 || numeroJugadores >= 5);
                    flujoJ.llenarPilasBonus();
                    flujoJ.juego();
                }
                case "2" -> {
                    Ayuda.incrementarVersion();
                    Ayuda.mostrarAyuda();
                }
                case "3" -> {
                    System.out.println("Gracias por jugar\nSaliendo..");
                    opcionMenu = "3";
                }
                case "4" -> {
                    System.out.println("Haz entrado a mantenimiento de pilas. Seleccione:" +
                            "\n1. Informacion de las pilas premio y castigo" +
                            "\n2. Llenar castigos" +
                            "\n3. Llenar premios" +
                            "\n4. Llenar ambos");
                    int opcionPilas = scanner.nextInt();
                    switch (opcionPilas){
                        case 1 -> {
                            System.out.println("Informacion pilas: ");
                            flujoJ.informacionPilasBonus();
                            System.out.println("Presione ENTER para continuar");
                            scanner.next();
                        }
                        case 2 -> {
                            flujoJ.llenarPilasCastigo();
                            System.out.println("Presione ENTER para continuar");
                            scanner.next();
                        }
                        case 3 -> {
                            flujoJ.llenarPilasPremios();
                            System.out.println("Presione ENTER para continuar");
                            scanner.next();
                        }
                        case 4 -> {
                            flujoJ.llenarPilasBonus();
                            System.out.println("Presione ENTER para continuar");
                            scanner.next();
                        }
                    }
                }
                case "5" -> {
                    System.out.println();
                    String nuevoJugador = scanner.nextLine();
                    flujoJ.agregarJugadorAdicional(new Jugador(nuevoJugador,  numeroJugadores++, 0));
                }
                case "6" -> {
                    System.out.println("Estado de juego");
                }
                case "7" -> {
                    System.out.println("Bitacora-Historial");
                }
                default -> System.out.println("Error intente de nuevo");
            }
            
        } while (opcionMenu != "Q");
        
        scanner.close();
    }
}
