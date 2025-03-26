package CentroEducativo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear exámenes
        ExamenEscrito examen1 = new ExamenEscrito("2024-03-10", 80, 7);
        ExamenEscrito examen2 = new ExamenEscrito("2024-03-15", 100, 5); // No aprobado
        ExamenOral examen3 = new ExamenOral("2024-03-20", "Suficiente");
        ExamenOral examen4 = new ExamenOral("2024-03-22", "Insuficiente"); // No aprobado

        // Lista de exámenes de alumnos
        ArrayList<Examen> examenesAlumno1 = new ArrayList<>();
        examenesAlumno1.add(examen1);
        examenesAlumno1.add(examen3); // Aprobado

        ArrayList<Examen> examenesAlumno2 = new ArrayList<>();
        examenesAlumno2.add(examen2);
        examenesAlumno2.add(examen4); // No aprobado

        // Crear alumnos
        Alumno alumno1 = new Alumno("12345678A", "Carlos", "Pérez", "Gómez", examenesAlumno1);
        Alumno alumno2 = new Alumno("87654321B", "María", "López", "Díaz", examenesAlumno2);

        // Lista de alumnos
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);

        // Crear centro educativo
        CentroEducativo centro = new CentroEducativo(listaAlumnos);

        // Prueba del método contarAprobados
        System.out.println("Número de alumnos que aprobaron todo: " + centro.contarAprobados());

        System.out.println(listaAlumnos);

        
    }
}

