package objetos;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Pokemon {
    private String nombre;
    private String tipo;
    private ArrayList<String> movimientos;
    private int hpMax;
    private int hp;
    private int ataque;
    private int defensa;
    private int velocidad;
    private int nivel;
    private String estado;

    // Constructor
    public Pokemon(String nombre, String tipo, ArrayList<String> movimientos, int hpMax, int ataque, int defensa, int velocidad, int nivel, String estado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.movimientos = movimientos;
        this.hpMax = hpMax;
        this.hp = hpMax; // HP actual inicia como el máximo
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.nivel = nivel;
        this.estado = estado;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public ArrayList<String> getMovimientos() {
        return movimientos;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getHp() {
        return hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getNivel() {
        return nivel;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Pokemon: " + nombre + "\n" +
                "Tipo: " + tipo + "\n" +
                "Movimientos: " + movimientos + "\n" +
                "HP: " + hp + "/" + hpMax + "\n" +
                "Ataque: " + ataque + "\n" +
                "Defensa: " + defensa + "\n" +
                "Velocidad: " + velocidad + "\n" +
                "Nivel: " + nivel + "\n" +
                "Estado: " + estado;
    }

    public static HashMap<String, Pokemon> inicializarPokemons() {
        HashMap<String, Pokemon> pokemons = new HashMap<>();

        pokemons.put("Charizard", new Pokemon("Charizard", "Fuego/Volador",
                new ArrayList<>(List.of("Lanzallamas", "Vuelo", "Garra Dragón", "Golpe Aéreo")),
                360, 293, 280, 328, 100, "Neutro"));

        pokemons.put("Blastoise", new Pokemon("Blastoise", "Agua", 
                new ArrayList<>(List.of("Hidrobomba", "Cabezazo", "Rayo Hielo", "Cascada")),
                362, 291, 328, 280, 100, "Neutro"));

        pokemons.put("Venusaur", new Pokemon("Venusaur", "Planta/Veneno", 
                new ArrayList<>(List.of("Rayo Solar", "Látigo Cepa", "Bomba Lodo", "Síntesis")),
                364, 289, 291, 284, 100, "Neutro"));

        pokemons.put("Pikachu", new Pokemon("Pikachu", "Eléctrico", 
                new ArrayList<>(List.of("Impactrueno", "Rayo", "Ataque Rápido", "Pantalla de Luz")),
                274, 229, 196, 306, 100, "Neutro"));

        pokemons.put("Machamp", new Pokemon("Machamp", "Lucha", 
                new ArrayList<>(List.of("Golpe Karate", "Demolición", "Sumisión", "Puño Dinámico")),
                384, 350, 284, 207, 100, "Neutro"));

        pokemons.put("Gengar", new Pokemon("Gengar", "Fantasma/Veneno", 
                new ArrayList<>(List.of("Bola Sombra", "Psíquico", "Rayo", "Hipnosis")),
                324, 261, 156, 350, 100, "Neutro"));

        pokemons.put("Alakazam", new Pokemon("Alakazam", "Psíquico", 
                new ArrayList<>(List.of("Confusión", "Rayo", "Psíquico", "Recuperación")),
                314, 271, 156, 372, 100, "Neutro"));

        pokemons.put("Dragonite", new Pokemon("Dragonite", "Dragón/Volador", 
                new ArrayList<>(List.of("Furia Dragón", "Puño Trueno", "Rayo Hielo", "Vuelo")),
                386, 300, 284, 284, 100, "Neutro"));

        pokemons.put("Arcanine", new Pokemon("Arcanine", "Fuego", 
                new ArrayList<>(List.of("Lanzallamas", "Mordisco", "Colmillo Ígneo", "Velocidad Extrema")),
                384, 290, 250, 317, 100, "Neutro"));

        pokemons.put("Snorlax", new Pokemon("Snorlax", "Normal", 
                new ArrayList<>(List.of("Descanso", "Golpe Cuerpo", "Terremoto", "Rayo")),
                524, 350, 350, 174, 100, "Neutro"));

        pokemons.put("Lapras", new Pokemon("Lapras", "Agua/Hielo", 
                new ArrayList<>(List.of("Surf", "Rayo Hielo", "Cuerpo Pesado", "Canto")),
                464, 295, 295, 246, 100, "Neutro"));

        pokemons.put("Jolteon", new Pokemon("Jolteon", "Eléctrico", 
                new ArrayList<>(List.of("Rayo", "Pantalla de Luz", "Doble Equipo", "Ataque Rápido")),
                334, 240, 196, 394, 100, "Neutro"));

        pokemons.put("Flareon", new Pokemon("Flareon", "Fuego", 
                new ArrayList<>(List.of("Lanzallamas", "Giro Fuego", "Mordisco", "Colmillo Ígneo")),
                334, 394, 178, 215, 100, "Neutro"));

        pokemons.put("Vaporeon", new Pokemon("Vaporeon", "Agua", 
                new ArrayList<>(List.of("Surf", "Acua Cola", "Rayo Hielo", "Deseo")),
                464, 270, 240, 246, 100, "Neutro"));

        pokemons.put("Gyarados", new Pokemon("Gyarados", "Agua/Volador", 
                new ArrayList<>(List.of("Hidrobomba", "Cola Dragón", "Terremoto", "Triturar")),
                394, 350, 284, 287, 100, "Neutro"));

        pokemons.put("Exeggutor", new Pokemon("Exeggutor", "Planta/Psíquico", 
                new ArrayList<>(List.of("Rayo Solar", "Psíquico", "Hipnosis", "Bomba Lodo")),
                384, 295, 250, 176, 100, "Neutro"));

        pokemons.put("Rhydon", new Pokemon("Rhydon", "Roca/Tierra", 
                new ArrayList<>(List.of("Terremoto", "Golpe Roca", "Cabezazo", "Cola Férrea")),
                414, 394, 350, 166, 100, "Neutro"));

        pokemons.put("Kabutops", new Pokemon("Kabutops", "Roca/Agua", 
                new ArrayList<>(List.of("Corte", "Surf", "Golpe Roca", "Hidropulso")),
                324, 350, 300, 276, 100, "Neutro"));

        pokemons.put("Aerodactyl", new Pokemon("Aerodactyl", "Roca/Volador", 
                new ArrayList<>(List.of("Hiperrayo", "Garra Dragón", "Golpe Aéreo", "Rayo")),
                334, 350, 240, 394, 100, "Neutro"));

        return pokemons;
    }

    public static void main(String[] args) {
        HashMap<String, Pokemon> pokemons = inicializarPokemons();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona un Pokémon de la lista:");
        for (String nombre : pokemons.keySet()) {
            System.out.println("- " + nombre);
        }

        System.out.print("Ingresa el nombre del Pokémon que deseas: ");
        String eleccion = scanner.nextLine();

        Pokemon elegido = pokemons.get(eleccion);

        if (elegido != null) {
            System.out.println("Has elegido:");
            System.out.println(elegido);
        } else {
            System.out.println("El Pokémon ingresado no está en la lista.");
        }

        scanner.close();
    }
}
