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
        
        //Cola de jugadores
        ColaJugadores cola = new ColaJugadores();
        
        System.out.println("Bienvenidos al juego!");
        System.out.print("Ingrese la cantidad de jugadores (1-4): ");
        int cantidad = 0;
        
       //Validar que la cantidad de jugadores
       while(cantidad < 1 || cantidad > 4){
           cantidad = scanner.nextInt();
           if(cantidad < 1 || cantidad > 4){
               System.out.print("Por favor ingrese un número entre 1 y 4: ");
           }
       }
       
       scanner.nextLine(); //Limpiamos el buffer de scanner
       
       //Solicitar los nombres de los jugadores
       for(int i = 1; i <= cantidad; i++){
           System.out.print("Ingrese el nombre del jugador " + i + ": ");
           String nombre = scanner.nextLine();
           cola.encolar(nombre);
       }
       
       // Mostrar los jugadores en la cola
       cola.mostrarJugadores();
       
    }
}
