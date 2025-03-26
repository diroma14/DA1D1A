package Excepciones;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Division {
    public static double division(int a,int b){
        if(b == 0){
            throw new IllegalArgumentException("El denominador no puede ser 0");
        }
        double c = a/b;
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numerador = 0, denominador = 0;
        boolean seguir = true;
        boolean dividir = false;
        int contador = 0;

        while(seguir){
            if (contador == 3) {
                seguir = false; 
                contador = 0;
                System.out.println("Intentos superados.");
            }
            try{
                System.out.println("Introduce un numero entero: ");
                numerador = sc.nextInt();
                seguir = false; 
                contador = 0;
            }catch(InputMismatchException e){
                System.out.println("El tipo de variable introducido no corresponde a Integer");
                sc.next();
                contador += 1;
            }catch(NoSuchElementException e){
                System.out.println("No hay elemento de entrada");
                sc.next();
                contador += 1;
            }catch(IllegalStateException e){
                System.out.println("Se ha intentado utilizar un scanner cerrado");
                sc.next();
                contador += 1;
            }
        }

        seguir = true;

        while(seguir){
            if (contador == 3) {
                seguir = false; 
                contador = 0;
                System.out.println("Intentos superados.");
            }
            try{
                System.out.println("Introduce un numero entero: ");
                denominador = sc.nextInt(); 
                seguir = false;
                contador = 0;
                dividir = true;
            }catch(InputMismatchException e){
                System.out.println("El tipo de variable introducido no corresponde a Integer");
                sc.next();
                contador += 1;
            }catch(NoSuchElementException e){
                System.out.println("No hay elemento de entrada");
                sc.next();
                contador += 1;
            }catch(IllegalStateException e){
                System.out.println("Se ha intentado utilizar un scanner cerrado");
                sc.next();
                contador += 1;
            }
        }

        if(dividir){
            try{
                double resultado = division(numerador,denominador); 
                System.out.println(resultado);   
            }catch(IllegalArgumentException e){
                System.out.println("El denominador no puede ser 0");
            }
        }
        
    }
}
