package hasmap;
    import java.util.HashMap;
public class ejemplo {
    public static void main(String[] args) {
        HashMap<String, Integer> frutas = new HashMap<>();

        /*Agregar elementos al hasmap */

        frutas.put("Plátano", 14);
        frutas.put("Sandía", 3);
        frutas.put("Manzana", 23);
        frutas.put("Peras", 10);

        /* Mostrar hashmap */

        System.out.println("Frutas: " + frutas);

        /* Obtener un valor según la clave */

        System.out.println("Hay " + frutas.get("Plátano") + " plátanos");

        
    }
}
