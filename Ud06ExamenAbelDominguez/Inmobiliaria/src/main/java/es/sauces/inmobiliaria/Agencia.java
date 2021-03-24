/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.inmobiliaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

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
       boolean incluido=false;

        if(!inmuebles.contains(inmueble)){
            inmuebles.add(inmueble);
            incluido=true;
        } 
        return incluido;
    }
    
    public boolean eliminarInmueble(String referencia){
        
        for(Inmueble inmueble: inmuebles){
            if(inmueble.getReferencia().equals(referencia)){
                inmuebles.remove(inmueble);
                return true;
            }
        }
        
        return false;
    }
    
    public List<Inmueble> getViviendas(){
        List<Inmueble> listado=new ArrayList<>();
        ListIterator<Inmueble> iterador=inmuebles.listIterator();
        Inmueble inmueble;
        
        while(iterador.hasNext()){
            inmueble=iterador.next();
            if(inmueble instanceof Vivienda){
                listado.add(inmueble);
            }
        }
        Collections.sort(listado,new ComparadorPrecio());
        
        return listado;
    }
    
    public List<Inmueble> getInmuebles (TipoOperacion operacion){
        List<Inmueble> listado= new ArrayList<>();
        
        for(Inmueble inmueble: inmuebles){
            if(inmueble.getOperacion().equals(operacion)){
                listado.add(inmueble);
            }
        }
        Collections.sort(listado);
        
        return listado;
    }
    
    public Local getLocalComprarMasBarato(){
        Local local=null;
        List<Local> listado=new ArrayList<>();
        
        for(Inmueble inmueble: inmuebles){
            if(inmuebles instanceof Local){
                listado.add((Local)inmueble);
            }
        }
        local=Collections.min(listado, new ComparadorPrecio());
        
        return local;
    }
}
