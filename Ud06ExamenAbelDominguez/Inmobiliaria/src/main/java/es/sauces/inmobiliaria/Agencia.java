/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.inmobiliaria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class Agencia {
    private List<Inmueble> inmuebles;
    
    public Agencia(){
       inmuebles=new ArrayList<>();
    }

    public List<Inmueble> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<Inmueble> inmuebles) {
        this.inmuebles = inmuebles;
    }
    
    public boolean incluirInmueble(Inmueble inmueble){
       boolean referencia=false;

        if(referencia!=inmueble.getReferencia()){
        inmuebles.add(inmueble);
        return true;
        }
        
        
    }
    
    public boolean eliminarInmueble(String referencia){
        
    }
    
}
