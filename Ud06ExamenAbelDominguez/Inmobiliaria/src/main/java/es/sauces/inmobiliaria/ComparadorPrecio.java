/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.inmobiliaria;

import java.util.Comparator;

/**
 *
 * @author daw1
 */
public class ComparadorPrecio implements Comparator<Inmueble>{

    @Override
    public int compare(Inmueble inm1, Inmueble inm2) {
         int salida=0;
         
         int inmueble1, inmueble2;
         
         inmueble1= inm1.getPrecio();
         inmueble2= inm2.getPrecio();
         
         if(inmueble1<inmueble2){
             salida=-1;
         }
         else{
             salida=1;
         }
    
        return salida;
        
        /*Otra solucioin*/
        /*return inm1.getPrecio()-inm2.getPrecio();*/
    }
}
