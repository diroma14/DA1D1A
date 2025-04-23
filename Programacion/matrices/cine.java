package matrices;

import java.util.Scanner;

public class cine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int alto = 5;
        int ancho = 10;
        int[][] cine = new int[alto][ancho];

        // Inicializar la matriz con asientos libres (0)
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                cine[i][j] = 0;
            }
        }

        boolean estado = true;

        while (estado) {
            System.out.println("--------------------");
            System.out.println("1. Mostrar asientos.");
            System.out.println("2. Reservar asiento.");
            System.out.println("3. Cancelar reserva.");
            System.out.println("4. Salir.");
            System.out.println("--------------------");
            System.out.print("Introduce una opción: ");
            int opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println("Asientos disponibles:");
                    for (int i = 0; i < alto; i++) {
                        for (int j = 0; j < ancho; j++) {
                            System.out.print(cine[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;

                case 2:  // Reservar asiento
                    System.out.println("Introduce las coordenadas del asiento que quieres reservar.");
                    int filaReserva, columnaReserva;

                    System.out.print("Fila (1-" + alto + "): ");
                    filaReserva = sc.nextInt();
                    System.out.print("Columna (1-" + ancho + "): ");
                    columnaReserva = sc.nextInt();

                    if (filaReserva < 1 || filaReserva > alto || columnaReserva < 1 || columnaReserva > ancho) {
                        System.out.println("Posición inválida. Inténtalo de nuevo.");
                    } else if (cine[filaReserva - 1][columnaReserva - 1] == 1) {
                        System.out.println("El asiento ya está reservado.");
                    } else {
                        cine[filaReserva - 1][columnaReserva - 1] = 1;
                        System.out.println("Asiento reservado con éxito.");
                    }
                    System.out.println();
                    break;

                case 3:  // Cancelar reserva
                    System.out.println("Introduce las coordenadas del asiento cuya reserva quieres cancelar.");
                    int filaCancel, columnaCancel;

                    System.out.print("Fila (1-" + alto + "): ");
                    filaCancel = sc.nextInt();
                    System.out.print("Columna (1-" + ancho + "): ");
                    columnaCancel = sc.nextInt();

                    if (filaCancel < 1 || filaCancel > alto || columnaCancel < 1 || columnaCancel > ancho) {
                        System.out.println("Posición inválida. Inténtalo de nuevo.");
                    } else if (cine[filaCancel - 1][columnaCancel - 1] == 0) {
                        System.out.println("El asiento no estaba reservado.");
                    } else {
                        cine[filaCancel - 1][columnaCancel - 1] = 0;
                        System.out.println("Reserva cancelada con éxito.");
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Saliendo del sistema.");
                    estado = false;
                    break;

                default:
                    System.out.println("Opción incorrecta. Inténtalo de nuevo.");
                    break;
            }
        }

        sc.close(); 
    }
}
