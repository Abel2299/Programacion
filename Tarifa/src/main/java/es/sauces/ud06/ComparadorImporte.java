/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.ud06;

import java.util.Comparator;

/**
 *
 * @author daw1
 */
public class ComparadorImporte implements Comparator<Consumo>{

    @Override
    public int compare(Consumo c1, Consumo c2) {
              
        int salida=0;
        float consumo1, consumo2;
        
        consumo1 =c1.getImporte();
        consumo2 =c2.getImporte();
        
        if(consumo1<consumo2){
                salida=-1;
            }
            else{
                if(consumo1>consumo2){
                    salida=1;
                }
            }
        
        return salida;
    }
}
