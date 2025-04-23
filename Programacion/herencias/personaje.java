public class personaje {
    private String nombre;
    private Integer ph; // Puntos de vida
    private Integer nivel;

    // Constructor
    public personaje(String nombre, Integer ph, Integer nivel) {
        this.nombre = nombre;
        this.ph = ph;
        this.nivel = nivel;
    }

    // Setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPh() {
        return ph;
    }

    public void setPh(Integer ph) {
        this.ph = ph;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    // Atacar
    public void atacar() {
        System.out.println(nombre + " realiza un ataque básico.");
    }

    // Subir de nivel
    public void subirNivel() {
        nivel++;
        ph += 20;
        System.out.println(nombre + " ha subido al nivel " + nivel + ". Nuevos PH: " + ph);
    }
}
