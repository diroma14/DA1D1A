package hasmap;

import java.util.HashMap;
import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        /* Iniciar métodos y variables */
        HashMap<String, Integer> tabla = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int seguir = 1;
        String jugador = "";
        int puntuación = 0;
        String sino = "";
        int record = 0;
        int sumatorio = 0;

        /* Lista inventada */
        tabla.put("GG", 99);
        tabla.put("DG", 88);
        tabla.put("MN", 60);
        tabla.put("SF", 100);
        tabla.put("VK", 40);

        /* Menú */

        do {
            System.out.println();
            System.out.println("---Menú---");
            System.out.println("1. Agregar/Modificar puntuación.");
            System.out.println("2. Mejor puntuación.");
            System.out.println("3. Promedio puntuación.");
            System.out.println("4. Mostrar puntuaciones.");
            System.out.println("5. Salir.");
            System.out.println("------");
            System.out.println();
            System.out.println("Elige una opción:");
            Integer opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("---Agregar/Modificar puntuación.---");
                    System.out.println("Introduce el nombre del jugador (2 caracteres).");
                    sc.nextLine();
                    jugador = sc.nextLine().toUpperCase();
                    if (jugador.length() != 2) {
                        System.out.println("El jugador solo puede tener 2 caracteres.");
                    } else {
                        System.out.println("Introduce la puntuación a añadir.");
                        puntuación = sc.nextInt();

                        /* Primero comprueba si existe o no. */
                        if (tabla.containsKey(jugador)) { /*
                                                           * Si existe pregunta si quiere actualizar la puntuación o no
                                                           */
                            System.out.println(
                                    "El jugador " + jugador + " ya se encuentra en la tabla y tiene una puntuación de "
                                            + tabla.get(jugador) + ", ¿Quieres actualizar la puntuación?");
                            System.out.println("(S/N)");
                            sc.nextLine();
                            sino = sc.nextLine().toUpperCase();
                            switch (sino) {
                                case "S":
                                    tabla.put(jugador, puntuación);
                                    break;
                                case "N":
                                    System.out.println("Entendido.");
                                    break;

                                default:
                                    System.out.println("Introduce una opción válida (S/N)");
                                    break;
                            }

                        } else {
                            tabla.put(jugador, puntuación);
                        }
                    }
                    break;

                case 2:
                    System.out.println("---Mejor puntuación.---");
                    record = 0; // Reinicia el valor
                    for (String i : tabla.keySet()) {
                        if (tabla.get(i) > record) {
                            record = tabla.get(i);
                        }
                    }
                    System.out.println("La mejor puntuación es: " + record);
                    break;

                case 3:
                    System.out.println("---Promedio puntuación.---");
                    sumatorio = 0; // Reinicia el sumatorio
                    for (String i : tabla.keySet()) {
                        sumatorio += tabla.get(i);
                    }
                    System.out.println("El promedio es de " + sumatorio / tabla.size() + " puntos.");
                    break;

                case 4:
                    System.out.println("---Puntuaciones---");
                    System.out.println(tabla);
                    break;
                case 5:
                    System.out.println("---Adiós---");
                    seguir = 0;
                    break;

                default:
                    System.out.println("Introduce una opción válida(1-4)");
                    break;

            }

        } while (seguir == 1);
    }
}
