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

    public Datos(LocalDateTime fechaHora, float importe, int volumen) {
        super(fechaHora, importe);
        this.volumen = volumen;
    }

    public int getVolumen() {
        return volumen;
    }

    @Override
    public String toString() {
        return "Datos{" + "volumen=" + volumen + '}';
    }

    @Override
    public TipoConsumo getTipoConsumo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getDuracionVolumen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
