package saltos;

import java.util.Random;

public class ejercicio4 {
    public static void main(String[] args) {
        // Declaraciones
        Random rd = new Random();
        int numero = 0;

        // Crear lista
        for (int i = 0; i < 100; i++) {
            numero = (rd.nextInt(100) + 1);
            if (numero%13==0) {
                System.out.println("Divisible entre 13.");
                break;
            }
            System.out.println(numero);
        }
    }
}
