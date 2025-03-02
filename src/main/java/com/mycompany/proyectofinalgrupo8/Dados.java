
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
    public void tirar(){
        setValorDado1((int)(Math.random() * 6) + 1);
        setValorDado2((int)(Math.random() * 6) + 1);
        int sumaDados = getValorDado1() + getValorDado2();      // Sumo los resultados para comparatlos
        Jugador temp = colaAux.desencolar();                    // Desencolar devuelva un juagor lo guardo en una variable temporal

        if (sumaDados%2 == 0) {
            int premioObtenido = premios.getTop().getNumero();
            System.out.println("Obtuviste un número par, debes tomar un premio de la pila. Mucha Suerte");
            System.out.println("Como premio puedes moverte: " + premioObtenido + " veces");
            System.out.println("Seras movido a la posicion: " + (temp.getPosicion() + premioObtenido));
            temp.moverJugador(premioObtenido);
        } else {
            int castigoObtenido = castigos.getTop().getNumero();
            System.out.println("Obtuviste un número impar, debes tomar un castigo de la pila. Mejor suerte la próxima vez");
            System.out.println("Como castigo retrocederas: " + castigoObtenido + " veces");
            System.out.println("Seras movido a la posicion: " + (temp.getPosicion() + castigoObtenido));
            temp.moverJugador(castigoObtenido);
        }

        System.out.println("La posicion actual del jugador es: " + temp.getPosicion());
        colaAux.encolar(temp);          // Se encola a la ultima posicion al jugador encolado
    }
    
    /**
    * Devuelve una cadena de texto que muestra los valores actuales de los dos dados.
    * 
    * @return Una cadena de texto en el formato: "El resultado de los dados es: X y Y",
    *         donde X es el valor del primer dado y Y es el valor del segundo dado.
    */
    public String mostrar(){
        return "El resultado de los dados es: " + getValorDado1() + " y " + getValorDado2(); 
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

    /**
     * Obtiene el valor actual del segundo dado.
     * 
     * @return El valor del segundo dado.
     */
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



    public PilaPremios getPremios() {
        return premios;
    }

    public void setPremios(PilaPremios premios) {
        this.premios = premios;
    }

    public PilaCastigos getCastigos() {
        return castigos;
    }

    public void setCastigos(PilaCastigos castigos) {
        this.castigos = castigos;
    }
}

