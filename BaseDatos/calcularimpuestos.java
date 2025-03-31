public class calcularimpuestos {
    public static void calcularImpuestos(int salarioNeto) {
        double deuda = 0;
        int salarioActual = salarioNeto;

        // Primer tramo (hasta 12450€ a 19%)
        if (salarioActual <= 12450) {
            deuda += salarioActual * 0.19;
        } else {
            deuda += 12450 * 0.19;
            salarioActual -= 12450;

            // Segundo tramo (de 12450€ a 20200€ a 24%)
            if (salarioActual <= 7750) {
                deuda += salarioActual * 0.24;
            } else {
                deuda += 7750 * 0.24;
                salarioActual -= 7750;

                // Tercer tramo (de 20200€ a 35200€ a 30%)
                if (salarioActual <= 15000) {
                    deuda += salarioActual * 0.30;
                } else {
                    deuda += 15000 * 0.30;
                    salarioActual -= 15000;

                    // Cuarto tramo (de 35200€ a 60000€ a 37%)
                    if (salarioActual <= 24800) {
                        deuda += salarioActual * 0.37;
                    } else {
                        deuda += 24800 * 0.37;
                        salarioActual -= 24800;

                        // Quinto tramo (más de 60000€ a 47%)
                        deuda += salarioActual * 0.47;
                    }
                }
            }
        }

        System.out.println("Debes " + deuda);
    }

    public static void main(String[] args) {
        calcularImpuestos(66600);
    }
}
