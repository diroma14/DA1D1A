package hasmap;

import java.util.Scanner;
import java.util.HashMap;

public class ejercicio2 {
    public static void main(String[] args) {

        /* Iniciar métodos y variables */
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> diccionario = new HashMap<>();
        int palabras = 0;
        int pos1 = 0;

        /*Introducir frase */
        System.out.println("Introduce un texto:");
        String texto = sc.nextLine().toLowerCase();
        sc.close();

    

        /* Recorrer texto */
        for (int i = 0; i <= texto.length(); i++) {
            /* Detectar fin de palabra o fin del texto */
            if (i == texto.length() || texto.charAt(i) == ' ' || texto.charAt(i) == ',' || texto.charAt(i) == '.') {
                if (pos1 < i) { // Asegurar que haya algo entre pos1 e i
                    String palabra = texto.substring(pos1, i);
                    palabras++;
                    /* Actualizar el diccionario */
                    if (diccionario.containsKey(palabra)) {
                        diccionario.put(palabra, diccionario.get(palabra) + 1);
                    } else {
                        diccionario.put(palabra, 1);
                    }
                }
                pos1 = i + 1; // Actualizar inicio de la siguiente palabra
            }
        }

        /* Mostrar resultados */
        System.out.println("Hay " + palabras + " palabras.");
        System.out.println(diccionario);
    }
}