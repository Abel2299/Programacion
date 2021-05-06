/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.banco;

import com.sauces.banco.controlador.Controlador;
import com.sauces.banco.modelo.Banco;
import com.sauces.banco.vista.MiVentana;

/**
 *
 * @author daw1
 */
public class AppBancoM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banco modelo = new Banco("Banco Sauces");
        MiVentana vista = new MiVentana();
        Controlador controlador = new Controlador(modelo, vista);
        vista.setControlador(controlador);
        controlador.iniciar();
    }
    
}
