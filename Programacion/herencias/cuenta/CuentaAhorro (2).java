package cuenta;

class CuentaAhorro extends Cuenta {
    private double interes; 
    private double saldoMinimo; 

    public CuentaAhorro(Integer numeroCuenta, double saldo, Persona cliente, String pin, double interes, double saldoMinimo) {
        super(numeroCuenta, saldo, cliente, pin);
        this.interes = interes;
        this.saldoMinimo = saldoMinimo;
    }

    public void cambiarInteres(double nuevoInteres) {
        if (nuevoInteres > 0) {
            this.interes = nuevoInteres;
            System.out.println("El interés se ha cambiado a " + interes + "%.");
        } else {
            System.out.println("El interés debe ser positivo.");
        }
    }
    
    public void retirar(double cantidad) {
        if (cantidad > 0 && (getSaldo() - cantidad) >= saldoMinimo) {
            setSaldo(getSaldo() - cantidad);
            System.out.println("Se retiraron " + cantidad + "€. Saldo actual: " + getSaldo() + "€.");
        } else {
            System.out.println("No se puede retirar esa cantidad. Saldo insuficiente o no cumple el saldo mínimo.");
        }
    }

    public void actualizarSaldo() {
        double nuevoSaldo = getSaldo() + (getSaldo() * interes / 100);
        setSaldo(nuevoSaldo);
        System.out.println("Saldo actualizado con interés variable del " + interes + "%. Saldo actual: " + getSaldo() + "€.");
    }
}
