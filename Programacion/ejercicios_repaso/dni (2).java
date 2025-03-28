package Programación.ejercicios_repaso;
import java.util.Scanner;

public class dni {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el DNI.");
        String DNI = sc.nextLine();

        int numero = 0; /* Variable que guarda la cantidad de números del DNI */
        int letra = 0; /* Variable que guarda la cantidad de letras del DNI */
        int posicion_letra = 0; /* Guarda la posición de la última letra detectada */
        String numeroDNI = ""; /* Guarda el número del DNI */
        int intNumeroDNI = 0; /* Solo se usa so hay 8 numeros y 1 letra, en la linea 51 */
        String letraDNI = ""; /* Guarda la letra del DNI */
        int restoDNI = 0;

        System.out.println(DNI);
        sc.close();

        /* Comprobar si el DNI tiene 9 caracteres */
        if (DNI.length() == 9) {
            System.out.println("Hay nueve caracteres.");

            /*
             * Recorre todo el DNI y cada vez que encuentra un número le suma 1 a la
             * variable "numero"
             */
            for (int i = 0; i < DNI.length(); i++) {
                if (Character.isDigit(DNI.charAt(i))) {
                    numero++;
                }
                if (Character.isLetter(DNI.charAt(i))) {
                    letra++;
                    posicion_letra = i;
                }
            }

            /* Comprueba si hay 8 números y 1 letra */
            if ((numero != 8) && (letra != 1)) {
                System.out.println("El DNI debe de tener 8 números y 1 letra.");
                System.out.println("Introduciste " + numero + " numeros y " + letra + " letras.");
            }

            /* Comprueba que la letra esté en la última posición */
            if (posicion_letra != 8) {
                System.out.println("La letra debe de ser el último caracter.");
                System.out.println("La pusiste en el caracter número " + (posicion_letra + 1) + ".");
            } else { /* Si la letra está en la última posición guarda los números del DNI. */
                numeroDNI = DNI.substring(0, 8);
                letraDNI = DNI.substring(8, 9);

                System.out.println("Los números del DNI introducido son: " + numeroDNI);
                System.out.println("La letra del DNI introducida es: " + letraDNI);

                intNumeroDNI = Integer.valueOf(numeroDNI); // Convierte la String de los números del DNI a numeros enteros
            }

            /* Comprobar letra del DNI */
            restoDNI = (intNumeroDNI % 23);

            /* Comprobar letra DNI */
            switch (restoDNI) {
                case 0:
                    if (letraDNI.equals("T")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser T.");
                    }
                    break;
                case 1:
                    if (letraDNI.equals("R")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser R.");
                    }
                    break;
                case 2:
                    if (letraDNI.equals("W")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser W.");
                    }
                    break;
                case 3:
                    if (letraDNI.equals("A")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser A.");
                    }
                    break;
                case 4:
                    if (letraDNI.equals("G")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser G.");
                    }
                    break;
                case 5:
                    if (letraDNI.equals("M")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser M.");
                    }
                    break;
                case 6:
                    if (letraDNI.equals("Y")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser Y.");
                    }
                    break;
                case 7:
                    if (letraDNI.equals("F")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser F.");
                    }
                    break;
                case 8:
                    if (letraDNI.equals("P")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser P.");
                    }
                    break;
                case 9:
                    if (letraDNI.equals("D")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser D.");
                    }
                    break;
                case 10:
                    if (letraDNI.equals("X")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser X.");
                    }
                    break;
                case 11:
                    if (letraDNI.equals("B")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser B.");
                    }
                    break;
                case 12:
                    if (letraDNI.equals("N")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser N.");
                    }
                    break;
                case 13:
                    if (letraDNI.equals("J")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser J.");
                    }
                    break;
                case 14:
                    if (letraDNI.equals("Z")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser Z.");
                    }
                    break;
                case 15:
                    if (letraDNI.equals("S")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser S.");
                    }
                    break;
                case 16:
                    if (letraDNI.equals("Q")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser Q.");
                    }
                    break;
                case 17:
                    if (letraDNI.equals("V")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser V.");
                    }
                    break;
                case 18:
                    if (letraDNI.equals("H")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser H.");
                    }
                    break;
                case 19:
                    if (letraDNI.equals("L")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser L.");
                    }
                    break;
                case 20:
                    if (letraDNI.equals("C")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser C.");
                    }
                    break;
                case 21:
                    if (letraDNI.equals("K")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser K.");
                    }
                    break;
                case 22:
                    if (letraDNI.equals("E")) {
                        System.out.println("DNI válido");
                    } else {
                        System.out.println("La letra debería ser E.");
                    }
                    break;
                default:
                    System.out.println("DNI no válido.");
                    break;
            }

        } else {
            System.out.println("El DNI debe de tener nueve caracteres.");
        }
    }
}
