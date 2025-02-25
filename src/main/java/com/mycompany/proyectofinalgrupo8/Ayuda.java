/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author fernandafajardo
 */
public class Ayuda {
    
    /***
     * Versión base del juego en formato V 1.0.N.
     */
    private static String version = "1.0.";
    private static int versionNumero = 1; // Incrementa cada vez que haya un avance
    
    private static String desarrolladores = "Eddy, Fernanda, Andres, William";

    /***
     * Muestra la versión actual del juego y los desarrolladores.
     */
    public static void mostrarAyuda(){
        System.out.println("Versión del juego: V " + version + versionNumero);
        System.out.println("Desarrollado por Grupo 8: " + desarrolladores);
    }
    
    /***
     * Incrementa el número de versión cuando hay un avance en el desarrollo del juego.
     */
    public static void incrementarVersion(){
        versionNumero++;
    }
}
