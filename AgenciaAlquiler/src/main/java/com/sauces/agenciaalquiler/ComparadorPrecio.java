/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.util.Comparator;

/**
 *
 * @author Abel
 */
public class ComparadorPrecio implements Comparator<Vehiculo>{

    @Override
    public int compare(Vehiculo o1, Vehiculo o2) {
       int salida=0;
            float precioVehiculo1,precioVehiculo2;
            
            precioVehiculo1=o1.getPrecioAlquiler();
            precioVehiculo2=o2.getPrecioAlquiler();
            
            if(precioVehiculo1<precioVehiculo2){
                salida=-1;
            }
            else{
                if(precioVehiculo1<precioVehiculo2){
                    salida=1;
                }
            }
            return salida;
    }
    
}
