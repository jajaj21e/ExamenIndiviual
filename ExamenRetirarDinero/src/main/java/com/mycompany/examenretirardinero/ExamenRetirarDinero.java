/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenretirardinero;

import com.mycompany.examenretirardinero.controlador.ControladorRetiro;
import com.mycompany.examenretirardinero.modelo.Cuenta;
import com.mycompany.examenretirardinero.modelo.Retiro;
import com.mycompany.examenretirardinero.vista.VistaRetiro;

/**
 * @author USUARIO
 */
public class ExamenRetirarDinero {

    public static void main(String[] args) {
        // datos de prueba del cliente
        Cuenta cuenta = new Cuenta("4520-1234-5678-9012", "Juan Perez Lopez", 10000.00);
        Retiro retiro = new Retiro();
        VistaRetiro vista = new VistaRetiro();

        ControladorRetiro controlador = new ControladorRetiro(vista, cuenta, retiro);
        controlador.iniciar();
    }
}
