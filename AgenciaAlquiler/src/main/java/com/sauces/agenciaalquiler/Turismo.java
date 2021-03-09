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
public class Turismo extends Vehiculo{
    
    private int plazas;

    public Turismo(String matricula, Grupo grupo, int plazas) {
        super(matricula, grupo);
        this.plazas = plazas;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    @Override
    public String toString() {
        return super.toString()+","+plazas;
    }

    @Override
    public float getPrecioAlquiler(){
       /* float precioAlquiler;
        if(getGrupo()==Grupo.A){
            precioAlquiler=(float) (50+1.5*plazas);
        }
        else{
            if(getGrupo()==Grupo.B){
                precioAlquiler= (55+2*plazas);
            }
            else{
                precioAlquiler=(float) (50+2.5*plazas);
        }
        }
        return precioAlquiler;
        */
        /*switch(getGrupo()){
        case A: precioAlquiler = (50+1.5f*plazas);
        break;
        case B: precioAlquiler = (55+2*plazas);
        break;
        case C: precioAlquiler = (50+2.5f*plazas);
        break;
        }
        */
        
        
        return getGrupo().getPrecioBase()+getGrupo().getFactorTurismo()*plazas;
                
    }

    @Override
    public float getPrecioAlquiler(int dias) {
        float precioAlquilerDias=0;   
        
        return precioAlquilerDias;
        //return getPrecioAlquilerDias()*dias;
    }
}