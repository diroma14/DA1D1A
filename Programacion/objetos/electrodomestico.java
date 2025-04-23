package objetos;

public class electrodomestico {
    // Atributos
    private Double precio;
    private String color;
    private char consumo;
    private Integer peso;

    // Variables
    private static Double precio_defecto = 100.0;
    private String color_defecto = "Blanco";
    private char consumo_defecto = 'F';
    private Integer peso_defecto = 5;

    // Constructores

    // Constructor por defecto
    public electrodomestico() {
        this.precio = precio_defecto;
        this.color = color_defecto;
        this.consumo = consumo_defecto;
        this.peso = peso_defecto;
    }

    // Constructor precio y peso
    public electrodomestico(Double precio, Integer peso) {
        this.precio = precio;
        this.peso = peso;
        this.color = color_defecto;
        this.consumo = consumo_defecto;
    }

    // Constructor normal

    public electrodomestico(Double precio, String color, char consumo, Integer peso) {
        this.precio = precio;
        comprobarConsumo(consumo);
        comprobarColor(color);
        this.peso = peso;
    }

    // Setters y getters
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumo() {
        return consumo;
    }

    public void setConsumo(char consumo) {
        this.consumo = consumo;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    // Métodos
    public void comprobarConsumo(char letra) {
        if (letra != 'A' && letra != 'B' && letra != 'C' && letra != 'D' && letra != 'E' && letra != 'F') {
            System.out.println("Consumo incorrecto. Usando consumo por defecto: " + consumo_defecto);
            this.consumo = consumo_defecto; // Asignar el valor por defecto
        }
    }

    public void comprobarColor(String color) {
        if (color.equals("Blanco") ||
                color.equals("Negro") ||
                color.equals("Rojo") ||
                color.equals("Azul") ||
                color.equals("Gris")) {
        } else {
            System.out.println("Color incorrecto. Usando color por defecto: " + color_defecto);
            this.color = color_defecto; // Asignar color por defecto
        }
    }

    public void precioFinal(char consumo, Double precio, Integer peso) {
        System.out.println("Precio original: " + precio);
        // Comprobar letra
        switch (consumo) {
            case 'A':
                precio = precio + 100;
                break;
            case 'B':
                precio = precio + 80;
                break;
            case 'C':
                precio = precio + 60;
                break;
            case 'D':
                precio = precio + 50;
                break;
            case 'E':
                precio = precio + 30;
                break;
            case 'F':
                precio = precio + 10;
                break;
            default:
                precio = precio + 0;
                break;
        }

        System.out.println("Precio + consumo: " + precio);

        // Comprobar peso

        if (peso >= 0 && peso < 20) {
            precio = precio + 10;
        } else if (peso >= 20 && peso < 50) {
            precio = precio + 50;
        } else if (peso >= 50 && peso < 80) {
            precio = precio + 80;
        } else if (peso >= 80) {
            precio = precio + 100;
        }

        System.out.println("Precio final: " + precio);

    }

    public static void main(String[] args) {
        electrodomestico lavadora = new electrodomestico();

        electrodomestico microondas = new electrodomestico(precio_defecto, "Morado", 'X', 12);

        microondas.precioFinal(microondas.consumo, microondas.precio, microondas.peso);
    }
}
