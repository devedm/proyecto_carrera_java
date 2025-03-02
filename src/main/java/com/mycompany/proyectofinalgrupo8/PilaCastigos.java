/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author fernandafajardo
 */
public class PilaCastigos extends PilaGenerica{

    public PilaCastigos() {
        super();
    }
    
    
    public void mostrarCastigos(){
        System.out.println("Castigos disponibles: ");
        NodoPila temp = getTop();
        while (temp != null){
            System.out.println("El castigo con la descripcion: " + temp.getDescripcion() + " realizara la operacion: " + temp.getOperacion() + " y retrocedera " + temp.getNumero() + " posiciones");
            temp = temp.getSig();
        }
    }
}
