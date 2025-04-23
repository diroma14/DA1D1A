package matrices;

import java.util.Random;

public class ejercicio1 {
    public static void main(String[] args) {
        Random rn = new Random(); 
        int[] matriz = new int[10];

        //Rellenar matriz
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = rn.nextInt(10) + 1;
        }

        for(int i = 0; i < matriz.length; i++){
            System.out.println(matriz[i] + " = Elemento de índice -> " + i +  " Cuadrado -> " + (Math.pow(matriz[i], 2)) + " Cubo -> " + (Math.pow(matriz[i], 3)));
        }
    }
}

