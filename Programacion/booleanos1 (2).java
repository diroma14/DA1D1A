package Programación;

public class booleanos1 {

    public static void main(String[] args){
    String a = "Tienes un total de ";
    String b = " frutas.";

    int fruta1 = Integer.valueOf(args[0]);
    int fruta2 = Integer.valueOf(args[1]);

    System.out.println(a + (fruta1+fruta2) + b);
    }
}
