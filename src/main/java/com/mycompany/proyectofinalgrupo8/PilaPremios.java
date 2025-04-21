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
public class PilaPremios extends PilaGenerica {

    public PilaPremios() {
        super();
    }
    
    /**
     * Muestra la lista de premios disponibles en la pila.
     */
    public void mostrarPremios(){
        System.out.println("Premios disponibles: ");
        NodoPila temp = getTop();
        while (temp != null){
            System.out.println("El premio con la descripcion: " + temp.getDescripcion() + " realizara la operacion: " + temp.getOperacion() + temp.getNumero() + " posiciones");
            temp = temp.getSig();
        }
        
    }
    
    /**
     * Agrega premios aleatorios a la pila.
     * @param numero Cantidad de premios a generar.
     */
    public void agregarPremiosAleatorios(int numero) {
        for (int i = 0; i < numero; i++) {
            int numeroRandom = (int)(Math.random() * 10) + 1;
            this.push("+", numeroRandom, "Adelantas " + numeroRandom + " espacios.");
        }
        System.out.println("Los premios han sido generado con exito");
    }
    
    /**
    * Verifica si hay premios en la pila.
    * @return true si hay al menos un premio, false si la pila está vacía.
    */
    public boolean hayPremio(){
        return this.getTop() != null;
    }
    
    
}
