package array;
    import java.util.ArrayList;
public class ejercicio1 {
    public static void main(String[] args) {

        /* Iniciar variables */

        Integer total = 0;
        Integer numeroActual = 0;

        /* Iniciar método */
        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);
        numeros.add(6);
        numeros.add(7);
        numeros.add(8);
        numeros.add(9);
        numeros.add(10);

        System.out.println("Números: " + numeros);

        System.out.println("La lista contiene " + numeros.size() + " numeros.");

        /* Bucle */

        for(int i=0; i< numeros.size(); i++){
            numeroActual = numeros.get(i);
            total = numeroActual + total;
        }

        System.out.println("La suma de todos los números es de: " + total);

    }
}
