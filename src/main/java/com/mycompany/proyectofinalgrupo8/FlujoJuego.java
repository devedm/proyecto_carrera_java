package com.mycompany.proyectofinalgrupo8;

import java.util.Scanner;

/**
 *
 * @author fernandafajardo
 * @author Andres Martinez
 */

public class FlujoJuego {
    private int numJugadores, tamPista;
    private Jugador[] jugadoresArray;
    private ColaJugadores colaJugadores;
    private PilaCastigos castigos;
    private PilaPremios premios;

    public FlujoJuego () {
        this.numJugadores = 0;
        this.tamPista = 20;
        this.jugadoresArray = new Jugador[numJugadores];
        this.colaJugadores = new ColaJugadores();
        this.premios = new PilaPremios();
        this.castigos = new PilaCastigos();
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public int getTamPista() {
        return tamPista;
    }

    public void setTamPista(int tamPista) {
        this.tamPista = tamPista;
    }

    public Jugador[] getJugadoresArray() {
        return jugadoresArray;
    }

    public void setJugadoresArray(Jugador[] jugadoresArray) {
        this.jugadoresArray = jugadoresArray;
    }

    public ColaJugadores getColaJugadores() {
        return colaJugadores;
    }

    public void setColaJugadores(ColaJugadores colaJugadores) {
        this.colaJugadores = colaJugadores;
    }

    public PilaCastigos getCastigos() {
        return castigos;
    }

    public void setCastigos(PilaCastigos castigos) {
        this.castigos = castigos;
    }

    public PilaPremios getPremios() {
        return premios;
    }

    public void setPremios(PilaPremios premios) {
        this.premios = premios;
    }

    /***
     * Llena la cola de jugadores con los jugadores del arreglo "jugadoresArray".
     */
    public void llenarColaJugadores() {
        for (Jugador jugador : jugadoresArray) {
            colaJugadores.encolar(jugador,true);
            System.out.println("El jugador " + jugador.getNombre() + "ha sido agregado a la cola");
        }
    }
    
    public void encolarJugador(Jugador jugadorNuevo){
        colaJugadores.encolar(jugadorNuevo, true);
    }

    /***
     * Llena la pila "premios" con bonificaciónes o castigos.
     */
    public void llenarPilasBonus() {
        premios.push("+",8,"Cargando premio");
        premios.push("+",2,"Cargando premio");
        premios.push("+",0,"Cargando premio");

        // Lenar pilas castigos
        castigos.push("-",3,"Cargando castigo");
        castigos.push("=",1,"Cargando castigo");
        castigos.push("-",5,"Cargando castigo");
    }
    
    public boolean hayPremio() {
        return premios.getTop() == null;
    }

    public boolean hayCastigo() {
        return castigos.getTop() == null;
    }
    
    public int aplicarPremio(Jugador jugador, int dados) {
        if (hayPremio()) {
            System.out.println("La pila de premios esta vacia...");
            return 0;
        } else {
            NodoPila premio = premios.pop();
            int numero = premio.getNumero();
            String operacion = premio.getOperacion();
            jugador.moverJugador(dados, numero, operacion);
            System.out.println("El jugador " + jugador.getNombre() + " se ha movido a la posicion " + jugador.getPosicion());
            return premio.getNumero();
        }
    }

    public int aplicarCastigo(Jugador jugador, int dados) {
        
        if (hayCastigo()) {
            System.out.println("La pila de castigos esta vacia...");
            return 0;
        } else {
            // cambiar por castigos.pop 
            NodoPila castigo = castigos.pop();
            int numero = castigo.getNumero();
            String operacion = castigo.getOperacion();
            jugador.moverJugador(dados , numero, operacion);
            System.out.println("El jugador " + jugador.getNombre() + " se ha movido a la posicion " + jugador.getPosicion());
            
            return castigo.getNumero();
        }
    }

    public boolean validarGanador(Jugador jugadorActual){
        return jugadorActual.getPosicion() >= tamPista;
    }
    

    /***
     * Inicia el juego, permitiendo que cada jugador tenga su turno lanzando los dados.
     * Dependiendo del resultado, se les aplicará un premio o castigo.
     * @throws Exception Si ocurre un error inesperado durante la ejecución del juego
     */

    public void juego() throws Exception{
        Scanner scanner =  new Scanner(System.in);
        int totalDa2 = 0;
        Dados da2 = new Dados();
        boolean hayGanador = false; // validar si se gano el juego para salir del loop de juego
        
        do {
            
            //Loop para que cada jugador tenga su turno
            for(int i = 0; i < numJugadores; i++){
                Jugador jugadorTurno = colaJugadores.getFrente().getJugador();

                //Muestra quien es el siguiente en jugar
                colaJugadores.mostrarTurno();

                //Para mostrar los dados el jugador debera de dar Enter
                System.out.println("----- " + jugadorTurno.getNombre() + " jugando -----");
                System.out.println("El jugador " + jugadorTurno.getNombre() + " se encuentra en la posicion " + jugadorTurno.getPosicion());
                System.out.println("\n" + jugadorTurno.getNombre() + ", presione enter para lanzar los dados.");
                scanner.nextLine();

                //Tirar dados
                da2.tirar();
                //Muestra el resultado de los dados
                System.out.println(da2.mostrar());
                //Calcula el total de los dados
                totalDa2 = da2.getValorDado2() + da2.getValorDado1();

                //Aplica premio o castigo en base a valor total de los dados
                if(totalDa2 % 2 == 0){
                    aplicarPremio(jugadorTurno, totalDa2);
                }else{
                    aplicarCastigo(jugadorTurno, totalDa2);
                }
                                
                hayGanador = validarGanador(jugadorTurno);
                

                //Mueve al jugador al final de la cola
                colaJugadores.encolar(colaJugadores.desencolar(), false);
                
                System.out.println("----- Fin del turno de " + jugadorTurno.getNombre() + " -----");
            }
            
            System.out.println("----- Posiciones en este turno -----");
            colaJugadores.mostrarPosiciones();
            
        } while (!hayGanador);
        
        
        
        
    }

}
