package Excepciones;

import java.util.Scanner;

class ContraseñaCortaException extends Exception {
    public ContraseñaCortaException(String mensaje) {
        super(mensaje);
    }
}

class ContraseñaSinNumeros extends Exception {
    public ContraseñaSinNumeros(String mensaje) {
        super(mensaje);
    }
}

class ContraseñaSinCaracteres extends Exception {
    public ContraseñaSinCaracteres(String mensaje) {
        super(mensaje);
    }
}

public class ejercicio8 {
    public static void validadContraseña(String contraseña) throws ContraseñaCortaException, ContraseñaSinNumeros, ContraseñaSinCaracteres {
        boolean longitud = false;
        boolean numeros = false;
        boolean caracteres = false;

        // Largo de la contraseña
        if (contraseña.length() <= 8) {
            throw new ContraseñaCortaException("Contraseña demasiado corta.");
        } else {
            longitud = true;
        }

        // Números en la contraseña
        for (int i = 0; i < contraseña.length(); i++) {
            if (Character.isDigit(contraseña.charAt(i))) {
                numeros = true;
            }
        }
        if (!numeros) {
            throw new ContraseñaSinNumeros("La contraseña no tiene números.");
        }

        //caracteres especiales
        for(int i = 0; i < contraseña.length();i ++){
            if(!Character.isLetterOrDigit(contraseña.charAt(i))){
                caracteres = true;
            }
        }
        if(!caracteres){
            throw new ContraseñaSinCaracteres("La contraseña no tiene caracteres especiales.");
        }

        //Sout
        if(longitud && numeros && caracteres){
            System.out.println("Contraseña válida.");
        }
    }

    public static void main(String[] args) {
        String contraseña;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una contraseña:");
        contraseña = sc.nextLine();
        
        try {
            validadContraseña(contraseña);
        } catch (ContraseñaCortaException e) {
            System.out.println("La contraseña es demasiado corta.");
        }catch (ContraseñaSinCaracteres e) {
            System.out.println("La contraseña no tiene caracteres especiales.");
        }catch (ContraseñaSinNumeros e) {
            System.out.println("La contraseña no tiene números.");
        }finally{
            sc.close();
        }

    }
}
