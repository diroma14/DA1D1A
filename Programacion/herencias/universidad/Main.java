package universidad;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Persona> listaPersonas = new ArrayList<>();

        //Direcciones
        Direccion direccion1 = new Direccion("Calle Principal", "Ciudad A",123 , "País A");
        Direccion direccion2 = new Direccion("Avenida Secundaria", "Ciudad B", 456, "País B");

        //Estudiantes
        Estudiante estudiante1 = new Estudiante(1, "Nobita", "Nobi", "Nobi", 1824, direccion1);
        Estudiante estudiante2 = new Estudiante(2, "Carlos", "Arévalo", "NoArévalo", 777, direccion1);

        //Profesores

        Profesor profesor1 = new Profesor(1, "Jose", "Luis", "Ajedrez", 202122, direccion2);
        Profesor profesor2 = new Profesor(2, "Julio", "Musculito", "Máximo", 664423, direccion1);

        //Añadir personas
        listaPersonas.add(estudiante1);
        listaPersonas.add(estudiante2);
        listaPersonas.add(profesor1);
        listaPersonas.add(profesor2);

        //Mostrar personas
        System.out.println("Lista de personas en la universidad:");
        for (Persona persona : listaPersonas) {
            System.out.println(persona.getNombre());
        }


    }
}
