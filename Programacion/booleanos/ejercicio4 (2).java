package Programación.booleanos;

public class ejercicio4 {
    public static void main(String[] args) {
        /* Escribe un programa que reciba los siguientes argumentos, en este orden:
            Nº de clientes
            Nº de empleados
            Nº de sillas
            Nº de mesas
            Nº de contratos
            Nº de reclamaciones
            Y saque por pantalla:
            Nº de personas
            Nº de muebles
            Nº de documentos */
        
            int clientes = Integer.valueOf(args[0]);
            int empleados = Integer.valueOf(args[1]);
            int sillas = Integer.valueOf(args[2]);
            int mesas = Integer.valueOf(args[3]);
            int contratos = Integer.valueOf(args[4]);
            int reclamaciones = Integer.valueOf(args[5]);

            System.out.println("La cantidad total de personas es de " + (clientes + empleados) + ".");
            System.out.println("La cantidad total de muebles es de " + (sillas + mesas) + ".");
            System.out.println("La cantidad total de documentos es de " + (contratos + reclamaciones + "."));
        
        
    }
}
