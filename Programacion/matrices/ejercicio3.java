package matrices;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int media = 0;
        int alto = 0;
        int bajo = 10;

        int[] notas = new int[5];

        //Leer 5 notas
        for(int i = 0; i < notas.length;i++){
            System.out.println("Ingresa una nota (entre 0 y 10): ");
            notas[i] = sc.nextInt();
        }
        System.out.println();

        //Calcular la media
        for(int i = 0; i < notas.length;i++){
            media = media + notas[i];
        }
        media = media/notas.length;

        //Nota más alta
        for(int i = 0; i < notas.length; i++){
            if (notas[i] > alto) {
                alto = notas[i];
            }
        }

        //Nota más baja
        for(int i = 0; i < notas.length;i++){
            if(notas[i] < bajo){
                bajo = notas[i];
            }
        }

        //Imprimir notas
        System.out.println("--Notas--");
        for(int i = 0; i < notas.length;i++){
            System.out.println("Nota " + i + 1 + " : " + notas[i]);
        }
        System.out.println("Nota más alta: " + alto);
        System.out.println("Nota más baja: " + bajo);
        System.out.println("Media: " + media);

        sc.close();
    }
}
