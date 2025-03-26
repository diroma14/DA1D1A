package hasmap;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class poker {
    public static void main(String[] args) {
        /* Iniciar métodos y variables */
        HashMap<String, Integer> numeros = new HashMap<>();
        HashMap<String, Integer> palos = new HashMap<>();
        ArrayList<String> baraja = new ArrayList<>();
        ArrayList<String> jugador1 = new ArrayList<>();
        ArrayList<String> jugador2 = new ArrayList<>();
        ArrayList<String> mesa = new ArrayList<>();
        HashMap<String, Integer> cartasJugador1 = new HashMap<>();
        HashMap<String, Integer> cartasJugador2 = new HashMap<>();
        HashMap<String, Integer> palosJugador1 = new HashMap<>();
        HashMap<String, Integer> palosJugador2 = new HashMap<>();
        Integer puntosJugador1 = 0; // Puntos iniciales del jugador 1
        Integer puntosJugador2 = 0; // Puntos iniciales del jugador 2
        ArrayList<Integer> posibleEscalera = new ArrayList<>();

        /* Lista numeros */
        numeros.put("A", 0);
        numeros.put("2", 0);
        numeros.put("3", 0);
        numeros.put("4", 0);
        numeros.put("5", 0);
        numeros.put("6", 0);
        numeros.put("7", 0);
        numeros.put("8", 0);
        numeros.put("9", 0);
        numeros.put("10", 0);
        numeros.put("J", 0);
        numeros.put("Q", 0);
        numeros.put("K", 0);

        /* Lista palos */

        palos.put("Picas", 0);
        palos.put("Corazones", 0);
        palos.put("Rombos", 0);
        palos.put("Tréboles", 0);

        /* Crear baraja, recorre cada numero y le asigna los cuatro palos. */

        for (String numero : numeros.keySet()) {
            /* Numero guarda cada número */
            for (String palo : palos.keySet()) {
                /* Palo guarda cada palo */
                String carta = numero + "_" + palo;
                baraja.add(carta);
            }
        }

        /* Mostrar baraja */
        /* System.out.println(baraja); */

        /* Barajear */

        Collections.shuffle(baraja);

        /* Repartir a un jugador luego a otro, luego al primero y luego a otro */

        jugador1.add(baraja.get(0));
        baraja.remove(baraja.get(0));
        jugador2.add(baraja.get(0));
        baraja.remove(baraja.get(0));
        jugador1.add(baraja.get(0));
        baraja.remove(baraja.get(0));
        jugador2.add(baraja.get(0));
        baraja.remove(baraja.get(0));

        /* Mostrar cartas del jugador 1 y jugador 2 */

        System.out.println("");
        System.out.println("----Cartas iniciales de los jugadores----");
        System.out.println(jugador1);
        System.out.println(jugador2);
        System.out.println("-----------------------------------------");
        System.out.println("");

        /* Se queman 2 y Repartir 5 cartas a la mesa */

        baraja.remove(0); /* Quemar 1 */
        baraja.remove(0); /* Quemar 1 */

        for (int i = 0; i < 5; i++) {
            mesa.add(baraja.get(0));
            baraja.remove(0);
        }

        System.out.println("----Cartas de la mesa----");
        System.out.println("Mesa: " + mesa);
        System.out.println("-------------------------");
        System.out.println("");

        /* Añadir a cada jugador las cartas de la mesa */

        jugador1.addAll(mesa);
        jugador2.addAll(mesa);

        System.out.println("----Cartas finales de los jugadores----");
        System.out.println("Jugador 1:" + jugador1);
        System.out.println("Jugador 2:" + jugador2);
        System.out.println("-----------------------------------------");
        System.out.println("");

        /* Contar cartas de cada jugador */

        System.out.println("----Cartas contadas----");
        contarCartas(jugador1, cartasJugador1); // Contar cartas del jugador 1
        contarCartas(jugador2, cartasJugador2); // Contar cartas del jugador 2
        System.out.println("-----------------------");
        System.out.println("");

        /* Contar palos de cada jugador */
        System.out.println("----Palos contados----");
        contarPalos(jugador1, palosJugador1); // Contar los palos del jugador 1
        contarPalos(jugador2, palosJugador2); // Contar los palos del jugador 2
        System.out.println("----------------------");
        System.out.println("");

        // Determinar la jugada para el jugador 1
        String jugada1 = jugada(cartasJugador1, palosJugador1);
        System.out.println("Jugada del jugador 1: " + jugada1);

        // Determinar la jugada para el jugador 2
        String jugada2 = jugada(cartasJugador2, palosJugador2);
        System.out.println("Jugada del jugador 2: " + jugada2);
        System.out.println("");

        // Asignar puntos según la jugada de cada jugador
        puntosJugador1 = puntos(jugada1, puntosJugador1);
        puntosJugador2 = puntos(jugada2, puntosJugador2);

        // Mostrar los puntos de cada jugador
        System.out.println("Puntos del jugador 1: " + puntosJugador1);
        System.out.println("Puntos del jugador 2: " + puntosJugador2);
        System.out.println("");

        /* Determinar ganador */
        if (puntosJugador1 == puntosJugador2) {
            System.out.println("Empate.");
        } else if (puntosJugador1 > puntosJugador2) {
            System.out.println("Ganó el jugador 1.");
        } else {
            System.out.println("Ganó el jugador 2.");
        }

        // Escalera

        for (String j : cartasJugador1.keySet()) {
            if (j.equals("A")) {
                posibleEscalera.add(1);
                posibleEscalera.add(14);
            } else if (j.equals("J")) {
                posibleEscalera.add(11);
            } else if (j.equals("Q")) {
                posibleEscalera.add(12);
            } else if (j.equals("K")) {
                posibleEscalera.add(13);
            } else {
                posibleEscalera.add(Integer.valueOf(j));
            }

        }
        /*
         * posibleEscalera.add(0);
         * posibleEscalera.add(2);
         * posibleEscalera.add(3);
         * posibleEscalera.add(4);
         * posibleEscalera.add(5);
         * posibleEscalera.add(6);
         */
        Collections.sort(posibleEscalera);

        int numeroActual = posibleEscalera.get(0);
        int contadorEscalera = 0;
        System.out.println(posibleEscalera);

        for (int i = 0; i < posibleEscalera.size(); i++) {
            if (posibleEscalera.get(i) == numeroActual + 1) {
                contadorEscalera++;
                numeroActual = posibleEscalera.get(i);
            } else {
                contadorEscalera = 0;
                numeroActual = posibleEscalera.get(i);
            }
            System.out.println("Contador: " + contadorEscalera);
            if (contadorEscalera == 4) {
                System.out.println("Escalera");
            }
        }

    }
    /*-------------------------------------------------------------Funciones--------------------------------------------------------------------------------------------------- */

    /* Función para contar las cartas de cada jugador */
    private static void contarCartas(ArrayList<String> jugador, HashMap<String, Integer> cartasJugador) {
        for (String carta : jugador) {
            String numCarta = String.valueOf(carta.charAt(0)); /* Recoge el primer caracter de cada carta */
            /*
             * Comprobamos si existe en las cartas del jugador, si existe se incrementa, si
             * no existe se añade con valor 1.
             */
            if (numCarta.equals("1")) {
                if (cartasJugador.containsKey("10")) { /* Existe */
                    cartasJugador.put("10", cartasJugador.get("10") + 1);
                } else { /* No existe */
                    cartasJugador.put("10", 1);
                }
            }
            if (cartasJugador.containsKey(numCarta)) { /* Existe */
                cartasJugador.put(numCarta, cartasJugador.get(numCarta) + 1);
            } else { /* No existe */
                cartasJugador.put(numCarta, 1);
            }
        }

        System.out.println("Cartas jugador1: " + cartasJugador);
    }

    /* Función para contar los palos de un jugador */
    private static void contarPalos(ArrayList<String> jugador, HashMap<String, Integer> palosJugador) {
        for (String carta : jugador) {
            String palo = ""; // Variable para almacenar el palo
            int d = 0;

            // Recorrer los caracteres de la carta
            while (d < carta.length()) {
                char e = carta.charAt(d); /* Caracter */

                if (e == '_') {
                    // Una vez encontrado '_', comenzar a recoger el palo desde el siguiente
                    // carácter
                    d++; // Avanzar al siguiente carácter después de '_'
                    while (d < carta.length()) {
                        palo += carta.charAt(d); // Continuar añadiendo caracteres al palo
                        d++;
                    }
                    break; // Salir del bucle una vez que se haya construido el palo
                }

                d++;
            }

            // Actualizar el conteo del palo en el HashMap
            if (palosJugador.containsKey(palo)) {
                palosJugador.put(palo, palosJugador.get(palo) + 1); // Incrementar el contador si el palo ya existe
            } else {
                palosJugador.put(palo, 1); // Si no existe el palo, añadirlo con un valor de 1
            }
        }
        System.out.println(palosJugador);
    }

    /* Función para determinar la jugada */
    private static String jugada(HashMap<String, Integer> cartasJugador, HashMap<String, Integer> palosJugador) {
        String jugada = "";

        if (cartasJugador.containsValue(4)) {
            jugada = "Póker";
        } else if (cartasJugador.containsValue(3) && cartasJugador.containsValue(2)) {
            jugada = "Full";
        } else if (cartasJugador.containsValue(3)) {
            jugada = "Trío";
        } else if (palosJugador.containsValue(4)) {
            jugada = "Color";
        } else {
            int pares = 0;
            for (int c : cartasJugador.values()) {
                if (c == 2) {
                    pares++;
                }
            }
            if (pares >= 2) {
                jugada = "Doble pareja";
            } else if (pares == 1) {
                jugada = "Pareja";
            } else {
                jugada = "Sin jugada";
            }
        }

        return jugada;
    }

    private static Integer puntos(String jugada, Integer puntosJugador) {
        switch (jugada) {
            case "Póker":
                puntosJugador = 6;
                break;
            case "Full":
                puntosJugador = 5;
                break;
            case "Trío":
                puntosJugador = 4;
                break;
            case "Color":
                puntosJugador = 3;
                break;
            case "Doble pareja":
                puntosJugador = 2;
                break;
            case "Pareja":
                puntosJugador = 1;
                break;
            default:
                puntosJugador = 0;
                break;
        }

        return puntosJugador;
    }
}
