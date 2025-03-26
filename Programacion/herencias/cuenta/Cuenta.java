package cuenta;

public abstract class Cuenta {
    
    // Atributos
    private Integer numeroCuenta; 
    private Double saldo;
    private Persona cliente;
    private String pin; 

    // Constructor
    public Cuenta(Integer numeroCuenta, Double saldo, Persona cliente, String pin) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.cliente = cliente;
        this.pin = pin;
    }

    // Getters y setters
    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    // Métodos
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            System.out.println("Se ingresaron " + cantidad + "€. Saldo actual: " + saldo + "€.");
        } else {
            System.out.println("La cantidad a ingresar debe ser positiva.");
        }
    }

    public abstract void retirar(double cantidad);
    public abstract void actualizarSaldo();
}

