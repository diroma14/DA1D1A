package CentroEducativo;

import java.util.ArrayList;

public class CentroEducativo {

    // Atributos
    private ArrayList<Alumno> alumnos; // Ahora almacena objetos Alumno

    // Constructor
    public CentroEducativo(ArrayList<Alumno> alumnos) {
        this.alumnos = new ArrayList<>(alumnos);
    }

    // Getters y setters
    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = new ArrayList<>(alumnos);
    }

    // Métodos
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public int contarAprobados() {
        int aprobados = 0;
        for (Alumno a : alumnos)
            if (a.aprobo())
                aprobados++;
        return aprobados;

    }
}
