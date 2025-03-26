package objetos;

public class Altavoz {
    // Atributos
    private String marca;
    private String modelo;
    private Integer potencia;
    private String tipo;
    private Integer precio;
    private boolean encendido;
    private String dispositivoActual;
    private Integer volumen;

    // Constructor
    public Altavoz(String marca, String modelo, Integer potencia, String tipo, Integer precio, boolean encendido,
            String dispositivoActual, Integer volumen) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.tipo = tipo;
        this.precio = precio;
        this.encendido = encendido;
        this.dispositivoActual = dispositivoActual;
        this.volumen = volumen;
    }

    // Setters y getters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public String getDispositivoActual() {
        return dispositivoActual;
    }

    public void setDispositivoActual(String dispositivoActual) {
        this.dispositivoActual = dispositivoActual;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    // Métodos
    // Encender
    public void encender() {
        if (encendido) {
            System.out.println("El dispositivo ya está encendido.");
        } else {
            System.out.println("El dispositivo se ha encendido.");
            encendido = true;
        }
    }

    // Apagar
    public void apagar() {
        if (encendido) {
            System.out.println("El altavoz se ha apagado.");
            encendido = false;
        } else {
            System.out.println("El altavoz ya está apagado.");
        }
    }

    // Conectar dispositivo
    public void conectarDispositivo(String nuevoDispositivo) {
        if (!dispositivoActual.isEmpty()) {
            System.out.println("Ya hay un dispositivo conectado: " + dispositivoActual);
        } else {
            dispositivoActual = nuevoDispositivo;
            System.out.println("Conectando al dispositivo " + dispositivoActual);
        }
    }

    // Desconectar dispositivo
    public void desconectarDispositivo() {
        if (!dispositivoActual.isEmpty()) {
            System.out.println("Se ha desconectado el dispositivo " + dispositivoActual);
            dispositivoActual = "";
        } else {
            System.out.println("No hay ningún dispositivo conectado actualmente.");

        }
    }

    //Subir volumen
    public void subirVolumen(int volumenNuevo){
        if(!encendido){
            System.out.println("El altavoz tiene que estar encendido");
        }else if(volumenNuevo >= 0 && volumenNuevo <= 100){
            if (volumenNuevo > volumen) {
                System.out.println("Subiendo el volumen a" + volumenNuevo);
                volumen = volumenNuevo;
            }else{
                System.out.println("El volumen tiene que ser mayor que el actual");
            }
        }else{
            System.out.println("El volumen tiene que estar entre 0 y 100");
        }
        
    }

    public static void main(String[] args) {
        Altavoz altavozDiego = new Altavoz("Ubuntuvoz", "ManolicoModelo", 14, "Cool", 12, false, "",20);

        altavozDiego.encender();
        altavozDiego.encender();
        System.out.println("");

        altavozDiego.apagar();
        altavozDiego.apagar();
        System.out.println("");

        altavozDiego.conectarDispositivo("Movil Diego");
        altavozDiego.conectarDispositivo("Movil Diego");
        System.out.println("");

        altavozDiego.desconectarDispositivo();
        altavozDiego.desconectarDispositivo();
        System.out.println("");

        altavozDiego.subirVolumen(0);
        altavozDiego.encender();
        altavozDiego.subirVolumen(0);
        altavozDiego.subirVolumen(30);
        System.out.println("");

        

    }

}
