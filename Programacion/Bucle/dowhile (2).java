package Programación.Bucle;

public class dowhile {
    public static void main(String[] args) {
        int i = 0;
        do {
            System.out.println(args[i]);
            i++;
        }while (i < args.length && !(args[i].equals("FIN")));
        
    }
}
