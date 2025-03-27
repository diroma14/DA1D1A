public class ejercicio1 {
    public static void main(String[] args) {
        int num = 1;
         
        while (num<1000) {
            if (num%2 == 0) {
                 System.out.println("El número :" + num + " es par.");
                 num++;
            }else {
                num++;
            }
        }
    }
}
