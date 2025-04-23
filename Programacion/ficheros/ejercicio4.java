package ficheros;

import java.io.*;
import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) throws IOException {
        File archivo = new File("ficheros/parrafo.txt");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la clave para codificar(un número):");
        int clave = sc.nextInt();

        BufferedReader reader = new BufferedReader((new FileReader(archivo)));
        FileWriter writer = new FileWriter("ficheros/codificado.txt");

        int caracter;
        while ((caracter = reader.read()) != -1) {
            if (caracter == 32) {
                writer.write(" ");
            }else if(caracter == 10) {
                writer.write((char)10);
            }else{
                writer.write((char) caracter + clave);
            }

        }

        sc.close();
        reader.close();
        writer.close();
    }
}
