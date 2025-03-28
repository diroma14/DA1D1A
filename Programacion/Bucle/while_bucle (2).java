package Programación.Bucle;

public class while_bucle {
    public static void main(String[] args) {
        int i = 0;
        while(i < args.length && !(args[i].equals("FIN"))) {
            System.out.println(args[i]);
            i++;
        }
    }
}
