package com.mycompany.proyectofinalgrupo8;

import com.mycompany.proyectofinalgrupo8.Librerias.Pila.NodoPila;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.ListaCircular;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.NodoDoble;
import com.mycompany.proyectofinalgrupo8.Librerias.Lista.ListaDobleC;
import java.util.Scanner;

/**
 *
 * @author fernandafajardo
 * @author Andres Martinez
 * @author Eddy Mena Lopez
 * @author William Bastos Morales
 */

public class Jugar {
    private ColaJugadores colaJugadores;
    private PilaCastigos castigos;
    private PilaPremios premios;
    private ListaCircular laberinto;
    private ListaDobleC bitacora;
    private Dados da2;
    Scanner scanner;
 
    /**
     * *
     * Constructor de la clase Jugar. Inicializa los componentes del juego.
     *
     * @param colaJugadores Cola de jugadores que participarán en el juego.
     * @param premios       Pila de premios disponibles en el juego.
     * @param castigos      Pila de castigos disponibles en el juego.
     * @param laberinto     Representación del laberinto en el juego.
     * @param bitacora      Registro de eventos del juego.
     */
    public Jugar(ColaJugadores colaJugadores, PilaPremios premios, PilaCastigos castigos, ListaCircular laberinto, ListaDobleC bitacora) {
        this.colaJugadores = colaJugadores;
        this.premios = premios;
        this.castigos = castigos;
        this.laberinto = laberinto;
        this.bitacora = bitacora;
        this.da2 = new Dados();
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Obtiene la cola de jugadores en la partida.
     * 
     * @return La cola de jugadores.
     */
    public ColaJugadores getColaJugadores() {
        return colaJugadores;
    }

    /**
     * Establece la cola de jugadores en la partida.
     * 
     * @param colaJugadores La nueva cola de jugadores.
     */
    public void setColaJugadores(ColaJugadores colaJugadores) {
        this.colaJugadores = colaJugadores;
    }

    /**
     * Obtiene la pila de castigos disponibles.
     * 
     * @return La pila de castigos.
     */
    public PilaCastigos getCastigos() {
        return castigos;
    }

    /**
     * Establece la pila de castigos disponibles.
     * 
     * @param castigos La nueva pila de castigos.
     */
    public void setCastigos(PilaCastigos castigos) {
        this.castigos = castigos;
    }

    /**
     * Obtiene la pila de premios disponibles.
     * 
     * @return La pila de premios.
     */
    public PilaPremios getPremios() {
        return premios;
    }

    /**
     * Establece la pila de premios disponibles.
     * 
     * @param premios La nueva pila de premios.
     */
    public void setPremios(PilaPremios premios) {
        this.premios = premios;
    }

    /**
     * Obtiene la representación del laberinto en el juego.
     * 
     * @return El laberinto del juego.
     */
    public ListaCircular getLaberinto() {
        return laberinto;
    }

    /**
     * Establece la representación del laberinto en el juego.
     * 
     * @param laberinto La nueva representación del laberinto.
     */
    public void setLaberinto(ListaCircular laberinto) {
        this.laberinto = laberinto;
    }

    /**
     * Obtiene el registro de eventos del juego.
     * 
     * @return La bitácora del juego.
     */
    public ListaDobleC getBitacora() {
        return bitacora;
    }

    /**
     * Establece el registro de eventos del juego.
     * 
     * @param bitacora La nueva bitácora del juego.
     */
    public void setBitacora(ListaDobleC bitacora) {
        this.bitacora = bitacora;
    }

    /**
     * Obtiene el objeto que simula los dados del juego.
     * 
     * @return Los dados del juego.
     */
    public Dados getDa2() {
        return da2;
    }

    /**
     * Establece el objeto que simula los dados del juego.
     * 
     * @param da2 Los nuevos dados del juego.
     */
    public void setDa2(Dados da2) {
        this.da2 = da2;
    }

    /**
     * *
     * Muestra la cantidad de premios y castigos disponibles en sus respectivas pilas.
     */
    public void informacionPilasBonus() {
        int contPremios = 0;
        int contCastigos = 0;
        NodoPila tempPremios = new NodoPila();
        NodoPila tempCastigos = new NodoPila();
        tempPremios = premios.getTop();
        tempCastigos = castigos.getTop();
        while (tempPremios != null){
            tempPremios = tempPremios.getSig();
            contPremios++;
        }
        while (tempCastigos != null) {
            tempCastigos = tempCastigos.getSig();
            contCastigos++;
        }
        System.out.println("Pila premios: " + contPremios +
                "\nPila castigos: " + contCastigos);
    }
    
    /**
     * *
     * Verifica si hay premios disponibles en la pila de premios.
     *
     * @return true si la pila de premios está vacía, false en caso contrario.
     */
    public boolean hayPremio() {
        return premios.getTop() == null;
    }

    /**
     * *
     * Verifica si hay castigos disponibles en la pila de castigos.
     *
     * @return true si la pila de castigos está vacía, false en caso contrario.
     */
    public boolean hayCastigo() {
        return castigos.getTop() == null;
    }
    
    /**
     * *
     * Inserta una nueva entrada en la bitácora del juego con información sobre el jugador y su posición.
     *
     * @param jugador   El jugador al que se le registrará la acción.
     * @param posicion  Posición del jugador en el laberinto.
     * @param castigo   Descripción del castigo aplicado, si lo hay.
     */
    public void insertarBitacora(Jugador jugador, int posicion, String Castigo){
        NodoDoble nodoJugador = bitacora.buscarJugador(jugador);
        if(nodoJugador != null){
            nodoJugador.getHistorial().insertaOrdenado(posicion, Castigo);
        }else{
            System.out.println("- NO se ha creado entrada en la bitacora");
        }
    }
    
    /**
     * *
     * Aplica un premio o movimiento especial al jugador basado en la pila de premios disponible.
     * 
     * @param jugador El jugador al que se le aplicará el premio o movimiento.
     * @param dados El valor obtenido al lanzar los dados, que se utilizará para mover al jugador.
     * @return El valor del premio aplicado o el valor de los dados si no hay premios disponibles.
     */
    public int aplicarPremio(Jugador jugador, int dados) {
        if (premios.getTop() == null) {
            System.out.println("La pila de premios esta vacia...");
            laberinto.moverJugador(jugador, dados, 0, "+");
            System.out.println("El jugador " + jugador.getNombre() + " se ha movido a la posicion " + laberinto.buscarJugador(jugador));
            insertarBitacora(jugador, laberinto.buscarJugador(jugador), "Posicion " + laberinto.buscarJugador(jugador) + " no tiene castigos/premios");
            return dados;
        } else {
            NodoPila premio = premios.pop();
            int numero = premio.getNumero();
            String operacion = premio.getOperacion();
            laberinto.moverJugador(jugador, dados, numero, operacion);
            System.out.println("El jugador " + jugador.getNombre() + " se ha movido a la posicion " + laberinto.buscarJugador(jugador));
            insertarBitacora(jugador, laberinto.buscarJugador(jugador), premio.getDescripcion());
            return premio.getNumero();
        }
    }

    /**
     * *
     * Aplica un castigo o movimiento especial al jugador basado en la pila de castigos disponible.
     * 
     * @param jugador El jugador al que se le aplicará el castigo o movimiento.
     * @param dados El valor obtenido al lanzar los dados, que se utilizará para mover al jugador.
     * @return El valor del castigo aplicado o el valor de los dados si no hay castigos disponibles.
     */
    public int aplicarCastigo(Jugador jugador, int dados) {
        
        if (castigos.getTop() == null) {
            System.out.println("La pila de castigos esta vacia...");
            laberinto.moverJugador(jugador, dados , 0, "+");
            System.out.println("El jugador " + jugador.getNombre() + " se ha movido a la posicion " + laberinto.buscarJugador(jugador));
            insertarBitacora(jugador, laberinto.buscarJugador(jugador), "Posicion " + laberinto.buscarJugador(jugador) + " no tiene castigos/premios");
            return dados;
        } else {
            // cambiar por castigos.pop 
            NodoPila castigo = castigos.pop();
            int numero = castigo.getNumero();
            String operacion = castigo.getOperacion();
            laberinto.moverJugador(jugador, dados , numero, operacion);
            System.out.println("El jugador " + jugador.getNombre() + " se ha movido a la posicion " + laberinto.buscarJugador(jugador));
            insertarBitacora(jugador, laberinto.buscarJugador(jugador), castigo.getDescripcion());
            return castigo.getNumero();
        }
    }
    
    /**
     * *
     * Ejecuta el turno de un jugador, permitiéndole lanzar los dados y aplicar un premio o castigo según corresponda.
     *
     * @return true si el jugador ha llegado a la meta y ha ganado el juego, false en caso contrario.
     * @throws Exception Si ocurre un error al intentar desencolar un jugador.
     */
    public boolean turno() throws Exception{
        boolean esGanador = false;
        Jugador jugadorActual = colaJugadores.desencolar(); // saco al jugador de la cola
        System.out.println("\n --------- Jugando " + jugadorActual.getNombre() + " --------- ");
        System.out.println("Presione enter para tirar los dados o escriba \"salir\" para salir del juego");
        String seguir = scanner.nextLine();
        if(seguir.toLowerCase().contentEquals("salir")){
            System.out.println("El jugador " + jugadorActual.getNombre() + " salio del juego"); // salgo sin guardar al jugador
        } else {
            da2.tirar();// Simula el lanzamiento de los dados
            System.out.println(da2.mostrar());
            int totalDa2 = da2.getValorDado1() + da2.getValorDado2(); // Calcula el total de los dados
            
            if(totalDa2 % 2 == 0){ // Si la suma de los dados es par, se aplica un premio; si es impar, se aplica un castigo.

                aplicarPremio(jugadorActual, totalDa2);
            }else{
                aplicarCastigo(jugadorActual, totalDa2);
            }  
            colaJugadores.encolar(jugadorActual, false); // lo vuelvo a agregar a la cola
            if (laberinto.buscarJugador(jugadorActual) == laberinto.tamanioLaberinto()) {
                esGanador = true;
            }
        }
        System.out.println("\n --------- Fin del turno de " + jugadorActual.getNombre() + " --------- \n");
        return esGanador;
    }
}
