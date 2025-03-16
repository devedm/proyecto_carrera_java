package com.mycompany.proyectofinalgrupo8;

import java.util.Scanner;

/**
 *
 * @author fernandafajardo
 * @author Andres Martinez
 * @author Eddy Mena Lopez
 * @author William Bastos Morales
 */

public class FlujoJuego {
    private int numJugadores, tamPista;
    private Jugador[] jugadoresArray;
    private ColaJugadores colaJugadores;
    private PilaCastigos castigos;
    private PilaPremios premios;
    private boolean permiteAgregarJugadores;

    public FlujoJuego () {
        this.numJugadores = 0;
        this.tamPista = 20;
        this.jugadoresArray = new Jugador[numJugadores];
        this.colaJugadores = new ColaJugadores();
        this.premios = new PilaPremios();
        this.castigos = new PilaCastigos();
        this.permiteAgregarJugadores = false;
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

    public boolean isPermiteAgregarJugadores() {
        return permiteAgregarJugadores;
    }

    public void setPermiteAgregarJugadores(boolean permiteAgregarJugadores) {
        this.permiteAgregarJugadores = permiteAgregarJugadores;
    }
    
    public void agregarJugadorAdicional(Jugador nuevoJugador) {
        if (!permiteAgregarJugadores) {
            System.out.println("La opción de agregar jugadores no fue permitida al inicio de la partida.");
            return;
        }
        if (colaJugadores.getTamano() >= ColaGenerica.getMaxJugadores()) {
            System.out.println("No se pueden agregar más jugadores. Límite alcanzado!");
            return;
        }
        colaJugadores.encolar(nuevoJugador, true);
        numJugadores++;
        System.out.println("Jugador " + nuevoJugador.getNombre() + " añadido correctamente a la partida.");
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
    
    /**
    * Aplica un premio o movimiento especial al jugador basado en la pila de premios disponible.
    * 
    * @param jugador El jugador al que se le aplicará el premio o movimiento.
    * @param dados El valor obtenido al lanzar los dados, que se utilizará para mover al jugador.
    * @return El valor del premio aplicado o el valor de los dados si no hay premios disponibles.
    */
    public int aplicarPremio(Jugador jugador, int dados) {
        if (hayPremio()) {
            System.out.println("La pila de premios esta vacia...");
            jugador.moverJugador(dados, 0, "+");
            System.out.println("El jugador " + jugador.getNombre() + " se ha movido a la posicion " + jugador.getPosicion());
            return dados;
        } else {
            NodoPila premio = premios.pop();
            int numero = premio.getNumero();
            String operacion = premio.getOperacion();
            jugador.moverJugador(dados, numero, operacion);
            System.out.println("El jugador " + jugador.getNombre() + " se ha movido a la posicion " + jugador.getPosicion());
            return premio.getNumero();
        }
    }

    /**
    * Aplica un castigo o movimiento especial al jugador basado en la pila de castigos disponible.
    * 
    * @param jugador El jugador al que se le aplicará el castigo o movimiento.
    * @param dados El valor obtenido al lanzar los dados, que se utilizará para mover al jugador.
    * @return El valor del castigo aplicado o el valor de los dados si no hay castigos disponibles.
    */
    public int aplicarCastigo(Jugador jugador, int dados) {
        
        if (hayCastigo()) {
            System.out.println("La pila de castigos esta vacia...");
            jugador.moverJugador(dados , 0, "+");
            System.out.println("El jugador " + jugador.getNombre() + " se ha movido a la posicion " + jugador.getPosicion());
            return dados;
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
    
    /**
    * Valida si un jugador ha alcanzado o superado la posición requerida para ganar.
    * 
    * @param jugadorActual El jugador cuya posición se va a validar.
    * @return `true` si el jugador ha alcanzado o superado el tamaño de la pista, `false` en caso contrario.
    */
    public boolean validarGanador(Jugador jugadorActual){
        return jugadorActual.getPosicion() >= tamPista;
    }
    
    /**
    * Muestra al jugador ganador, si existe, en la cola de jugadores.
    */
    public void mostrarGanador(){
        if (colaJugadores.esVacia()) {
            System.out.println("No hay jugadores inscritos.");
        }

        NodoCola actual = colaJugadores.getFrente();
        while (actual != null) {
            if(validarGanador(actual.getJugador())){
                System.out.println("El jugador " + actual.getJugador().getNombre() + " ha ganado.\n\n ----- FELICIDADES -----\n");
                break;
            }
            actual = actual.getSig();
        }
    }
    
    /**
    * Valida si hay jugadores inscritos en la cola de jugadores.
    * 
    * @return `true` si la cola de jugadores está vacía, `false` si hay jugadores inscritos.
    */
    public boolean validarJugadores(){
        return colaJugadores.esVacia();
    }
    
    
    public void insertarJugadorEnPosicion(Jugador jugador, int posicion) {
        NodoCola nuevoNodo = new NodoCola(jugador);
        if (posicion <= 0 || colaJugadores.esVacia()) {
            nuevoNodo.setSig(colaJugadores.getFrente());
            colaJugadores.setFrente(nuevoNodo);
            if (colaJugadores.getUltimo() == null) {
                colaJugadores.setUltimo(nuevoNodo);
            }
        } else {
            NodoCola actual = colaJugadores.getFrente();
            int index = 0;
            while (actual != null && index < posicion - 1) {
                actual = actual.getSig();
                index++;
            }
            if (actual == null) {
                // Si la posición es mayor que el tamaño, se encola normalmente
                colaJugadores.encolar(jugador, false);
                return;
            }
            nuevoNodo.setSig(actual.getSig());
            actual.setSig(nuevoNodo);
            if(nuevoNodo.getSig() == null) {
                colaJugadores.setUltimo(nuevoNodo);
            }
            // Se asume que se actualiza el tamaño internamente en la cola
        }
    }

    /***
     * Inicia el juego, permitiendo que cada jugador tenga su turno lanzando los dados.
     * Este método controla el flujo del juego:
     * 1. Itera sobre cada jugador en la cola de jugadores.
     * 2. En cada turno, el jugador lanza los dados y se calcula el total obtenido.
     * 3. Si el total de los dados es par, se aplica un premio al jugador; si es impar, se aplica un castigo.
     * 4. Se verifica si el jugador ha alcanzado o superado la posición requerida para ganar.
     * 5. Si hay un ganador, se muestra un mensaje de felicitación y el juego termina.
     * 6. Si no hay ganador, el jugador se mueve al final de la cola y el turno pasa al siguiente jugador.
     * 7. Al final de cada ronda, se muestran las posiciones actuales de todos los jugadores.
     * 8. El juego continúa hasta que un jugador gana o no hay mas jugadores.
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
                
                if(hayGanador){
                    break;
                }
                
                Jugador jugadorTurno = colaJugadores.getFrente().getJugador();

                //Muestra quien es el siguiente en jugar
                colaJugadores.mostrarTurno();
                System.out.println("----- " + jugadorTurno.getNombre() + " Posicion " + jugadorTurno.getPosicion() + " -----");
                
                
                String input = "";
                boolean seleccionValida = false;
                
                do{
                    System.out.println("\n" + jugadorTurno.getNombre() +
                        ", presione enter para lanzar los dados, 'consultar' para ver el estado, " +
                        "'salir' para abandonar la partida o 'agregar' para unir un nuevo jugador.");
                    input = scanner.nextLine();
                    if (input.equalsIgnoreCase("consultar")){
                        System.out.println("----- Estado de las Pilas de Premios -----");
                        premios.mostrarPremios();
                        System.out.println("----- Estado de las Pilas de Castigos -----");
                        castigos.mostrarCastigos();
                        System.out.println("----- Estado de la Cola de Jugadores -----");
                        colaJugadores.mostrarPosiciones();
                    } else if (input.equalsIgnoreCase("agregar")){
                        // Se pregunta siempre el nombre y luego se evalúa la bandera
                        if (!permiteAgregarJugadores) {
                            System.out.println("La opción de agregar jugadores no fue permitida al inicio de la partida.");
                        } else {
                            
                            if (colaJugadores.getTamano() < ColaGenerica.getMaxJugadores()) {
                                System.out.print("Ingrese el nombre del nuevo jugador: ");
                                String nuevoNombre = scanner.nextLine();
                                Jugador nuevoJugador = new Jugador(nuevoNombre, numJugadores + 1, 0);
                                agregarJugadorAdicional(nuevoJugador);
                            } else {
                                System.out.println("No se pueden agregar más jugadores, límite máximo alcanzado.");
                            }
                        }
                    } else{
                        seleccionValida = true;
                    }
                } while(!seleccionValida);
                
                if (input.equalsIgnoreCase("salir")){
                    try{
                        if (colaJugadores.removerJugadorPorId(jugadorTurno.getNumeroJugador())){
                            numJugadores--; // actualiza el numero de jugadores si algun jugador abandona la partida
                            System.out.println(jugadorTurno.getNombre() + " ha abandonado la partida");
                            // si todos los jugadores abandonan la partida, se acaba el juego
                            if (colaJugadores.esVacia()){
                                System.out.println("No quedan jugadores en la partida. Fin del juego.");
                                return;
                            }
                            continue;
                        }
                        else{
                            System.out.println("No se pudo remover a " + jugadorTurno.getNombre() + ". Se continuara con el turno");
                        }
                    }catch(Exception e){
                        System.out.println("Error al intentar abandonar la partida: " + e.getMessage());
                    }
                }
                
                // si no se escribe la palabra "salir" se procede con el turno normal desencolando al jugador para que tome su turno
                jugadorTurno = colaJugadores.desencolar();

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
                
                // valida si el jugador gano la partida
                hayGanador = validarGanador(jugadorTurno);
                
                //Mueve al jugador al final de la cola
                // ----------- Insertar Menu para Salir o seguir jugando -----------------
                colaJugadores.encolar(jugadorTurno, false);
                // para salir del loop de juego en caso de que no hayan jugadores (colaJugadores.esVacia()) puedes usar (hayGanador = true) para a tirar el mensaje de que no hay jugadores.
                
                
                System.out.println("----- Fin del turno de " + jugadorTurno.getNombre() + " -----");
            }
            
            System.out.println("----- Posiciones en este turno -----");
            colaJugadores.mostrarPosiciones();    
            mostrarGanador();
            
        } while (!hayGanador);
        
        while (!colaJugadores.esVacia()){
            colaJugadores.desencolar();
        }
    }
}
