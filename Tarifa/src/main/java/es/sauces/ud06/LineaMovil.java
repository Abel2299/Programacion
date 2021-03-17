/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.ud06;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class LineaMovil implements Comparable<LineaMovil>{
    private String numero;
    private String titular;
    private Tarifa tarifa;
    private int datosDisponibles;
    private List<Consumo> consumos = new ArrayList<>();;

    public LineaMovil(String numero, String titular, Tarifa tarifa) {
        this.numero = numero;
        this.titular = titular;
        this.tarifa = tarifa;
        consumos=new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public int getDatosDisponibles() {
        return datosDisponibles;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

        
    
}
