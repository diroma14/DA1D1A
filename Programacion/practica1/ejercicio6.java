package Programación.practica1;

public class ejercicio6 {
    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("No he recibido ningún argumento.");
        } if (args.length > 4) {
            System.out.println("Demasiados argumentos.");
        } else {
            System.out.println("He recibido " + args.length + " argumentos.");
        }
    }
}
