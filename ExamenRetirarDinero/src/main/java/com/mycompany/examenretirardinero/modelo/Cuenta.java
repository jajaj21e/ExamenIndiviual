package com.mycompany.examenretirardinero.modelo;

/**
 * @author USUARIO
 */
public class Cuenta {

    private String numeroCuenta;
    private String nombre;
    private double saldo;

    public Cuenta(String numeroCuenta, String nombre, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // regresa los ultimos 4 digitos de la cuenta
    public String getUltimos4Digitos() {
        return numeroCuenta.substring(numeroCuenta.length() - 4);
    }
}
