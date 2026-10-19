package com.mycompany.examenretirardinero.modelo;

/**
 * @author USUARIO
 */
public class Retiro {

    private static final double COMISION = 0.03; // 3% de comision

    // montos en multiplos de 200
    private static final double[] MONTOS = {
        200, 400, 600, 800, 1000,
        1200, 1400, 1600, 1800, 2000,
        3000, 4000, 5000
    };

    private double montoSeleccionado;
    private double cobroComision;
    private double totalADescontar;

    public Retiro() {
    }

    public static double[] getMontos() {
        return MONTOS;
    }

    // calcula la comision de un monto
    public double calcularComision(double monto) {
        return monto * COMISION;
    }

    // registra el monto seleccionado y calcula la comision y el total
    public void seleccionarMonto(double monto) {
        this.montoSeleccionado = monto;
        this.cobroComision = calcularComision(monto);
        this.totalADescontar = monto + cobroComision;
    }

    public boolean esOpcionValida(int indice) {
        return indice >= 0 && indice < MONTOS.length;
    }

    // calcula el saldo resultante restando el total a descontar
    public double calcularSaldoFinal(double saldoActual) {
        return saldoActual - totalADescontar;
    }

    public double getMontoSeleccionado() {
        return montoSeleccionado;
    }

    public double getCobroComision() {
        return cobroComision;
    }

    public double getTotalADescontar() {
        return totalADescontar;
    }
}
