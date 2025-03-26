package Programación.booleanos;

public class ejercicio3 {
    public static void main(String[] args) {
        /* Escribe un programa que reciba siete argumentos en este orden:
            Primer apellido
            Segundo apellido
            Nombre primer hijo
            Nombre segundo hijo
            Nombre tercer hijo
            Nombre del padre
            Nombre de la madre
            Y saque por pantalla los datos de toda la familia: una línea
            por cada miembro. */
        String primerAp = args[0];
        String segundoAp = args[1];
        String nombreHijo1 = args[2];
        String nombreHijo2 = args[3];
        String nombrePa = args[4];
        String nombreMa = args[5];

        System.out.println("El primer hijo se llama: " + nombreHijo1 + " " + primerAp + " " + segundoAp + ".");
        System.out.println("El segundo hijo se llama: " + nombreHijo2 + " " + primerAp + " " + segundoAp + ".");
        System.out.println("El padre se llama: " + nombrePa + " " +  primerAp + " " +  segundoAp + ".");
        System.out.println("La madre se llama: " + nombreMa + " " + primerAp + " " + segundoAp + ".");
        
        
    }
}
