package hasmap;

import java.util.HashMap;

public class ejercicio1 {
    public static void main(String[] args) {

        HashMap<String, Integer> clase = new HashMap<>();

        Double num = 0.0;

        /* Agregar elementos al hasmap */

        clase.put("Manolo", 10);
        clase.put("Andrea", 3);
        clase.put("Sara", 9);
        clase.put("Pablo", 5);

        /* Obtener calificación de un estudiante por su nombre */

        System.out.println("Manolo ha sacado un " + clase.get("Manolo"));

        /* Mostrar todos los estudiantes y sus notas */

        System.out.println();
        System.out.println(clase);

        /* Calcular promedio nota */

        for(Integer nota : clase.values()){ /* Por cada vuelta se suma cada nota a la variable "num" */
            num = num + nota;
           /*  System.out.println(num); */
        }

        num=num/clase.size();       /* Divide el sumatorio de las notas entre los alumnos de la clase */

        System.out.println("La media de la clase es: " + num);


        /*Comprobar si un usuario en específico está registrado */

        if (clase.containsKey("Manolo")) {
            System.out.println("Manolo está registrado.");
        }else {
            System.out.println("Manolo no está registrado.");
        }


        /* Eliminar a un estudiante en específico */
        
        System.out.println("Eliminando a Pablo.");
        clase.remove("Pablo");
        System.out.println(clase);
    }

}
