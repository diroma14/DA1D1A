package ficheros;

import java.io.*;

public class ejercicio3 {
    public static void main(String[] args) throws IOException {
        File primerArchivo = new File("ficheros/f1.txt");
        File segundoArchivo = new File("ficheros/f2.txt");
        File tercerArchivo = new File("ficheros/f3.txt");

        FileWriter writer = new FileWriter(tercerArchivo);
        BufferedReader reader1 = new BufferedReader(new FileReader(primerArchivo));
        BufferedReader reader2 = new BufferedReader(new FileReader(segundoArchivo));

        String mayor;
        String menor;

        boolean seguir = true;

        while (seguir) {
            String caracter1 = reader1.readLine();
            String caracter2 = reader2.readLine();

            if (caracter1 == null || caracter2 == null) {
                break;
            }


            if (caracter1.compareTo(caracter2) < 0) {
                mayor = caracter1;
                menor = caracter2;
            } else {
                mayor = caracter2;
                menor = caracter1;
            }

            writer.write(mayor + "\n");
            writer.write(menor + "\n");
            System.out.println("Escribiendo: " + mayor + " | " + menor); // Para verificar lo que estamos escribiendo

        }

        reader1.close();
        reader2.close();
        writer.close();

    }
}
