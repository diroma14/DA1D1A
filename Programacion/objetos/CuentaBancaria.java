package objetos;

public class CuentaBancaria {
    // Atributos
    private String titular;
    private Integer saldo;

    // Constructor

    public CuentaBancaria(String titular, Integer saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    // Setters y getters

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Integer getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    // Métodos

    //Retirar dinero
    public void retirarDinero(int retirar) {
        System.out.println("Se va a retirar la siguiente cantidad de dinero: " + retirar);
        if (retirar > saldo) {
            System.out.println("Su cuenta no cuenta con tanto dinero.");
        } else {
            saldo = saldo - retirar;
            System.out.println("Operación realizada correctamente.");
        }
    }

    //Ingresar dinero

    public void ingresarDinero(int ingresar){
        System.out.println("Se va a ingresar la siguiente cantidad de dinero: " + ingresar);
        saldo = saldo + ingresar;
    }

    //Enseñar saldo actual

    public void saldoActual(){
        System.out.println("Su saldo es el siguiente: " + saldo);
    }

    public static void main(String[] args) {
        CuentaBancaria cuentaDiego = new CuentaBancaria("Diego Rodríguez", 16000);

        cuentaDiego.saldoActual();
        cuentaDiego.ingresarDinero(100);
        cuentaDiego.saldoActual();
        cuentaDiego.retirarDinero(700);
        cuentaDiego.saldoActual();
        cuentaDiego.retirarDinero(17000);

    }
}
