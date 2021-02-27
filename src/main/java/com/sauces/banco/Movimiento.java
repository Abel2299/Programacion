/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.banco;

import java.time.LocalDate;

/**
 *
 * @author ambrosio
 */
public class Movimiento {
    private LocalDate fecha;
    private char tipo;
    private float cantidad;
    private float saldo;

    /**
     *
     * @param fecha
     * @param tipo
     * @param cantidad
     * @param saldo
     */
    public Movimiento(LocalDate fecha, char tipo, float cantidad, float saldo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.saldo = saldo;
    }

    /**
     *
     */
    public Movimiento() {
    }

    /**
     *
     * @return
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     *
     * @return
     */
    public char getTipo() {
        return tipo;
    }

    /**
     *
     * @return
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     *
     * @return
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return fecha + "," + "," + tipo + "," + cantidad + "," + saldo;
    }
}
