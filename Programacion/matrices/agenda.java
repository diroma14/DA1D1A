package matrices;

import java.util.HashMap;
import java.util.Scanner;

public class agenda {
    public static void main(String[] args) {
        // Agregar contacto
        // Buscar contacto
        // Eliminar contacto
        // Mostra contactos
        HashMap<String, Integer> agenga = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        agenga.put("Pedro", 2334);
        agenga.put("Julia", 4421);

        boolean estado = true;
        int opcion;
        String nombre;
        int numero;

        while (estado) {
            System.out.println("1.Agregar contacto.");
            System.out.println("2:Buscar contacto.");
            System.out.println("3.Eliminar contacto.");
            System.out.println("4.Mostrar contactos.");
            System.out.println("5.Salir.");
            System.out.print("Elije una opción: ");
            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.println();
                    System.out.println("Agregar contacto.");
                    System.out.print("Introduce el nombre del contacto: ");
                    sc.nextLine();
                    nombre = sc.nextLine();
                    System.out.print("Introduce el número del contacto: ");
                    numero = sc.nextInt();
                    agenga.put(nombre, numero);
                    System.out.println("Contacto " + nombre + " con número " + numero + " creado con éxito.");
                    System.out.println();
                    break;

                case 2:
                    System.out.println();
                    System.out.println("Buscar contacto.");
                    System.out.print("Introduce el nombre del contacto a buscar: ");

                    sc.nextLine();
                    nombre = sc.nextLine();

                    if (agenga.containsKey(nombre)) {
                        System.out.println("Se ha encontrado el contacto.");
                        System.out.println("Número: " + agenga.get(nombre));
                    } else {
                        System.out.println("No se ha encontrado el contacto.");
                    }
                    System.out.println();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("Eliminar contacto.");
                    System.out.print("Introduce el nombre del contacto: ");

                    sc.nextLine();
                    nombre = sc.nextLine();

                    if (agenga.containsKey(nombre)) {
                        System.out.println("Se ha encontrado el contacto.");
                        System.out.println("Se va a eliminar el contacto " + nombre + ".");
                        agenga.remove(nombre);
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("No se ha encontrado el contacto.");
                    }
                    System.out.println();

                    break;

                case 4:
                    System.out.println(agenga);

                    break;
                case 5:

                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
