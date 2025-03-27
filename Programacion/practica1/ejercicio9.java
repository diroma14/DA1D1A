package Programación.practica1;

import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Dime el número de mes:");
       int mes = sc.nextInt();
       System.out.println("Dime el año:");
       int año = sc.nextInt();

       int bisiesto = año%4;
       System.out.println(bisiesto);

       if (mes == 1 || mes ==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12) {
            System.out.println("El mes introducido tiene 31 días.");
       } else  if(mes ==2 && bisiesto==0) {
            System.out.println("El mes introducido tiene 29 días.");
       } else if(mes ==2 && bisiesto==1) {
        System.out.println("El mes introducido tiene 28 días.");
       } else if ( mes==4 || mes==6 || mes==9 || mes==11){
            System.out.println("El mes introducido tiene 30 días.");
       } else {
            System.out.println("El número de mes no corresponde con ninguno.");
       }
       sc.close();
    }
}