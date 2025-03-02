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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inicializar Clase Dados
        Dados da2 = new Dados();
        
        //Cola de jugadores
        ColaJugadores colaJ = new ColaJugadores();
        PilaPremios pilaP = new PilaPremios();
        PilaCastigos pilaC = new PilaCastigos();
        
        //Validación cantidad de jugadores
        int cantidadJ = 0;
        
        do{
            System.out.println("Ingrese la cantidad de jugadores (máx 4): ");
            if(scanner.hasNextInt()){
                cantidadJ = scanner.nextInt();
                scanner.nextLine();
                
                if(cantidadJ > 4 || cantidadJ < 1){
                    System.out.println("El número de jugadores debe estar ente 1 y 4. Inténtelo de nuevo.");
                }
            }else{
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next();
            }
        
        }while(cantidadJ > 4 || cantidadJ < 1);
        
        //Inscripción de jugadores
        System.out.println("Ingrese el nombre de los " + cantidadJ + " jugadores:");
        for(int i = 0; i < cantidadJ; i++){
            System.out.println("Ingrese el nombre del jugador " + (i+1) + ": ");
            String nombre = scanner.nextLine();
            colaJ.encolar(new Jugador(nombre, (i+1), 0));
        }
        
        //Agregar elementos a las pilas de premios y castigos - Solo una prueba
        pilaP.push("suma dos posiciones", 2);
        
        pilaC.push("resta tres posiciones", 3);
        
        //Listar los jugadores en la cola
        System.out.println("Jugadores en cola:");
        colaJ.mostrarJugadores();
        
        //Listar pilas de premios y castigos
        System.out.println("Pila de Premios:");
        pilaP.print();
        
        System.out.println("Pila de Castigos:");
        pilaC.print();
        
        // tirar dados
        da2.tirar();
        
        // mostrar dados
        System.out.println(da2.mostrar());
        
    }
}
