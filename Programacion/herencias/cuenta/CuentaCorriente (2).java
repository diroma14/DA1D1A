package cuenta;

class CuentaCorriente extends Cuenta {
    private static double INTERES = 1.5;
    
    public CuentaCorriente(Integer numeroCuenta, double saldo, Persona cliente, String pin) {
        super(numeroCuenta, saldo, cliente, pin); 
    }

    
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= getSaldo()) {
            setSaldo(getSaldo() - cantidad);
            System.out.println("Se retiraron " + cantidad + "€. Saldo actual: " + getSaldo() + "€.");
        } else {
            System.out.println("No se puede retirar esa cantidad. Saldo insuficiente o cantidad inválida.");
        }
    }

    
    public void actualizarSaldo() {
        double nuevoSaldo = getSaldo() + (getSaldo() * INTERES / 100);
        setSaldo(nuevoSaldo);
        System.out.println("Saldo actualizado con interés fijo del 1.5%. Saldo actual: " + getSaldo() + "€.");
    }
}
