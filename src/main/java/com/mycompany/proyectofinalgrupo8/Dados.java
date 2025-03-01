
package com.mycompany.proyectofinalgrupo8;

/**
 *
 * @author Eddy Mena Lopez
 */
public class Dados {
    private int valorDado1; //  valor del dado 1
    private int valorDado2; // valor del dado 2

    public Dados() {
        valorDado1 = 0;
        valorDado2 = 0;
    }
    
    /**
    * Simula el lanzamiento de dos dados.
    * Asigna a cada dado un valor aleatorio entre 1 y 6, que representa el resultado del lanzamiento.
    * Los valores generados se almacenan en los atributos `valorDado1` y `valorDado2`.
    */
    public void tirarDados(){
        setValorDado1((int)(Math.random() * 6) + 1);
        setValorDado2((int)(Math.random() * 6) + 1);
    }

    /**
     * Obtiene el valor actual del primer dado.
     * 
     * @return El valor del primer dado.
     */
    public int getValorDado1() {
        return valorDado1;
    }

    /**
     * Establece el valor del primer dado.
     * 
     * @param valorDado1 El valor que se asignará al primer dado.
     */
    public void setValorDado1(int valorDado1) {
        this.valorDado1 = valorDado1;
    }

    
    public int getValorDado2() {
        return valorDado2;
    }
    
    /**
     * Establece el valor del segundo dado.
     * 
     * @param valorDado2 El valor que se asignará al segundo dado.
     */
    public void setValorDado2(int valorDado2) {
        this.valorDado2 = valorDado2;
    }
}

