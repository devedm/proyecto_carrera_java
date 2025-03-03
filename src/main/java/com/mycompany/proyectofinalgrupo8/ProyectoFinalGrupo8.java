/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinalgrupo8;

import java.util.Scanner;

/**
 *
 * @author minio
 */
public class ProyectoFinalGrupo8 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String opcionMenu = "";
        FlujoJuego flujoJ = new FlujoJuego();
        
        do {            
            System.out.println("1.Jugar\n2.Ayuda\n3.Salir\nSeleccione la opcion deseada: ");
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
                            // Solicitar el nombre o alias para cada jugador.
                            for (int i = 0; i < numeroJugadores; i++) {
                                System.out.print("Ingrese el nombre o alias del jugador " + (i + 1) + ": ");
                                String nombreJugador = scanner.nextLine();
                                flujoJ.getColaJugadores().encolar(new  Jugador(nombreJugador, (i+1), 0), true);
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
                }
                default -> throw new AssertionError();
            }
            
        } while (opcionMenu != "3");
        
        scanner.close();
//        
//        
//        
//        
//        //Cola de jugadores
//        ColaJugadores colaJ = new ColaJugadores();
//        PilaPremios pilaP = new PilaPremios();
//        PilaCastigos pilaC = new PilaCastigos();
//        
//        //Validación cantidad de jugadores
//        int cantidadJ = 0;
//        
//        do{
//            System.out.println("Ingrese la cantidad de jugadores (máx 4): ");
//            if(scanner.hasNextInt()){
//                cantidadJ = scanner.nextInt();
//                scanner.nextLine();
//                
//                if(cantidadJ > 4 || cantidadJ < 1){
//                    System.out.println("El número de jugadores debe estar ente 1 y 4. Inténtelo de nuevo.");
//                }
//            }else{
//                System.out.println("Entrada inválida. Por favor, ingrese un número.");
//                scanner.next();
//            }
//        
//        }while(cantidadJ > 4 || cantidadJ < 1);
//        
//        //Inscripción de jugadores
//        System.out.println("Ingrese el nombre de los " + cantidadJ + " jugadores:");
//        for(int i = 0; i < cantidadJ; i++){
//            System.out.println("Ingrese el nombre del jugador " + (i+1) + ": ");
//            String nombre = scanner.nextLine();
//            colaJ.encolar(new Jugador(nombre, (i+1), 0));
//        }
//        
//        //Agregar elementos a las pilas de premios y castigos - Solo una prueba
//        pilaP.push("suma", 2, "suma 2 posiciones");
//        
//        pilaC.push("resta", 3, "resta 3 posiciones");
//        
//        //Listar los jugadores en la cola
//        System.out.println("Jugadores en cola:");
//        colaJ.mostrarJugadores();
//        
//        //Listar pilas de premios y castigos
//        System.out.println("Pila de Premios:");
//        pilaP.print();
//        
//        System.out.println("Pila de Castigos:");
//        pilaC.print();
//        
//        // Prueba desencolar
//        Jugador jugadorPrueba = colaJ.desencolar();
//        
//        // Mostrar Jugador que se desencolo
//        System.out.println("Se ha desencolado al jugador " + jugadorPrueba.getNombre() + " se encuentra en la posicion " + jugadorPrueba.getPosicion());
//        
//        // tirar dados
//        da2.tirar();
//        
//        // mostrar dados
//        System.out.println(da2.mostrar());
//        
//        // mostrar posicion
//        System.out.println("El jugador " + jugadorPrueba.getNombre() + " se ha movido en a la posicion " + jugadorPrueba.moverJugador((da2.getValorDado1() + da2.getValorDado2())));
//        
//        // Encolar jugador
//        colaJ.encolar(jugadorPrueba);
//        
//        // mostrar posiciones de todos los jugadores
//        colaJ.mostrarPosiciones();
    }
}
