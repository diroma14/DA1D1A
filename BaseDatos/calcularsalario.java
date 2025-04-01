public class calcularsalario {
    public static void calcularSalario(String localidad, int añosContrato) {
        double salario;
        double pVidaComunidad;
        int semestres;
        int años = añosContrato;
        double media = 32485.24737; // Calcular media del país
        int trienios;

        // Si la localidad no existe o si los años introducidos son menores a 0 el
        // salario es 0

        // Calcular el precio de vida en función de localidad (Si existe)
        if (localidad.equals("Madrid")) {
            pVidaComunidad = 37360.5;
        } else if (localidad.equals("Andalucia")) {
            pVidaComunidad = 32616.7;
        } else {
            pVidaComunidad = 30000;
        }

        // Prueba1
        salario = pVidaComunidad;
        System.out.println("Salario(pVidaComunidad = )" + pVidaComunidad);

        // Calcular los semestres (No puede ser menor a 1 y son números enteros)
        semestres = añosContrato * 2;
        System.out.println("Semestres: " + semestres);

        // Calcular el 1% del pVida de la comunidad por cada semestre
        for (int i = semestres; i > 0; i--) {
            salario = salario + pVidaComunidad * 0.01;
            System.out.println("Salario aumentado (por semestre) a:" + salario);
        }

        System.out.println("Años en la empresa: " + años);
        // Calcular salario por cada año
        for (int i = años; i > 0; i--) {
            salario = salario + media * 0.05;
            System.out.println("Salario aumentado (por año) a:" + salario);
        }

        // Calcular trienios
        trienios = añosContrato / 3;
        System.out.println("Trienios: " + trienios);

        // Calcular salario por cada trienio
        for (int i = trienios; i > 0; i--) {
            salario = salario + salario * 0.03;
            System.out.println("Salario aumentado (por trienio) a:" + salario);
        }

        System.out.println("Salario: " + Math.round(salario));

    }

    public static void main(String[] args) {
        calcularSalario("Madrid", 6);
    }
}