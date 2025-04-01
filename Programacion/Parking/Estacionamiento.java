package Parking;

import java.util.ArrayList;
import java.util.List;

public class Estacionamiento {
    private String nombre;
    private List<Vehiculo> plazas;

    public Estacionamiento(String nombre, int numPlazas) {
        this.nombre = nombre;
        this.plazas = new ArrayList<>();
        for (int i = 0; i < numPlazas; i++) {
            plazas.add(null);
        }
    }

    public boolean estacionarVehiculo(Vehiculo vehiculo) {
        for (int i = 0; i < plazas.size(); i++) {
            if (plazas.get(i) == null) {
                if (vehiculo instanceof Aparcable) { // Verificar si el vehículo es aparcable
                    plazas.set(i, vehiculo);
                    System.out.println("Vehículo estacionado en la plaza " + (i + 1));
                    return true;
                } else {
                    System.out.println("El vehículo no puede ser estacionado.");
                    return false;
                }
            }
        }
        System.out.println("No hay plazas disponibles.");
        return false;
    }

    public void sacarVehiculo() {
        for (int i = 0; i < plazas.size(); i++) {
            if (plazas.get(i) != null) {
                System.out.println("Se ha retirado el vehículo con matrícula: " + plazas.get(i).getMatricula());
                plazas.set(i, null);
                return;
            }
        }
        System.out.println("No hay vehículos estacionados.");
    }

    public void mostrarPlazas() {
        System.out.println("Estado de las plazas:");
        for (int i = 0; i < plazas.size(); i++) {
            System.out.println("Plaza " + (i + 1) + ": " + (plazas.get(i) == null ? "Libre" : "Ocupada por " + plazas.get(i).getMatricula()));
        }
    }
}




