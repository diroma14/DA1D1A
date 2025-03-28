import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        // Inicia el escáner para recibir entradas del usuario
        Scanner sc = new Scanner(System.in);

        // Variables para almacenar las opciones y los números ingresados
        int opcion = 0;
        double num1 = 0;
        double num2 = 0;
        double num = 0;
        int seguir = 1; // Controla si el menú se sigue mostrando

        // Bucle principal para mostrar el menú mientras el usuario quiera continuar
        do {
            // Muestra el menú de opciones en pantalla
            System.out.println("\n\nMenú:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Resto de la división");
            System.out.println("6. Verificar si es par");
            System.out.println("7. Salir");
            System.out.println("Elige una opción (1-7):");

            opcion = sc.nextInt(); // Recibe la opción del usuario y verifica que sea un número entero

            // Procesa la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("\n-----Has decidido sumar.-----");
                    System.out.println("Introduce el primer número:");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo número:");
                    num2 = sc.nextDouble();
                    num = num1 + num2; // Realiza la suma
                    System.out.println("\nEl resultado de la suma es " + num);
                    esperarTresSegundos();
                    break;

                case 2:
                    System.out.println("\n-----Has decidido restar.-----");
                    System.out.println("Introduce el primer número:");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo número:");
                    num2 = sc.nextDouble();
                    num = num1 - num2; // Realiza la resta
                    System.out.println("\nEl resultado de la resta es " + num);
                    esperarTresSegundos();
                    break;

                case 3:
                    System.out.println("\n-----Has decidido multiplicar.-----");
                    System.out.println("Introduce el primer número:");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo número:");
                    num2 = sc.nextDouble();
                    num = num1 * num2; // Realiza la multiplicación
                    System.out.println("\nEl resultado de la multiplicación es " + num);
                    esperarTresSegundos();
                    break;

                case 4:
                    System.out.println("\n-----Has decidido dividir.-----");
                    System.out.println("Introduce el primer número:");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo número:");
                    num2 = sc.nextDouble();
                    num = num1 / num2; // Realiza la división
                    System.out.println("\nEl resultado de la división es " + num);
                    esperarTresSegundos();
                    break;

                case 5:
                    System.out.println("\n-----Has decidido ver el resto de una división.-----");
                    System.out.println("Introduce el primer número:");
                    num1 = sc.nextDouble();
                    System.out.println("Introduce el segundo número:");
                    num2 = sc.nextDouble();
                    num = num1 % num2; // Calcula el resto
                    System.out.println("\nEl resto de la división es " + num);
                    esperarTresSegundos();
                    break;

                case 6:
                    System.out.println("\n-----Has decidido ver si un número es par.-----");
                    System.out.println("Introduce el número:");
                    num1 = sc.nextDouble();
                    num = num1 % 2; // Calcula el módulo para verificar si es par
                    System.out.println(num == 0 ? "\nEl número es par." : "\nEl número es impar.");
                    esperarTresSegundos();
                    break;

                case 7:
                    System.out.println("\n-----Has decidido salir del menú.-----");
                    esperarTresSegundos();
                    seguir = 0; // Actualiza la variable para salir del bucle
                    break;

                default:
                    System.out.println("\n-----Has introducido una opción inexistente...-----");
                    esperarTresSegundos();
                    seguir = 0; // Sale del bucle ya que la opción es inválida
                    break;
            }

        } while (seguir == 1);

        sc.close(); // Cierra el escáner
    }

    // Método para esperar 3 segundos
    private static void esperarTresSegundos() {
        try {
            Thread.sleep(3000); // Pausa de 3 segundos
            System.out.print("\033[H\033[2J"); // Código para limpiar la pantalla
            System.out.flush();
        } catch (InterruptedException e) {
            System.out.println("Error en la espera"); // Muestra un error si ocurre una interrupción
        }
    }
}
