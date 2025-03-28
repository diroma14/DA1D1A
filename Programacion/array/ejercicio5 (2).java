package array;

import java.util.ArrayList;
import java.util.Collections;

public class ejercicio5 {
    public static void main(String[] args) {

        /* Iniciar métodos */
        ArrayList<String> lista = new ArrayList<>();
        ArrayList<String> items = new ArrayList<>();

        lista.add("Patata");
        lista.add("Patata");
        lista.add("Patata");
        lista.add("Melón");
        lista.add("Manzana");

        /* Comprobar todas las palabras diferentes que hay */

        for (int j = 0; j < lista.size(); j++) {
            if (items.contains(lista.get(j))) { /* Si ya existe esa palabra en la lista imprime mensaje. */
                System.out.println("Ya conozco la palabra " + lista.get(j));
            } else { /* Si esa palabra no existe en la lista se añade */
                System.out.println("Añadiendo la palabra " + lista.get(j) + " a la lista auxiliar.");
                items.add(lista.get(j));
            }
        }

        System.out.println(items);

        /* Comprobar si se repite */

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i) + ": " + Collections.frequency(lista, items.get(i)));
        }

    }
}
