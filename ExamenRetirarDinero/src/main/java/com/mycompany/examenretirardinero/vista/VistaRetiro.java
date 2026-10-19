package com.mycompany.examenretirardinero.vista;

import java.util.Scanner;

/**
 * @author USUARIO
 */
public class VistaRetiro {

    private Scanner sc;

    public VistaRetiro() {
        sc = new Scanner(System.in);
    }

    public void mostrarEncabezado() {
        System.out.println("CAJERO AUTOMATICO - RETIRO EFECTIVO");
        System.out.println();
    }

    // muestra la lista de montos disponibles
    public void mostrarMontos(double[] montos) {
        System.out.println("MONTOS DISPONIBLES");
        for (int i = 0; i < montos.length; i++) {
            System.out.println("  " + (i + 1) + ") $" + String.format("%.2f", montos[i]));
        }
        System.out.println("  0) Cancelar");
        System.out.print("\nSeleccione una opcion: ");
    }

    public int leerOpcion() {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un numero valido: ");
            sc.next();
        }
        return sc.nextInt();
    }

    // muestra el estado de cuenta con el detalle del retiro
    public void mostrarEstadoCuenta(String nombre, double saldo,
            double montoRetiro, double comision, double saldoFinal) {
        System.out.println();
        System.out.println("ESTADO DE CUENTA");
        System.out.println("  Titular:            " + nombre);
        System.out.println("  Saldo actual:       $" + String.format("%,.2f", saldo));
        System.out.println("  Cantidad a retirar: $" + String.format("%,.2f", montoRetiro));
        System.out.println("  Comision (3%):      $" + String.format("%,.2f", comision));
        System.out.println("  Saldo final:        $" + String.format("%,.2f", saldoFinal));

    }

    // pregunta si quiere confirmar el retiro
    public boolean confirmarRetiro() {
        System.out.println();
        System.out.println("1) Retirar efectivo");
        System.out.println("2) Cancelar");
        System.out.print("Seleccione: ");
        int op = leerOpcion();
        return op == 1;
    }

    // imprime el recibo del retiro
    public void mostrarRecibo(String ultimos4, String nombre,
            double cantidadRetirada, double comision) {
        System.out.println();
        System.out.println("RECIBO DE RETIRO");
        System.out.println("  Cuenta:     ****" + ultimos4);
        System.out.println("  Nombre:     " + nombre);
        System.out.println("  Retirado:   $" + String.format("%,.2f", cantidadRetirada));
        System.out.println("  Comision:   $" + String.format("%,.2f", comision));
        System.out.println("  Retiro realizado con exito.");
        System.out.println("  Conserve su recibo.");
    }

    public void mostrarFondosInsuficientes() {
        System.out.println("\nFondos insuficientes para este retiro");
    }

    public void mostrarCancelado() {
        System.out.println("\nOperacion cancelada.");
    }

    public void mostrarOpcionInvalida() {
        System.out.println("\nOpcion no valida, intente de nuevo.");
    }

    public void mostrarDespedida() {
        System.out.println("\nGracias por usar el cajero. Hasta pronto.");
    }

    public void cerrar() {
        sc.close();
    }
}
