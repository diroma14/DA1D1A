package ficheros;

import java.io.*;

public class ejercicio7 {
    public static void main(String[] args) throws IOException {
        File archivo = new File("ficheros/nombres.txt");
        BufferedReader reader = new BufferedReader((new FileReader(archivo)));

        String linea;
        int lineas = 0;
        int mediaNombre = 0;
        int mediaApellido1 = 0;
        int mediaApellido2 = 0;
        while ((linea = reader.readLine()) != null) {
            String partes[] = linea.split(" ");
            lineas += 1;
            mediaNombre += partes[0].length();
            mediaApellido1 += partes[1].length();
            mediaApellido2 += partes[2].length();
        }
        System.out.println("Media Nombres: " + mediaNombre / lineas);
        System.out.println("Media Primer Apellido: " + mediaApellido1 / lineas);
        System.out.println("Media Segundo Apellido: " + mediaApellido2 / lineas);

        reader.close();
    }
}
