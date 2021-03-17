/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.ud06;

import java.time.LocalDateTime;

/**
 *
 * @author daw1
 */
public class Llamada extends Consumo{
    
    private String numero;
    private int duracion;

    public Llamada(LocalDateTime fechaHora, float importe, String numero, int duracion) {
        super(fechaHora, importe);
        this.numero = numero;
        this.duracion = duracion;
    }

    public String getNumero() {
        return numero;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return  numero ;
    }
    
    @Override
    public TipoConsumo getTipoConsumo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getDuracionVolumen() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
}
