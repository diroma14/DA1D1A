package saltos;

import java.util.ArrayList;
import java.util.Random;

public class ejercicio1 {
    // 1. Escribe un programa que sume solo los números impares de un arreglo.

    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Random rd = new Random();
        int suma = 0;

        // Añadir números a la lista
        for (int i = 0; i < 20; i++) {
            numeros.add(rd.nextInt(50));
        }

        // Mostar lista
        System.out.println("Números: " + numeros);

        // Recorrer lista
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                continue;
            }
            suma = suma + numero;
        }

        System.out.println("Suma: " + suma);

    }
}
