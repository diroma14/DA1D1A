package ficheros;

import java.io.*;

public class ejercicio2 {
    public static void main(String[] args) throws IOException {
        File archivoOriginal = new File("ficheros/parrafo.txt");
        File archivoSinvo = new File("ficheros/parrafoSV.txt");
        FileWriter writer = new FileWriter("ficheros/parrafoSV.txt");
        BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
        String linea;
        String sinVocales;
        
        

        if(archivoOriginal.exists()){
            //Crear fichero
            try {
                if (archivoSinvo.createNewFile()) {
                    System.out.println("Archivo creado: " + archivoSinvo.getPath());
                } else {
                    System.out.println("El archivo ya existe.");
                }
            } catch (Exception e) {
                System.out.println("Error al crear el archivo sin vocales.");
                
            }

            //Leer cada fila


            while ((linea = reader.readLine()) != null) {
                    sinVocales = linea.replaceAll("[AEIOUaeiou]", "");
                    writer.write(sinVocales + "\n");
            }

        }else{
            System.out.println("No existe el fichero original.");
        }

        reader.close();
        writer.close();
    }
}
