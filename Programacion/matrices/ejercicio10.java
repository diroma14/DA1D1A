package matrices;
import java.util.Scanner;
import java.util.Random;

public class ejercicio10 {
    public static void main(String[] args) {
        Random rn = new Random();
        int[][] matriz = new int[5][5];

        //Cargar matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rn.nextInt(10) + 1; 
            }
        }

        //Mostrar matriz
        for(int i = 0; i< matriz.length;i++){
            for(int j = 0; j < matriz[i].length;j++){
                System.out.println(matriz[i][j]);
            }
        }

    }
}
