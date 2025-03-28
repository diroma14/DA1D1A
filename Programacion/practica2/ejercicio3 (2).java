import java.util.Scanner;
public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime cuantos números vas a introducir:");
        

        int i = sc.nextInt();
        int vuelta = 1;
        int mayor = 0;
        int menor = 0;
        int igual = 0;

        while (vuelta <= i) {
            System.out.println("Dime el número " + vuelta + ":");
            int numero = sc.nextInt();
            if (numero > 0) {
                mayor++;
            } if (numero < 0) {
                menor++;
            } if (numero == 0) {
                igual++;
            }
            vuelta++;
        }
        System.out.println("Hay " + mayor + " números mayores que 0.");
        System.out.println("Hay " + menor + " números menores que 0.");
        System.out.println("Hay " + igual + " números iguales que 0.");

        sc.close();
    }
}
