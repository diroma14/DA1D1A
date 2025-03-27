package Excepciones.Ejercicio5;

import java.util.Scanner;

public class CuentaBancaria {
    private int saldo;

    public CuentaBancaria(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void retirar(int cantidad) throws SaldoInsuficienteExcepction {
        if(cantidad > saldo){
            throw new SaldoInsuficienteExcepction("El Saldo Es Insuficiente");
        }else{
            saldo -= cantidad;
        }
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria(1000);
        try {
            cuenta1.retirar(200000);
        } catch (SaldoInsuficienteExcepction e) {
           System.out.println("Error:Saldo Insuficiente");        }
    }
}
