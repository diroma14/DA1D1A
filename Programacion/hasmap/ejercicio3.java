package hasmap;

import java.util.HashMap;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        /* Iniciar métodos y variables */
        HashMap<String, Integer> inventario = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        Integer seguir = 1;
        String producto = "";
        Integer cantidad = 0;

        /* Lista inventada */
        inventario.put("teclados", 10);
        inventario.put("ratones", 2);
        inventario.put("pantallas", 5);
        inventario.put("cables de red", 3);
        inventario.put("cascos", 4);
        inventario.put("sillas", 1);

        /* Menú */

        do {
            System.out.println();
            System.out.println("---Menu---");
            System.out.println("1. Agregar productos.");
            System.out.println("2. Vender productos.");
            System.out.println("3. Mostrar inventario.");
            System.out.println("4. Verificar si hay un producto agotado.");
            System.out.println("5. Salir.");
            System.out.println("-------");
            System.out.println();
            System.out.println("Introduce una opción:");
            Integer opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("---Agregar productos---");
                    System.out.println("Introduce el producto a agregar.");
                    sc.nextLine();
                    producto = sc.nextLine().toLowerCase();
                    System.out.println("Introduce la cantidad a añadir.");
                    cantidad = sc.nextInt();
                    /* Primero comprueba si no existe, si no existe se le añade con cantidad de 0 */
                    if (inventario.containsKey(producto)) {
                        inventario.put(producto, (inventario.get(producto) + cantidad));
                    } else {
                        inventario.put(producto, cantidad);
                    }
                    break;

                case 2:
                    System.out.println("---Vender productos---");
                    System.out.println("Introduce el producto a vender");
                    sc.nextLine();
                    producto = sc.nextLine().toLowerCase();
                    /* Comprueba si existe el producto, si no existe saca del bucle */
                    if (inventario.containsKey(producto)) {
                        System.out.println("Introduce la cantidad a vender.");
                        cantidad = sc.nextInt();
                        /* Comprueba si se puede hacer la resta */
                        if (inventario.get(producto) - cantidad < 0) {
                            System.out.println("No hay suficiente inventario de ese producto.");
                        } else {
                            inventario.put(producto, (inventario.get(producto) - cantidad));
                            System.out.println("Venta realizada.");
                        }
                    } else {
                        System.out.println("El producto que has escrito no existe.");
                    }

                    break;

                case 3:
                    System.out.println("---Mostrar inventario---");
                    System.out.println(inventario);
                    break;

                case 4:
                    System.out.println("---Verificar si hay un producto agotado---");
                    for (String i : inventario.keySet()) { // Iterar sobre las claves del HashMap
                        if (inventario.get(i) == 0) { // Si la cantidad es 0, el producto está agotado
                            System.out.println("El producto " + i + " está agotado.");
                        }else{
                            System.out.println("No hay ningún producto agotado.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("---Salir---");
                    seguir = 0;
                    break;

                default:
                    System.out.println();
                    System.out.println("Introduce una opción válida.");
                    break;
            }
        } while (seguir == 1);
    }
}
