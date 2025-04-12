/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinalgrupo8;

import com.mycompany.proyectofinalgrupo8.Librerias.Cola.NodoCola;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.ListaCircular;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.NodoDoble;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.ListaDobleC;
import java.util.Scanner;

/**
 *
 * @author Eddy Mena Lopez
 */
public class ProyectoFinalGrupo8 {

    public static void main(String[] args) throws Exception {
        
        // Variables
        boolean estaJugando = false;
        boolean permiteAgregarJugadores = true;
        String opcionMenu = "0";
        boolean hayGanador = false;
        
        // Constantes
        int MAXIMOJUGADORES = 4;
        
        
        // Inicializaciones
        Scanner scanner = new Scanner(System.in); // Objeto scanner para pedir input a los jugadores
        
        PilaCastigos pilaCastigos = new PilaCastigos();
        PilaPremios pilaPremios = new PilaPremios();
        ColaJugadores colaJugadores = new ColaJugadores();
        ListaCircular laberinto = new ListaCircular();
        ListaDobleC bitacora = new ListaDobleC();
                
        // Menu principal         
        do {            
            System.out.println("1.Jugar" +
                    "\n2.Agregar jugador" +
                    "\n3.Estado de juego" +
                    "\n4.Bitácora-Historial" +
                    "\n5.Mantener pila" +
                    "\n6.Versión del juego" +
                    "\n7.Salir" +
                    "\nSeleccione la opcion deseada: ");
            opcionMenu = scanner.next();
            switch (opcionMenu) {
                case "1" -> {
                    if(!estaJugando && !hayGanador){ // primera partida se preguntan detalles de la partida
                        if(colaJugadores.esVacia()){
                            System.out.println("No se puede iniciar el juego sin Jugadores\n");
                            break;
                        }
                        // Preguntar tamanio laberinto
                        System.out.print("Ingrese el tamanio del laberinto?: ");
                        String tamanio = scanner.next();
                        laberinto = new ListaCircular();
                        laberinto.crearLaberinto(Integer.valueOf(tamanio));
                        System.out.println("Se van a insertar estos jugadores: ");
                        colaJugadores.mostrarJugadores();
                        NodoCola actual = colaJugadores.getFrente();
                        for (int i = 0; i < colaJugadores.tamanoCola(); i++) {
                            laberinto.insertarJugador(actual.getJugador());
                            NodoDoble nodoJugador = bitacora.buscarJugador(actual.getJugador());
                            if(nodoJugador != null){
                                nodoJugador.getHistorial().insertaOrdenado(0, "Posicion 0 no tiene castigos/premios");
                                System.out.println("Se ha creado entrada en la bitacora");
                            } else {
                                System.out.println("- NO se ha creado entrada en la bitacora");
                            }
                            actual = actual.getSig();
                        }
                        System.out.println("Jugadores insertados " + laberinto.getPrimero().getNombreJugador());
                        
                        // Rellenar Castigos y Premios
                        pilaCastigos.agregarCastigosAleatorios(Integer.valueOf(tamanio));
                        pilaPremios.agregarPremiosAleatorios(Integer.valueOf(tamanio));
                        
                        // Preguntar agregar mas jugadores durante la partida
                        System.out.print("Desea permitir agregar jugadores durante la partida? (si/no): ");
                        String permite = scanner.next();
                        if(permite.toLowerCase().contentEquals("si")){
                            permiteAgregarJugadores = true;
                            System.out.println("Se permitira agregar jugadores durante la partida");
                        } else if (permite.toLowerCase().contentEquals("no")){
                            permiteAgregarJugadores = false;
                            System.out.println("No se permitira agregar jugadores durante la partida");
                        } else {
                            System.out.println("Error: opcion incorrecta... volviendo al menu");
                            break;
                        }
                        estaJugando = true;
                    }
                    if(estaJugando && !colaJugadores.esVacia() && !hayGanador){
                        Jugar jugar = new Jugar(colaJugadores, pilaPremios, pilaCastigos, laberinto, bitacora);
                        if (jugar.turno()){
                            // si gano termina el juego
                            // limpiar pilas y colas
                            hayGanador = true;
                        }
                        
                    } else {
                        System.out.println("El juego se ha acabado ya hay un ganador");
                    }

//                    do {                        
//                        System.out.println("Ingrese el numero de jugadores: ");
//                        numeroJugadores = scanner.nextInt();
//                        scanner.nextLine();
//                        if (numeroJugadores > 1 && numeroJugadores < 5){
//                            flujoJ.setNumJugadores(numeroJugadores);
//                            flujoJ.setJugadoresArray(new Jugador[numeroJugadores]);
//                            // Solicitar la opción de agregar jugadores durante la partida.
//                            System.out.print("Desea permitir agregar jugadores durante la partida? (si/no): ");
//                            String permite = scanner.nextLine();
//                            flujoJ.setPermiteAgregarJugadores(permite.equalsIgnoreCase("si"));
//                            // Solicitar el nombre o alias para cada jugador.
//                            for (int i = 0; i < numeroJugadores; i++) {
//                                System.out.print("Ingrese el nombre o alias del jugador " + (i + 1) + ": ");
//                                String nombreJugador = scanner.nextLine();
//                                flujoJ.encolarJugador(new Jugador(nombreJugador, (i+1), 0));
//                            }
//                            
//                        } else {
//                            System.out.println("Error: Numero incorrecto de jugadores.");
//                        }
//                    } while (numeroJugadores <= 1 || numeroJugadores >= 5);
//                    flujoJ.llenarPilasBonus();
//                    flujoJ.juego();
                }
                case "2" -> {
                    if(permiteAgregarJugadores){
                        Jugador jugadorObjeto;
                        if(colaJugadores.tamanoCola() <= MAXIMOJUGADORES){
                            System.out.println("Ingrese el nombre del Jugador");
                            String nuevoJugador = scanner.next();
                            int numeroJugador = colaJugadores.tamanoCola() + 1;
                            jugadorObjeto = new Jugador(nuevoJugador,numeroJugador);
                            colaJugadores.encolar(jugadorObjeto, true);
                            bitacora.insertarJugador(jugadorObjeto);
                            if(estaJugando){
                                // agregar al laberinto
                                laberinto.insertarJugador(jugadorObjeto);
                                bitacora.buscarJugador(jugadorObjeto).getHistorial().insertaOrdenado(0, "Posicion 0 no tiene castigos/premios");
                                System.out.println("Se ha creado entrada en la bitacora");
                            } 
                        } 
                    } else {
                        System.out.println("No se puede añadir jugador a la partida.\n");
                    }
                }
                case "3" -> {
                    if (estaJugando) {
                        // Llamamos al método de la clase EstadoJuego para imprimir el estado
                        EstadoJuego.imprimirEstadoJuego(colaJugadores, laberinto, estaJugando);
                    } else {
                        System.out.println("No hay una partida en curso.\n");
                    }  
                }
                case "4" -> {
                    bitacora.verBitacora();
                }
                case "5" -> {
                    System.out.println("Haz entrado a mantenimiento de pilas. Seleccione:" +
                            "\n1. Informacion de las pilas premio y castigo" +
                            "\n2. Llenar castigos" +
                            "\n3. Llenar premios" +
                            "\n4. Llenar ambos");
                    int opcionPilas = scanner.nextInt();
                    if (opcionPilas == 1){
                        System.out.println("Informacion pilas: ");
                        System.out.println(">----------Pila premios--------<");
                        pilaPremios.mostrarPremios();
                        System.out.println(">-----------Pila castigos---------<");
                        pilaCastigos.mostrarCastigos();
                        System.out.println("Presione ENTER para continuar");
                    } else if (opcionPilas == 2) {
                        System.out.println("Llenando pila premios");
                        System.out.println("¿Cuantos premios desea agregar?");
                        int cantPremios = scanner.nextInt();
                        pilaPremios.agregarPremiosAleatorios(cantPremios);
                        System.out.println("Presione ENTER para continuar");
                    } else if (opcionPilas == 3) {
                        System.out.println("Llenando pila castigos");
                        System.out.println("¿Cuantos castigos desea agregar?");
                        int cantCastigos = scanner.nextInt();
                        pilaCastigos.agregarCastigosAleatorios(cantCastigos);
                        System.out.println("Presione ENTER para continuar");
                    } else if (opcionPilas == 4) {
                        System.out.println("Llenando pila premios");
                        System.out.println("¿Cuantos premios desea agregar?");
                        int cantPremios = scanner.nextInt();
                        pilaPremios.agregarPremiosAleatorios(cantPremios);
                        System.out.println("Llenando pila castigos");
                        System.out.println("¿Cuantos castigos desea agregar?");
                        int cantCastigos = scanner.nextInt();
                        pilaCastigos.agregarCastigosAleatorios(cantCastigos);
                        System.out.println("Presione ENTER para continuar");
                    } else {
                        System.out.println("No es una opcion valida...");
                    }
                }
                case "6" -> {
                    Ayuda.incrementarVersion();
                    Ayuda.mostrarAyuda();
                }
                case "7" -> {
                    System.out.println("Gracias por jugar\nSaliendo..");
                    opcionMenu = "Q";
                }
                default -> System.out.println("Error intente de nuevo");
            }
            
        } while (opcionMenu != "Q");
        
        scanner.close();
    }
}
