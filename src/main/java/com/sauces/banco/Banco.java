/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.banco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ambrosio
 */
public class Banco {
    private String nombre;
    private Set<Cuenta> cuentas;   //en lugar de ser un List que sea un set

    /**
     *
     * @param nombre
     */
    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas=new HashSet<>();
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public List<Cuenta> getCuentas() {
        return List.copyOf(cuentas);
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     *
     * @param codigo
     * @param titular
     * @param saldo
     * @return
     */
    public boolean abrirCuenta(String codigo, String titular, float saldo){             //boolean cuentas.add(new Cuenta(codigo,titular,saldo));
        boolean correcto=false;
        
        if(this.buscarCuenta(codigo)==-1){
            cuentas.add(new Cuenta(codigo,titular,saldo));
            correcto=true;
        }
        
        return correcto;
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean cancelarCuenta(String codigo){           //return cuentas.remove(new Cuenta(codigo,null,0));
        boolean correcto=false;
        int posicion;
        
        posicion=this.buscarCuenta(codigo);
        if(posicion!=-1){
            cuentas.remove(posicion);
            correcto=true;
        }
        return correcto;
    }

    /**
     *
     * @return
     */
    public float getTotalDepositos(){
        float total=0;
        
        for(Cuenta c: cuentas){
            total+=c.getSaldo();
        }
        
        return total;
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public Cuenta getCuenta(String codigo){         
        Cuenta c=null;                               //Cuenta c=null, cuenta;
        int posicion;                                //Iterator<Cuenta> iterador=cuenta.iterator();
        
        posicion=this.buscarCuenta(codigo);          // while(iterador.hasNext() && c=null){
                                                     //   cuenta=iterador.next();
                                                     // if(cuenta.getCodigo().equals(codigo)){
                                                     //   c=cuenta
                                                     //}
                                                     //}
                                                     //return null;
        if(posicion!=-1){
            c=cuentas.get(posicion);
        }
  
        return c;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nombre;
    }
    
    
    private int buscarCuenta(String codigo){                                    // Este metodo se borra
        int posicion=-1;
        
        for(int i=0;i<cuentas.size() && posicion==-1;i++){
            if(codigo.equals(cuentas.get(i).getCodigo())){
                posicion=i;   
            }
        }
        
        return posicion;
    }
    
    
}
