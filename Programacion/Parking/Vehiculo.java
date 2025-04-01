package Parking;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private String matricula;
    private double velocidadMaxima;
    private List<Propietario> propietarios;  // Lista de propietarios

    // Constructor
    public Vehiculo(String marca, String modelo, String matricula, double velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidadMaxima = velocidadMaxima;
        this.propietarios = new ArrayList<>();  // Inicializamos la lista de propietarios
    }

    // Método para agregar un propietario
    public void agregarPropietario(Propietario propietario) {
        if (!propietarios.contains(propietario)) {
            propietarios.add(propietario);
        }
    }

    // Método para obtener la lista de propietarios
    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Matrícula: " + matricula;
    }

    // Método abstracto para definir si el vehículo puede aparcar o no
    public abstract boolean aparco();
}





