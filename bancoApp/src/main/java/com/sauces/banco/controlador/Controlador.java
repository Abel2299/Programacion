/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.banco.controlador;

import com.sauces.banco.modelo.Banco;
import com.sauces.banco.modelo.Cuenta;
import com.sauces.banco.vista.MiVentana;

/**
 *
 * @author daw1
 */
public class Controlador {

    private Banco modelo;
    private MiVentana vista;

    public Controlador(Banco modelo, MiVentana vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void abrirCuenta() {
        String codigo, titular;
        float saldo;
        
        codigo=vista.getCodigo();
        titular=vista.getTitular();
        saldo=vista.getSaldo();
        
        if(modelo.abrirCuenta(codigo, titular, saldo)){
            vista.mostrarMensaje("Cuenta abierta");
            vista.mostrarCuentas(modelo.getCuentas());
        }
        else{
            vista.mostrarMensaje("No se ha podido abrir la cuenta");
        }
    }

    public void operarConCuenta() {
        int operacion;
        String codigo;
        float cantidad;
        Cuenta cuenta;
        
        codigo=vista.getCodigo();
        cuenta=modelo.getCuenta(codigo);
        if(cuenta!=null){
            operacion=vista.getOperacion();
            cantidad=vista.getCantidad();

            if(operacion==0){
                cuenta.ingresar(cantidad);
            }
            else{
                cuenta.reintegrar(cantidad);
            }
            vista.actualizarTabla();
            vista.mostrarMensaje("Operación realizada");
        }
    }

    public void cancelarCuenta() {
        String codigo=vista.getCodigo();
        if(modelo.cancelarCuenta(codigo)){
            vista.mostrarMensaje("Cuenta cancelada");
        }
        else{
            vista.mostrarMensaje("No se ha podido cancelar la cuenta");
        }
    }

    public void listarCuentas() {

    }

    public void guardarCuentas() {

    }

    public void cargarCuentas() {

    }

    public void iniciar() {
        vista.setVisible(true);
    }

}
