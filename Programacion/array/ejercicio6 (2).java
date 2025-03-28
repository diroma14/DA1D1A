package array;

import java.util.ArrayList;
import java.util.Random;

public class ejercicio6 {
    public static void main(String[] args) {
        /* Iniciar métodos */
        ArrayList<Integer> numeros1 = new ArrayList<>();
        ArrayList<Integer> numeros2 = new ArrayList<>();
        ArrayList<Integer> numeros3 = new ArrayList<>();
        Random random = new Random();

        /* Generar 8 números para la primera lista */
        for (int i = 0; i < 8; i++) {
            Integer numero = random.nextInt(10) + 1; // Números entre 1 y 10
            numeros1.add(numero);
        }

        /* Generar 8 números para la segunda lista */
        for (int i = 0; i < 8; i++) {
            Integer numero = random.nextInt(10) + 1; // Números entre 1 y 10
            numeros2.add(numero);
        }

        /* Mostrar números */
        System.out.println("");
        System.out.println("Números1: " + numeros1);
        System.out.println("Números2: " + numeros2);

        /* Comprobar primera lista */
        for (int i = 0; i < numeros1.size(); i++) {
            if (numeros2.contains(numeros1.get(i))) {
                if (!numeros3.contains(numeros1.get(i))) { // Verificar si no está ya en numeros3
                    System.out.println("El número " + numeros1.get(i) + " de la lista 1 aparece en la lista 2.");
                    numeros3.add(numeros1.get(i)); // Añadir si no está repetido
                } else {
                    System.out.println("El número " + numeros1.get(i) + " ya está en numeros3, no se añade.");
                }
            }
        }

        /* Comprobar segunda lista */
        for (int i = 0; i < numeros2.size(); i++) {
            if (numeros1.contains(numeros2.get(i))) {
                if (!numeros3.contains(numeros2.get(i))) { // Verificar si no está ya en numeros3
                    System.out.println("El número " + numeros2.get(i) + " de la lista 2 aparece en la lista 1.");
                    numeros3.add(numeros2.get(i)); // Añadir si no está repetido
                } else {
                    System.out.println("El número " + numeros2.get(i) + " ya está en numeros3, no se añade.");
                }
            }
        }

        /* Imprimir lista final */
        System.out.println("");
        System.out.println("Números que se repiten: " + numeros3);
    }
}
