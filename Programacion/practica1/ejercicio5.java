package Programación.practica1;

public class ejercicio5 {
    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("No he recibido ningún argumento.");
        } else {
            System.out.println("He recibido " + args.length + " argumentos.");
        }
    }
}
