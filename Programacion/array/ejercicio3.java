package array;

import java.util.ArrayList;
import java.util.Random;

public class ejercicio3 {
    public static void main(String[] args) {
        /* Iniciar métodos */
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        /* Generar 8 números */

        for (int i = 0; i < 8; i++) {
            Integer numero = random.nextInt((100) + 1);
            numeros.add(numero);
        }

        /* Mostrar números */

        System.out.println("Números: " + numeros);

        /* Comprobar si es menor a 5 y borrarlo */
        
        for (int i = numeros.size() - 1; i >= 0; i--){
            if (numeros.get(i) < 5) {
                System.out.println( numeros.get(i) + " es menor que 5, se va a borrar de la lista." );
               numeros.remove(numeros.get(i)); 
            }
        }
         /* Mostrar números con los borrados */
        System.out.println("Números: " + numeros);


    }
}
