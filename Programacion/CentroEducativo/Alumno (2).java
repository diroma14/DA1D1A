package CentroEducativo;

import java.util.ArrayList;

public class Alumno implements Aprobable {
    // atributos
    private String DNI;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private ArrayList<Examen> examenes = new ArrayList<>();

    // constructor
    public Alumno(String dNI, String nombre, String apellido1, String apellido2, ArrayList<Examen> examenes) {
        DNI = dNI;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.examenes = examenes;
    }

    // Setters y getters

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(ArrayList<Examen> examenes) {
        this.examenes = examenes;
    }

    // Métodos

    public void agregarExamen(Examen examen) {
        examenes.add(examen);
    }

    @Override
    public boolean aprobo() {
        for (int i = 0; i < examenes.size(); i++) {
            if (!((Aprobable) examenes.get(i)).aprobo()) {
                return false;
            }
        }
        return true;
    }

}
