import java.util.Scanner;
public class ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int numero = (int) (Math.random() * 100) + 1;
        int estado = 0; /* 0 incorrecto, 1 correcto */
        int intentos = 1;

        System.out.println("He pensado en un número entre el 1 y el 100, tienes 10 intentos para adivinarlo.");
        System.out.println(numero);
        while (estado == 0){
            System.out.println(" ");
            System.out.println("Intento número " + intentos + " ,te quedan " + (11 - intentos) + " intentos.");
            System.out.println("¿En qué numero he pensado?:");
            int opcion = sc.nextInt();
            if (opcion == numero) {
                System.out.println("Correcto, el número en el que pensé era " + numero + ".");
                System.out.println("Lo has adivinado en " + intentos + " intentos.");
                estado = 1;
            } else if (numero > opcion){
                System.out.println("El número en el que pensé es mayor, vuelve a intentarlo.");
                intentos++;
            } else if (numero < opcion) {
                System.out.println("El número en el que pensé es menor, vuelve a intentarlo.");
                intentos++;
            } 
            if (intentos == 10) {
                System.out.println("Te has quedado sin intentos.");
                System.out.println("El número en el que pensé era " + numero + ".");
                estado = 1;
            }

        }
        
        sc.close();
    }
}
