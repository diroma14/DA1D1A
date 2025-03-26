import java.util.Scanner;
import java.util.Random;

public class prueba {
    public static void main(String[] args) {
        /*
         * Programa una loteria: el usuario introduce 5 números del 1 al 50. Después
         * simula que el sistema saca 5 números ganadores de forma aleatoria. Constrasta
         * cuantos números
         * ha acertado el usuario.
         */

        Random rd = new Random(); /* La máquina elige un nuevo valor */
        int loteria1 = rd.nextInt(49) + 1;
        int loteria2 = rd.nextInt(49) + 1;
        int loteria3 = rd.nextInt(49) + 1;
        int loteria4 = rd.nextInt(49) + 1;
        int loteria5 = rd.nextInt(49) + 1;

        Integer numerosBien = 0;
        Integer contador = 0;

        /* Debug */

        System.out.println(loteria1);
        System.out.println(loteria2);
        System.out.println(loteria3);
        System.out.println(loteria4);
        System.out.println(loteria5);

        /* Debug */

        System.out.println("Elige el primer número.");
        Scanner sc = new Scanner(System.in);

        Integer numero1 = sc.nextInt();
        if (!(numero1 >= 1 && numero1 <= 50)) {
            System.out.println("Tienes que meter un número que esté entre 1 y 50.");
        } else {
            System.out.println("Número almacenado.");
            numerosBien++;
        }

        System.out.println("Elige el segundo número.");
        Integer numero2 = sc.nextInt();
        if (!(numero2 >= 1 && numero2 <= 50)) {
            System.out.println("Tienes que meter un número que esté entre 1 y 50.");
        } else {
            System.out.println("Número almacenado.");
            numerosBien++;
        }

        System.out.println("Elige el tercer número.");
        Integer numero3 = sc.nextInt();
        if (!(numero3 >= 1 && numero3 <= 50)) {
            System.out.println("Tienes que meter un número que esté entre 1 y 50.");
        } else {
            System.out.println("Número almacenado.");
            numerosBien++;
        }

        System.out.println("Elige el cuarto número.");
        Integer numero4 = sc.nextInt();
        if (!(numero4 >= 1 && numero4 <= 50)) {
            System.out.println("Tienes que meter un número que esté entre 1 y 50.");
        } else {
            System.out.println("Número almacenado.");
            numerosBien++;
        }

        System.out.println("Elige el quinto número.");
        Integer numero5 = sc.nextInt();
        if (!(numero5 >= 1 && numero5 <= 50)) {
            System.out.println("Tienes que meter un número que esté entre 1 y 50.");
        } else {
            System.out.println("Número almacenado.");
            numerosBien++;
        }

        if (numerosBien == 5) {
            System.out.println("");
            System.out.println("Empezando comprobación.");

            if (numero1 == loteria1) {
                contador++;
            }
            if (numero2 == loteria2) {
                contador++;
            }
            if (numero3 == loteria3) {
                contador++;
            }
            if (numero4 == loteria4) {
                contador++;
            }
            if (numero5 == loteria5) {
                contador++;
            }

            System.out.println("Acertaste " + contador + " números");
        } else {
            System.out.println("");
            System.out.println("Has introducido un número fuera de los valores permitidos, vuelve a empezar.");
        }

        if (numerosBien == 5) {
            switch (contador) {
                case 3:
                    System.out.println("Felicidades, has acertado 3 números y ganado 12 euros.");
                    break;
                case 4:
                    System.out.println("Felicidades, has acertado 4 números y ganado 120 euros.");
                    break;
                case 5:
                    System.out.println("Felicidades, has acertado 5 números y ganado 1200000 euros.");
                    break;

                default:
                    System.out.println("No te has llevado ningún premio, lo siento.");
                    break;
            }
        }

        sc.close();
    }
}
