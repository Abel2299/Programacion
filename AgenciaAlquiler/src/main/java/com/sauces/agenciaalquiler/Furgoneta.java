/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

/**
 *
 * @author Abel
 */
public class Furgoneta extends Vehiculo{

    float capacidad;

    public Furgoneta(String matricula, Grupo grupo, float capacidad) {
        super(matricula, grupo);
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return super.toString()+","+capacidad;
    }
    
    @Override
    public float getPrecioAlquiler() {
        float precioAlquiler = 0;
        if(getGrupo()==Grupo.A){
            precioAlquiler=(float) (50+5*capacidad);
        }
        else{
            if(getGrupo()==Grupo.B){
                precioAlquiler=(float) (55+10*capacidad);
            }
            else{
                precioAlquiler=(float) (50+15*capacidad);
        }
        }
        return precioAlquiler;
    }

    @Override
    public float getPrecioAlquiler(int dias) {
        float precioAlquilerDias=0;   
        
        return precioAlquilerDias;
    }
    
    
}
