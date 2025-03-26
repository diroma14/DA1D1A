package matrices;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cadena = new String[5];

        for (int i = 0; i < cadena.length; i++) {
            System.out.println("Ingresa una cadena: ");
            cadena[i] = sc.nextLine();
        }

        String[] cadenaInversa = new String[5];

        int j = 0;
        for (int i = 4; i >= 0; i--){
            cadenaInversa[j] = cadena[i];
            j++;
        }

        for(int i = 0; i < cadenaInversa.length;i++){
            System.out.println(cadenaInversa[i]);
        }

        sc.close();
    }

}
