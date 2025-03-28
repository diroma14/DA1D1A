package objetos;

public class Password {
    // Atributos
    private Integer longitud;
    private String contraseña;

    // Constructor

    public Password(Integer longitud, String contraseña) {
        this.longitud = longitud;
        this.contraseña = contraseña;
    }

    // Setters y getters

    public Integer getLongitud() {
        return this.longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public String getContraseñA() {
        return this.contraseña;
    }

    public void setContraseñA(String contraseña) {
        this.contraseña = contraseña;
    }

    // Métodos

    //Método esFuerte

    public boolean esFuerte() {
        // Recorrer todos los caracteres
        int numeros = 0;
        int mayusculas = 0;
        int minusculas = 0;
        for (int i = 0; i < longitud; i++) {
            if (Character.isLowerCase(contraseña.charAt(i))) {
                // System.out.println("Minúscula.");
                minusculas++;
            } else if (Character.isUpperCase(contraseña.charAt(i))) {
                // System.out.println("Mayúscula.");
                mayusculas++;
            } else if (Character.isDigit(contraseña.charAt(i))) {
                // System.out.println("Número.");
                numeros++;
            }
        }

        // Mostrar conteo
        System.out.println("Mayúsculas: " + mayusculas);
        System.out.println("Minúsculas: " + minusculas);
        System.out.println("Números: " + numeros);

        // Comprobar si se cumple la condición.
        if (mayusculas >= 2 & minusculas > 1 & numeros > 5) {
            return true;
        } else {
            return false;
        }

    }

    // Main
    public static void main(String[] args) {
        Password contraseñaDiego = new Password(10, "I4dEA83p41");

        contraseñaDiego.esFuerte();
    }
}
