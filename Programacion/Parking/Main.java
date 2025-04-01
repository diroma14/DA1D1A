package Parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Vehiculo> vehiculos = new ArrayList<>();
    private static List<Propietario> propietarios = new ArrayList<>();
    private static List<Mantenimiento> mantenimientos = new ArrayList<>();
    private static Estacionamiento estacionamiento;

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\nMenú Principal");
            System.out.println("1. Crear estacionamiento");
            System.out.println("2. Agregar vehículo");
            System.out.println("3. Registrar propietario");
            System.out.println("4. Asignar vehículo a propietario");
            System.out.println("5. Estacionar vehículo");
            System.out.println("6. Retirar vehículo");
            System.out.println("7. Listar vehículos");
            System.out.println("8. Listar propietarios");
            System.out.println("9. Agregar mantenimiento a vehículo");
            System.out.println("10. Listar mantenimientos");
            System.out.println("11. Listar plazas de estacionamiento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    crearEstacionamiento();
                    break;

                case 2:
                    agregarVehiculo();
                    break;

                case 3:
                    registrarPropietario();
                    break;

                case 4:
                    asignarVehiculoAPropietario();
                    break;

                case 5:
                    estacionarVehiculo();
                    break;

                case 6:
                    retirarVehiculo();
                    break;

                case 7:
                    listarVehiculos();
                    break;

                case 8:
                    listarPropietarios();
                    break;

                case 9:
                    agregarMantenimiento();
                    break;

                case 10:
                    listarMantenimientos();
                    break;

                case 11:
                    listarPlazasEstacionamiento();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void crearEstacionamiento() {
        System.out.print("Ingrese el nombre del estacionamiento: ");
        String nombre = scanner.nextLine();
        System.out.print("Número de plazas disponibles: ");
        int numPlazas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        estacionamiento = new Estacionamiento(nombre, numPlazas);
        System.out.println("Estacionamiento creado exitosamente.");
    }

    private static void agregarVehiculo() {
        System.out.print("Seleccione el tipo de vehículo (1: Coche, 2: Moto): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Velocidad Máxima: ");
        double velocidadMaxima = scanner.nextDouble();
        scanner.nextLine();

        Vehiculo vehiculo;
        if (tipo == 1) {
            System.out.print("Número de puertas: ");
            int nPuertas = scanner.nextInt();
            scanner.nextLine();
            vehiculo = new Coche(marca, modelo, matricula, velocidadMaxima, nPuertas);
        } else {
            System.out.print("Cilindradas: ");
            int cilindradas = scanner.nextInt();
            scanner.nextLine();
            vehiculo = new Moto(marca, modelo, matricula, velocidadMaxima, cilindradas);
        }

        vehiculos.add(vehiculo);
        System.out.println("Vehículo agregado correctamente.");
    }

    private static void registrarPropietario() {
        System.out.print("DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        propietarios.add(new Propietario(dni, nombre, apellidos));
        System.out.println("Propietario registrado.");
    }

    private static void asignarVehiculoAPropietario() {
        if (propietarios.isEmpty() || vehiculos.isEmpty()) {
            System.out.println("No hay propietarios o vehículos registrados.");
            return;
        }

        System.out.println("Seleccione un vehículo:");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculos.get(i).getMatricula());
        }
        int vehiculoIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        Vehiculo vehiculoSeleccionado = vehiculos.get(vehiculoIndex);

        boolean agregarMas = true;
        while (agregarMas) {
            System.out.println("Seleccione un propietario para asignar al vehículo:");
            for (int i = 0; i < propietarios.size(); i++) {
                System.out.println((i + 1) + ". " + propietarios.get(i).getNombre());
            }
            int propietarioIndex = scanner.nextInt() - 1;
            scanner.nextLine();
            Propietario propietarioSeleccionado = propietarios.get(propietarioIndex);

            propietarioSeleccionado.agregarVehiculo(vehiculoSeleccionado);
            vehiculoSeleccionado.agregarPropietario(propietarioSeleccionado);
            System.out.println("Propietario asignado correctamente.");

            System.out.print("¿Desea agregar otro copropietario a este vehículo? (S/N): ");
            String respuesta = scanner.nextLine().trim().toUpperCase();
            agregarMas = respuesta.equals("S");
        }
    }

    private static void estacionarVehiculo() {
        if (estacionamiento == null) {
            System.out.println("Debe crear un estacionamiento primero.");
            return;
        }

        System.out.println("Seleccione un vehículo para estacionar:");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculos.get(i).getMatricula());
        }
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (estacionamiento.estacionarVehiculo(vehiculos.get(index))) {
            System.out.println("Vehículo estacionado con éxito.");
        }
    }

    private static void retirarVehiculo() {
        if (estacionamiento == null) {
            System.out.println("No hay estacionamiento registrado.");
            return;
        }
        estacionamiento.sacarVehiculo();
    }

    private static void listarMantenimientos() {
        if (mantenimientos.isEmpty()) {
            System.out.println("No hay mantenimientos registrados.");
            return;
        }
        System.out.println("Lista de mantenimientos:");
        for (Mantenimiento m : mantenimientos) {
            System.out.println(m);
        }
    }

    private static void agregarMantenimiento() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        System.out.println("Seleccione un vehículo para mantenimiento:");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculos.get(i).getMatricula());
        }
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Fecha del mantenimiento: ");
        String fecha = scanner.nextLine();
        System.out.print("Detalle: ");
        String detalle = scanner.nextLine();

        Mantenimiento mantenimiento = new Mantenimiento(fecha, detalle, vehiculos.get(index), vehiculos.get(index).getPropietarios());
        mantenimientos.add(mantenimiento);
        System.out.println("Mantenimiento agregado.");
    }

    private static void listarPlazasEstacionamiento() {
        if (estacionamiento == null) {
            System.out.println("No hay estacionamiento registrado.");
            return;
        }
        estacionamiento.mostrarPlazas();
    }

    private static void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        System.out.println("Lista de vehículos:");
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }

    private static void listarPropietarios() {
        if (propietarios.isEmpty()) {
            System.out.println("No hay propietarios registrados.");
            return;
        }
        System.out.println("Lista de propietarios:");
        for (Propietario p : propietarios) {
            System.out.println(p);
        }
    }
}





