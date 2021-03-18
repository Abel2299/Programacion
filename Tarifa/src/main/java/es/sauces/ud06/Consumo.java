/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.ud06;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author daw1
 */
public abstract class Consumo implements Serializable{
    private LocalDateTime fechaHora;
    private float importe;

    public Consumo(LocalDateTime fechaHora, float importe) {
        this.fechaHora = fechaHora;
        this.importe = importe;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
       //return fechaHora + ", " + importe;
         return String.format("%1$td-%1$tm-%1$tY,%1$tR,fechaHora")+", "+importe;
    }
    
    public abstract TipoConsumo getTipoConsumo();
    
    public abstract int getDuracionVolumen();
}
