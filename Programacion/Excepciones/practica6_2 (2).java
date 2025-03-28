package Excepciones;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class practica6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = 0;
        int B = 0;
        int C;
        int intentos = 0;
        int numero;
        boolean seguir = true;

        while (seguir) {
            try {
                System.out.println("Introduce el límite superior (menor a 500):");
                A = sc.nextInt();

                if (A >= 500) {
                    System.out.println("Error: El límite superior debe ser menor a 500.");

                } else {
                    try {
                        System.out.println("Introduce el límite inferior (mayor a 0):");
                        B = sc.nextInt();

                        if (B <= 0) {
                            System.out.println("Error: El límite inferior debe ser mayor a 0.");
                        } else {
                            if (A > B) {
                                seguir = false;
                            } else {
                                System.out.println("Error: El límite superior debe ser mayor que el inferior.");
                            }
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Error: Debes introducir un número entero.");
                        sc.next();
                    } catch (NoSuchElementException e) {
                        System.out.println("Error: No se ha introducido ningún elemento.");
                        sc.next();
                    } catch (IllegalStateException e) {
                        System.out.println("Error: El escaner está cerrado.");
                        sc.next();
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero.");
                sc.next();
            } catch (NoSuchElementException e) {
                System.out.println("Error: No se ha introducido ningún elemento.");
                sc.next();
            } catch (IllegalStateException e) {
                System.out.println("Error: El escaner está cerrado.");
                sc.next();
            }
        }

        C = (int) (B + Math.random() * (A - B + 1));

        System.out.println("Número aleatorio generado entre " + B + " y " + A + ": " + C);
        System.out.println();

        // Adivinanza
        seguir = true;

        while (seguir) {
            try {
                System.out.println("Introduce el número que crees que es:");
                numero = sc.nextInt();
                if (numero > A || numero < B) {
                    System.out.println("El número está fuera del rango establecido.(" + A + "," + A + ")");
                }
                if (numero == C) {
                    System.out.println("El número era " + C + " .");
                    System.out.println("Has ganado con " + intentos + " intentos, felicidades.");
                    break;
                } else if (C > numero) {
                    System.out.println("El número es mayor al que has introducido.");
                    intentos += 1;
                } else {
                    System.out.println("El número es menor al que has introducido.");
                    intentos += 1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero.");
                intentos += 1;
                sc.next();
            } catch (NoSuchElementException e) {
                System.out.println("Error: No se ha introducido ningún elemento.");
                sc.next();
            } catch (IllegalStateException e) {
                System.out.println("Error: El escaner está cerrado.");
                sc.next();
            }
        }

        sc.close();
    }
}
