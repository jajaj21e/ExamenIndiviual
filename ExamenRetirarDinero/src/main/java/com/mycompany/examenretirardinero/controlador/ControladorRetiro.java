package com.mycompany.examenretirardinero.controlador;

import com.mycompany.examenretirardinero.modelo.Cuenta;
import com.mycompany.examenretirardinero.modelo.Retiro;
import com.mycompany.examenretirardinero.vista.VistaRetiro;

/**
 * @author USUARIO
 */
public class ControladorRetiro {

    private VistaRetiro vista;
    private Cuenta cuenta;
    private Retiro retiro;

    public ControladorRetiro(VistaRetiro vista, Cuenta cuenta, Retiro retiro) {
        this.vista = vista;
        this.cuenta = cuenta;
        this.retiro = retiro;
    }

    // metodo principal que ejecuta todo el flujo del retiro
    public void iniciar() {
        vista.mostrarEncabezado();

        boolean seguir = true;

        while (seguir) {
            // mostrar montos
            double[] montos = Retiro.getMontos();
            vista.mostrarMontos(montos);

            int opcion = vista.leerOpcion();

            // si elige 0, cancela
            if (opcion == 0) {
                vista.mostrarCancelado();
                seguir = false;
                continue;
            }

            int indice = opcion - 1;

            if (!retiro.esOpcionValida(indice)) {
                vista.mostrarOpcionInvalida();
                continue;
            }

            // seleccionar monto y calcular comision
            double monto = montos[indice];
            retiro.seleccionarMonto(monto);

            double saldoActual = cuenta.getSaldo();
            double saldoFinal = retiro.calcularSaldoFinal(saldoActual);

            // mostrar estado de cuenta
            String nombre = cuenta.getNombre();
            double montoRetiro = retiro.getMontoSeleccionado();
            double comision = retiro.getCobroComision();

            vista.mostrarEstadoCuenta(nombre, saldoActual, montoRetiro, comision, saldoFinal);

            // validar si alcanza el saldo
            if (saldoFinal < 0) {
                vista.mostrarFondosInsuficientes();
                continue;
            }

            // confirmar retiro
            boolean confirmar = vista.confirmarRetiro();
            if (confirmar) {
                // actualizar saldo de la cuenta
                cuenta.setSaldo(saldoFinal);

                String ultimos4 = cuenta.getUltimos4Digitos();
                vista.mostrarRecibo(ultimos4, nombre, montoRetiro, comision);
                seguir = false;
            } else {
                vista.mostrarCancelado();
                seguir = false;
            }
        }

        vista.mostrarDespedida();
        vista.cerrar();
    }
}
