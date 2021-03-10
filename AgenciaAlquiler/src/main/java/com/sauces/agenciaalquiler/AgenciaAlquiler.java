/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

/**
 *
 * @author Abel
 */
public class AgenciaAlquiler {
    
    private String nombre;
    private List<Vehiculo> flota  = new ArrayList<>();

    public AgenciaAlquiler(String nombre) {
        this.nombre = nombre;        
        flota=new ArrayList<>();
    }

    public List<Vehiculo> getFlota() {
        return flota;
    }

    public void setFlota(List<Vehiculo> flota) {
        this.flota = flota;
    }
    

   public boolean incluirVehiculo(Vehiculo vehiculo){
       boolean incluido=false;
       
       if(!flota.contains(vehiculo)){
            flota.add(vehiculo);
            incluido=true;
        }
        //incluido=flota.add(vehiculo);
       return incluido;
   }
   
   public Vehiculo consultarVehiculo(String matricula){
       Vehiculo vehiculo=null;
       Iterator<Vehiculo> iterador =  flota.iterator();     // ListIterator<Vehiculo> iterador =  flota.listIterator();
       
       while(iterador.hasNext()){
            vehiculo=iterador.next();
            if(vehiculo.getMatricula().equals(matricula)){
                return vehiculo;
            }
        }
        return null;
   }
   
   public boolean eliminarVehiculo(Vehiculo vehiculo){
       return flota.remove(vehiculo);
    }

   public List<Vehiculo> listarVehiculosPorPrecio(){
        
       //List<Vehiculo>listado = new ArrayList<>(flota);
         Collections.sort(flota, new ComparadorPrecio());
       
    return flota;
    //return listado
    }
   
   public List<Vehiculo> listarVehiculos(Grupo grupo){
      
       List<Vehiculo>listado = new ArrayList<>(flota);
       
       for(Vehiculo v:flota){
           if(grupo.equals(v.getGrupo())){
               listado.add(v);
           }
       }
       
       return listado;
   }
   
   public Vehiculo getVehiculoMasBarato(){
        
       /* Vehiculo vehiculo = null;
         Vehiculo vehiculoMasBarato = null;
         Iterator<Vehiculo> iterador=flota.iterator();
       
         while(iterador.hasNext()){
            vehiculo=iterador.next();
            if(vehiculo.getPrecioAlquiler()>vehiculoMasBarato.getPrecioAlquiler()){
                vehiculoMasBarato = vehiculo;
            }
        }
         
        return vehiculoMasBarato;
        */
        return Collections.min( flota, new ComparadorPrecio());
   }
           
}

