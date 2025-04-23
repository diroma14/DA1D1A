package saltos;

public class ejercicio3 {
    public static void main(String[] args) {

        // Declaraciones
        int num1 = 0;
        int num2 = 0;

        salir: for (num1 = 1; num1 <= 5; num1++) {
            for (num2 = 0; num2 <= 10; num2++) {
                if (num1 * num2 == 20) {
                    System.out.println("Saliendo");
                    break salir;
                }
                System.out.println(num1 + "x" + num2);
            }
        }
    }
}
