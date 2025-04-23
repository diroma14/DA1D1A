package objetos;

public class Coche {

    // Atributos
    private String modelo;
    private Integer velocidadMaxima;
    private Integer potenciaMotor;
    private Boolean encendido;
    private Integer velocidadActual;

    // Constructor
    public Coche(String modelo, Integer velocidadMaxima, Integer potenciaMotor) {
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.potenciaMotor = potenciaMotor;
        this.encendido = false;
        this.velocidadActual = 0; // Inicializamos la velocidad a 0
    }

    // Getters y Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(Integer velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public Integer getPotenciaMotor() {
        return potenciaMotor;
    }

    public void setPotenciaMotor(Integer potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public Boolean getEncendido() {
        return encendido;
    }

    public Integer getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(Integer velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    // Método acelerar
    public void acelerar(Integer velocidadDeseada) {
        if (!encendido) {
            System.out.println("El coche está apagado, no se puede acelerar.");
            return;
        }

        if (velocidadDeseada < 0 || velocidadDeseada > velocidadMaxima) {
            System.out.println("La velocidad deseada no es válida. Debe estar entre 0 y " + velocidadMaxima + " km/h.");
            return;
        }

        if (velocidadDeseada <= velocidadActual) {
            System.out.println("El coche ya está a una velocidad igual o mayor de " + velocidadActual + " km/h.");
        } else {
            velocidadActual = velocidadDeseada;
            System.out.println("El coche ha acelerado a " + velocidadActual + " km/h.");
        }
    }

    // Método frenar
    public void frenar(Integer velocidadDeseada) {
        if (!encendido) {
            System.out.println("El coche está apagado, no se puede frenar.");
            return;
        }

        if (velocidadDeseada < 0 || velocidadDeseada > velocidadActual) {
            System.out.println(
                    "La velocidad deseada no es válida. Debe estar entre 0 km/h y " + velocidadActual + "  km/h.");
            return;
        }

        if (velocidadDeseada == velocidadActual) {
            System.out.println("El coche ya está a la velocidad deseada de " + velocidadActual + " km/h.");
        } else {
            velocidadActual = velocidadDeseada;
            System.out.println("El coche ha reducido su velocidad a " + velocidadActual + " km/h.");
        }
    }

    // Método encender
    public void encender() {
        if (!encendido) {
            encendido = true;
            System.out.println("El coche se ha encendido.");
        } else {
            System.out.println("El coche ya está encendido.");
        }
    }

    // Método apagar
    public void apagar() {
        if (encendido) {
            encendido = false;
            velocidadActual = 0; // El coche se detiene al apagarse
            System.out.println("El coche se ha apagado.");
        } else {
            System.out.println("El coche ya está apagado.");
        }
    }

    // Método principal para probar el coche
    public static void main(String[] args) {
        Coche cocheDiego = new Coche("Cochazo", 170, 250);

        // Estado inicial
        System.out.println("¿Está encendido el coche? " + cocheDiego.getEncendido());

        // Encender el coche
        cocheDiego.encender();
        System.out.println("¿Está encendido el coche? " + cocheDiego.getEncendido());

        // Intentar acelerar con el coche encendido
        cocheDiego.acelerar(100);

        // Intentar exceder la velocidad máxima
        cocheDiego.acelerar(200);

        // Intentar apagar el coche mientras está en movimiento
        cocheDiego.apagar();

        // Detener y apagar correctamente
        cocheDiego.acelerar(0);
        cocheDiego.apagar();

        // Encender el coche, acelerar a 100 y frenar a 50
        cocheDiego.encender();
        cocheDiego.acelerar(100);
        cocheDiego.frenar(50);

        // Intentar frenar a una velocidad superior
        cocheDiego.frenar(70);

        // Apagar el coche e intentar frenar
        cocheDiego.apagar();
        cocheDiego.frenar(20);
    }
}
