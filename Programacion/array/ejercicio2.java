package array;


import java.util.ArrayList;
import java.util.Random;


public class ejercicio2 {
    public static void main(String[] args) {
        /* Iniciar métodos */
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        /* Generar 10 números */

        for(int i=0; i< 10; i++){
            Integer numero = random.nextInt((100)+1);
            numeros.add(numero);
        }

        /* Mostrar la lista */

        System.out.println("Números: " + numeros);

        /* Recorrer lista para encontrar pares */

        System.out.println("Números pares de la lista: ");
        for(int i=0; i< numeros.size(); i++){
            if (numeros.get(i)%2 == 0) {
                System.out.println(numeros.get(i));
            }
        }
    }
}
