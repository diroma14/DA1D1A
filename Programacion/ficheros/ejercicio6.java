package ficheros;

import java.io.*;

public class ejercicio6 {
    public static void main(String[] args) throws IOException {
        File archivo =  new File("ficheros/nombres.txt");
        BufferedReader reader = new BufferedReader((new FileReader(archivo)));

        String linea;
        int lineas = 0;
        int media = 0;
        while ((linea = reader.readLine()) != null) {
            System.out.println(linea + " " + linea.length());
            lineas += 1;
            media += linea.length();
        }
        System.out.println(media/lineas);
    }
}
