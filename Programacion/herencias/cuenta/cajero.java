package cuenta;

import java.util.ArrayList;
import java.util.Scanner;

public class cajero {
    // Lista para almacenar las cuentas
    ArrayList<Cuenta> cuentas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // Crear cuenta
    public void crearCuenta() {
        System.out.println("--------");
        System.out.println("Creando nueva cuenta.");
        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce tu primer apellido: ");
        String apellido1 = sc.nextLine();
        System.out.print("Introduce tu segundo apellido: ");
        String apellido2 = sc.nextLine();
        System.out.print("Introduce tu NIF (8 dígitos): ");
        Integer NIF = sc.nextInt();
        sc.nextLine();
    
        System.out.print("Introduce un PIN de 4 dígitos para la cuenta: ");
        String pin = sc.nextLine();
    
        Persona cliente = new Persona(nombre, apellido1, apellido2, NIF);
    
        System.out.println("Selecciona el tipo de cuenta:");
        System.out.println("1. Cuenta Corriente");
        System.out.println("2. Cuenta de Ahorro");
        int tipoCuenta = sc.nextInt();
        sc.nextLine();
    
        System.out.print("Introduce el saldo inicial: ");
        double saldo = sc.nextDouble();
    
        System.out.println("Introduce el número de cuenta:");
        Integer numeroCuenta = sc.nextInt();
    
        if (tipoCuenta == 1) {
            CuentaCorriente cuenta = new CuentaCorriente(numeroCuenta, saldo, cliente, pin);
            cuentas.add(cuenta);
            System.out.println("Cuenta Corriente creada con éxito.");
        } else if (tipoCuenta == 2) {
            System.out.print("Introduce el saldo mínimo necesario: ");
            double saldoMinimo = sc.nextDouble();
            System.out.print("Introduce el interés inicial (%): ");
            double interes = sc.nextDouble();
            CuentaAhorro cuenta = new CuentaAhorro(numeroCuenta, saldo, cliente, pin, interes, saldoMinimo);
            cuentas.add(cuenta);
            System.out.println("Cuenta de Ahorro creada con éxito.");
        } else {
            System.out.println("Tipo de cuenta no válido.");
        }
    }
    
    

    // Iniciar sesión
    public Cuenta iniciarSesion() {
        System.out.println("--------");
        System.out.println("Iniciar sesión.");
        System.out.print("Introduce tu NIF: ");
        Integer nif = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce tu PIN: ");
        String pin = sc.nextLine();
    
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getCliente().getNIF().equals(nif) && cuenta.getPin().equals(pin)) {
                System.out.println("Inicio de sesión exitoso.");
                return cuenta;
            }
        }
        System.out.println("NIF o PIN incorrectos.");
        return null;
    }

    //Método transferir 
    public void transferirDinero(Cuenta origen) {
        System.out.print("Introduce el número de cuenta destino: ");
        int cuentaDestino = sc.nextInt();
        System.out.print("Introduce la cantidad a transferir: ");
        double cantidad = sc.nextDouble();

        for (Cuenta destino : cuentas) {
            if (destino.getNumeroCuenta().equals(cuentaDestino)) {
                if (origen.getSaldo() >= cantidad) {
                    origen.retirar(cantidad);
                    destino.ingresar(cantidad);
                    System.out.println("Transferencia realizada con éxito.");
                } else {
                    System.out.println("Saldo insuficiente para realizar la transferencia.");
                }
                return;
            }
        }
        System.out.println("Cuenta destino no encontrada.");
    }

    //Menú de opciones
    public void menuUsuario(Cuenta cuenta) {
        int opcion;
        do {
            System.out.println("--- Menú de usuario ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Transferir dinero");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Tu saldo actual es: " + cuenta.getSaldo() + "€.");
                    break;
                case 2:
                    System.out.print("Introduce la cantidad a ingresar: ");
                    double ingreso = sc.nextDouble();
                    cuenta.ingresar(ingreso);
                    break;
                case 3:
                    System.out.print("Introduce la cantidad a retirar: ");
                    double retiro = sc.nextDouble();
                    cuenta.retirar(retiro);
                    break;
                case 4:
                    transferirDinero(cuenta);
                    break;
                case 5:
                    System.out.println("Saliendo de tu cuenta...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 5);
    }

    // Main
    public static void main(String[] args) {
        cajero cajero = new cajero();
        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("--- Menú Principal ---");
            System.out.println("1. Crear nueva cuenta");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    cajero.crearCuenta();
                    break;
                case 2:
                    Cuenta cuenta = cajero.iniciarSesion();
                    if (cuenta != null) {
                        cajero.menuUsuario(cuenta);
                    }
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        } while (opcion != 3);

        sc.close();
    }

    
}
