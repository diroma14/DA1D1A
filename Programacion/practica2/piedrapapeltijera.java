import java.util.Scanner;
import java.util.Random;
public class piedrapapeltijera {
    public static void main(String[] args) {
        
        int usuario = 0;
        Scanner sc = new Scanner(System.in);
        int ronda = 1;
        int seguir = 1; /* 1 Seguir , 0 No seguir */
        int vMaquina = 0;
        int vUsuario = 0;
        
        
        
        
        do {
            System.out.println(" ");
            System.out.println("Ronda número: " + ronda); /* Se indica el número de ronda y se hace el piedra papel o tijera */
            
            Random rd = new Random(); /* La máquina elige un nuevo valor */
            int maquina = rd.nextInt(3); /* 0 - Piedra, 1 - Papel, 2 - Tijera */
            System.out.println(maquina); /* Se escribe el valor de la máquina */

            System.out.println("Piedra(0), papel(1) o tijera(2)."); /* Se pide el valor al usuario */
            usuario = sc.nextInt();

            if (usuario == maquina) {
                System.out.println("Empate.");
            } else if ((usuario == 0 && maquina == 2) || // Piedra gana a Tijera
                       (usuario == 1 && maquina == 0) || // Papel gana a Piedra
                       (usuario == 2 && maquina == 1)) { // Tijera gana a Papel
                System.out.println("¡Ganaste!");
                vUsuario++; /*Se le asigna una victoria al usuario */
            } else {
                System.out.println("¡Gané!");
                vMaquina++; /* Se le asigna una victoria a la máquina */
            }
            
            System.out.println("¿Quieres otra ronda?(Pon 0 si no quires seguir o 1 si quieres seguir.)");
            seguir = sc.nextInt(); /* Se le asigna el nuevo valor a seguir */
            ronda++; /* La ronda aumenta en uno */
        }while(seguir==1);

        System.out.println(" ");
        System.out.println("He ganado " + vMaquina + " veces, tú lo has hecho " + vUsuario + " veces. GG...");

        sc.close();
        
    }    
}
