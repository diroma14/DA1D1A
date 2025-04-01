package Parking;

import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private String dni;
    private String nombre;
    private String apellidos;
    private List<Vehiculo> vehiculos;
    private List<Propietario> copropietarios;

    public Propietario(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.vehiculos = new ArrayList<>();
        this.copropietarios = new ArrayList<>();
    }

    public List<Propietario> getCopropietarios() {
        return copropietarios;
    }  

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    public void agregarCopropietario(Propietario copropietario) {
        copropietarios.add(copropietario);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " (DNI: " + dni + ")";
    }
}




