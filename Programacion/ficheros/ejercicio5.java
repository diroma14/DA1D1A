package ficheros;

import java.io.*;
import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String nombre;
        String apellido1;
        String apellido2;
        Boolean seguir = true;
        String opcion;
        File archivo = new File("ficheros/nombres.txt");

        FileWriter writer = new FileWriter(archivo,true);
        if (archivo.exists()) {
            archivo.delete();
        }

        while (seguir) {
            System.out.println("Introduce el nombre:");
            nombre = sc.nextLine();
            System.out.println("Introduce el primer apellido:");
            apellido1 = sc.nextLine();
            System.out.println("Introduce el segundo apellido:");
            apellido2 = sc.nextLine();

            writer.write(nombre + " " + apellido1 + " " + apellido2 + "\n");

            System.out.println("¿Quieres seguir? S/N:");
            opcion = (sc.nextLine()).toUpperCase();

            if (opcion.equals("N")) {
                seguir = false;
            }
        }

        sc.close();
        writer.close();
    }
}
