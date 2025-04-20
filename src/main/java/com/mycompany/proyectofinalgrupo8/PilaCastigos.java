/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

import com.mycompany.proyectofinalgrupo8.Librerias.Pila.NodoPila;
import com.mycompany.proyectofinalgrupo8.Librerias.Pila.PilaGenerica;

/**
 *
 * @author fernandafajardo
 * @author William Bastos
 */
public class PilaCastigos extends PilaGenerica{

    public PilaCastigos() {
        super();
    }

    /**
     * Muestra la lista de castigos disponibles en la pila.
     * Recorre la pila desde el nodo superior e imprime la descripción y la operación de cada castigo.
     */
    public void mostrarCastigos(){
        System.out.println("Castigos disponibles: ");
        NodoPila temp = getTop();
        while (temp != null){
            System.out.println("El castigo con la descripcion: " + temp.getDescripcion() + " realizara la operacion: " + temp.getOperacion() + temp.getNumero() + " posiciones");
            temp = temp.getSig();
        }
    }
    
    /**
    * Agrega una cantidad específica de castigos aleatorios a la pila.
    * Cada castigo tiene una penalización aleatoria de entre 1 y 10 posiciones.
    * @param numero Número de castigos aleatorios a generar.
    */
    public void agregarCastigosAleatorios(int numero) {
        for (int i = 0; i < numero; i++) {
            int numeroRandom = (int)(Math.random() * 10) + 1;
            this.push("-", numeroRandom, "Retrocedes " + numeroRandom + " espacios.");
            //System.out.println("Los castigos han sido generado con exito");
        }
    }
    
    /**
     * Verifica si hay castigos en la pila.
     * @return true si hay castigos, false si la pila está vacía.
     */
    public boolean hayCastigo(){
        return this.getTop() != null;
    }
}
