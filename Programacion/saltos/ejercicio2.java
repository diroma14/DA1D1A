package saltos;

import java.util.ArrayList;
import java.util.Random;

public class ejercicio2 {
    public static void main(String[] args) {
        // Declaraciones
        ArrayList<Integer> numeros = new ArrayList<>();
        Random rd = new Random();
        String resultado;

        // Crear lista
        for (int i = 0; i < 5; i++) {
            numeros.add(rd.nextInt(10));
        }
        System.out.println("Lista: " + numeros);

        // Llamar a buscar2 y asignar el resultado
        resultado = buscar2(numeros);
        System.out.println("Resultado: " + resultado);
    }

    private static String buscar2(ArrayList<Integer> numeros) {
        for (int numero : numeros) {
            if (numero == 2) {
                return "Número encontrado";
            }
        }
        return "Número no encontrado";
    }
}
