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
public class SMS extends Consumo{
    
    private String numero;

    public SMS(LocalDateTime fechaHora, float importe, String numero) {
        super(fechaHora, importe);
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return super.getFechaHora().toLocalDate()+","+super.getFechaHora().toLocalTime()+","+super.getImporte()+","+ numero;
    }
  
    @Override
    public TipoConsumo getTipoConsumo() {
        return TipoConsumo.SMS;
    }

    @Override
    public int getDuracionVolumen() {
        return 1;
    }

 
    
}
