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

    public String compararApellidos(String apellido1, String apellido2) {
        int tamaño = Math.min(apellido1.length(), apellido2.length());

        for (int i = 0; i < tamaño; i++) {
            char caracter1 = apellido1.charAt(i);
            char caracter2 = apellido2.charAt(i);

            // Devuelve el apellido mayor
            if (caracter1 > caracter2) {
                return apellido1;
            } else if (caracter1 < caracter2) {
                return apellido2;
            }
        }

        // Si son iguales en cuanto al los caracteres del menor duelve el apellido más
        // largo
        if (apellido1.length() > apellido2.length()) {
            return apellido1;
        } else if (apellido1.length() < apellido2.length()) {
            return apellido2;
        }

        // Si los dos sos idénticos duelve el primero
        return apellido1;
    }

    public void ordenarAlumnos() {
        ArrayList<Alumno> alumnosOrdenados = new ArrayList<>();

        String apellidoMenor = alumnos.get(0).getApellido1();
        int posicion = 0;

        for (int i = 0; i < alumnos.size(); i++) {

            for (int j = 0; j < alumnos.size(); j++) {
                apellidoMenor = compararApellidos(apellidoMenor, alumnos.get(j).getApellido2());

            }

            for (int k = 0; k < alumnos.size(); k++) {
                if (apellidoMenor == alumnos.get(k).getApellido1()) {
                    posicion = k;
                }
            }

            alumnosOrdenados.add(alumnos.get(posicion));
            alumnos.remove(posicion);

            i--;
        }
        alumnos = alumnosOrdenados;
    }

}
