package Parking;

import java.util.List;

public class Mantenimiento {
    private String fecha;
    private String detalle;
    private Vehiculo vehiculo;
    private List<Propietario> propietarios; // Lista de propietarios y copropietarios

    public Mantenimiento(String fecha, String detalle, Vehiculo vehiculo, List<Propietario> propietarios) {
        this.fecha = fecha;
        this.detalle = detalle;
        this.vehiculo = vehiculo;
        this.propietarios = propietarios;
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + ", Detalle: " + detalle + ", Vehículo: " + vehiculo + ", Propietarios: " + propietarios;
    }
}




