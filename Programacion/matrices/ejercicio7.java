package matrices;
import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vector1 = new int[5];
        int[] vector2 = new int[5];
        int[] vector3 = new int[5];

        //Meter vector1
        System.out.println("Introduciendo numeros al vector1.");
        for(int i = 0; i < vector1.length;i++){
            System.out.println("Introduce un número para meter en la posición " + i + " : ");
            vector1[i] = sc.nextInt();
        }
        System.out.println();
        System.out.println("Vector 1 rellenado. Pasando a vector2.");
        //Meter vector2
        System.out.println("Introduciendo numeros al vector2.");
        for(int i = 0; i < vector2.length;i++){
            System.out.println("Introduce un número para meter en la posición " + i + " : ");
            vector2[i] = sc.nextInt();
        }
        System.out.println();
        System.out.println("Vector 2 rellenado. Calculando el vector3.");

        for(int i = 0; i < vector3.length;i++){
            vector3[i] = vector1[i] + vector2[i];
        }
        System.out.println();
        System.out.println("Vectores calculados, mostrando vectores.");
        System.out.print("Vector1: ");
        for(int i = 0;i < vector1.length;i++){
            System.out.print(vector1[i] + " ");
        }
        System.out.println();

        System.out.print("Vector2: ");
        for(int i = 0;i < vector2.length;i++){
            System.out.print(vector2[i] + " ");
        }
        System.out.println();

        System.out.print("Vector3: ");  
        for(int i = 0;i < vector3.length;i++){
            System.out.print(vector3[i] + " ");
        }
        System.out.println();

        sc.close();

    }
    
}


