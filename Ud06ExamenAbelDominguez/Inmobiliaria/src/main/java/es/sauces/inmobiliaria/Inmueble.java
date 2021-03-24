/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.inmobiliaria;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Abel
 */
public abstract class Inmueble implements Comparable<Inmueble>, Serializable{
    
    private String referencia;
    private float superficie;
    private int precio;
    private TipoOperacion operacion;

    public Inmueble(String referencia, float superficie, int precio, TipoOperacion operacion) throws ReferenciaException {
        if(!referenciaValida(referencia)){
            throw new ReferenciaException("Formato incorrecto");
        }
        
        if(superficie<0 || precio<0){
            throw new IllegalArgumentException("Datos incorrectos");
        }
       
        this.referencia = referencia;
        this.superficie = superficie;
        this.precio = precio;
        this.operacion = operacion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) throws ReferenciaException {
        if(!referenciaValida(referencia)){
            throw new ReferenciaException("Formato incorrecto");
        }
        this.referencia = referencia;
    }

    public float getSuperficie() {
        return superficie;
    }

    public void setSuperficie(float superficie) {
        if(superficie<0){
            throw new IllegalArgumentException("Datos incorrectos");
        }
        this.superficie = superficie;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
       if(precio<0){
            throw new IllegalArgumentException("Datos incorrectos");
        }
        this.precio = precio;
    }

    public TipoOperacion getOperacion() {
        return operacion;
    }

    public void setOperacion(TipoOperacion operacion) {
        this.operacion = operacion;
    }
    
    private boolean referenciaValida(String referencia){
        String expresionRegular="[LV][0-9]{3}";
        Pattern p=Pattern.compile(expresionRegular);
        Matcher m=p.matcher(referencia);
        
        return m.matches();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.referencia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj!= null) {
           if(obj instanceof Inmueble){
            Inmueble in=(Inmueble)obj;

            if (this.referencia.equals(in.referencia)){
            return true;
            }
        }
        }
        return false;
    }
    

    @Override
    public String toString() {
        return referencia + ", " + superficie + ", " + precio + ", " + operacion;
    }
   
    
    @Override
    public int compareTo(Inmueble o) {
        return this.referencia.compareTo(o.referencia);
    }

    public abstract float getComision();  
   
}
