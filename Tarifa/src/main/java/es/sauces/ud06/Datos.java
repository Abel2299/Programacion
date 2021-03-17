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
public class Datos extends Consumo{
    
    private int volumen;

    public Datos(LocalDateTime fechaHora, float importe , int volumen) {
        super(fechaHora, importe=0);
        this.volumen = volumen;
    }

    public int getVolumen() {
        return volumen;
    }

    @Override
    public String toString() {
        return super.getFechaHora().toLocalDate()+","+super.getFechaHora().toLocalTime()+","+super.getImporte()+","+volumen;
    }

    @Override
    public TipoConsumo getTipoConsumo() {
        return TipoConsumo.DATOS;
    }

    @Override
    public int getDuracionVolumen() {
        return volumen;
    }

    
    
}
