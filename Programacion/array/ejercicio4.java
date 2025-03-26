package array;

import java.util.ArrayList;
import java.util.Random;

public class ejercicio4 {
    public static void main(String[] args) {
        /* Iniciar métodos */
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        /* Generar 8 números */

        for (int i = 0; i < 8; i++) {
            Integer numero = random.nextInt((10) + 1);
            numeros.add(numero);
        }

        /* Mostrar números */

        System.out.println("");
        System.out.println("Números: " + numeros);

        /* Comprobar si se repiten */

        for (int i = numeros.size() - 1; i >= 0; i--){
            int comprobar = numeros.get(i);
            
            for(int j = i+1;j < numeros.size(); j++) {
                if (numeros.get(j)==(comprobar)){
                    System.out.println("Se repite el número " + comprobar);
                    System.out.println("Se va a borrar el número " + comprobar);
                    numeros.remove(j);
                    j--;
                }
            }
            
        }

        /* Mostrar la lista nueva */

        System.out.println("Numeros: " + numeros);
    }
}
