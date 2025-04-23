package ficheros;

import java.io.*;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        File archivo = new File("ficheros/parrafo.txt");
        FileWriter writer = new FileWriter("ficheros/parrafo.txt");
        String texto;
        Boolean seguir = true;

        // Crear fichero
        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getPath());
            } else {
                System.out.println("El archivo ya existe.");
            }

        } catch (Exception e) {
            System.out.println("Error al crear el archivo.");
        }

        // escribir hasta que escriba FIN
        if (archivo.exists()) {
            while (seguir) {
                System.out.println("Introduce el texto para escribrir en el fichero (Para terminar escribe FIN)");
                texto = sc.nextLine();
                if (texto.equals("FIN")) {
                    System.out.println("Has terminado de escribir.");
                    seguir = false;
                } else {
                    writer.write(texto + "\n");
                }

            }
        }

        sc.close();
        writer.close();

    }
}
