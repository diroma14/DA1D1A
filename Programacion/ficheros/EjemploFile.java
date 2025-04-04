package ficheros;

import java.io.*;

public class EjemploFile {
    public static void main(String[] args) {

        try {
            File archivo = new File("C:\\Users\\Diurno\\Desktop\\Pruebas\\Pruebas.txt");

            // Borrar archivo
            if (archivo.delete()) {
                System.out.println("El archivo ha sido borrado.");
            } else {
                System.out.println("El archivo no pudo ser borrado.");
            }

            // Crear archivo
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }

            // Escritor de archivo con FileWriter
            try (FileWriter escritor = new FileWriter(archivo, true)) {
                escritor.write("\nTexto añadido.");
                System.out.println("Archivo escrito.");
            } catch (Exception e) {
                System.out.println("Error al escribir en el archivo.");
            }

            // Escritor de archivo con PrintWriter (comentado pero corregido)
            /*
            try (PrintWriter escritor = new PrintWriter(new FileWriter(archivo, true))) {
                escritor.println(123);
                escritor.println(true);
                System.out.println("Archivo escrito con PrintWriter.");
            } catch (Exception e) {
                System.out.println("Error al escribir en el archivo.");
            }
            */

            // Desplazamiento con RandomAccessFile
            

            // Lector de archivo con BufferedReader
            try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (Exception e) {
                System.out.println("Error al leer el archivo.");
            }

            // Renombrar archivo
            File archivoRenombrado = new File("C:\\Users\\Diurno\\Desktop\\Pruebas\\Pruebas2.txt");
            try {
                if (archivo.renameTo(archivoRenombrado)) {  
                    System.out.println("Archivo " + archivo.getName() + " renombrado a " + archivoRenombrado.getName());
                } else {
                    System.out.println("No se pudo renombrar el archivo.");
                }
            } catch (Exception e) {
                System.out.println("Error al renombrar el archivo");
            }

            // Mover archivo
            File archivoMover = new File("C:\\Users\\Diurno\\Desktop\\Pruebas\\Mover\\Pruebas.txt");
            try {
                if (archivo.renameTo(archivoMover)) {  
                    System.out.println("Archivo " + archivo.getName() + " cambiado de ruta");
                } else {
                    System.out.println("No se pudo mover el archivo.");
                }
            } catch (Exception e) {
                System.out.println("Error al mover el archivo");
            }

        } catch (Exception e) {
            System.out.println("Error al crear el archivo.");
        }
    }
}

