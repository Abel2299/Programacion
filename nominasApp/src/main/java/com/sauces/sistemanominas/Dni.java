/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author daw1
 */
public class Dni implements Serializable, Comparable<Dni>{
    
    private static final long serialVersion= 1L;
    
    private String dni;

    public Dni() {
    }

    public Dni(String dni) throws DniException {
        if(!esValido(dni)){
            throw new DniException("Dni incorrecto");
        }
        
            this.dni = dni;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return dni;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (obj instanceof Dni) {
                Dni dni = (Dni) obj;
                if (this.dni.equals(dni.dni)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int compareTo(Dni o) {
        return this.dni.compareTo(o.dni);
    }
    
    private boolean esValido(String dni){  // Comprobacion con Pattern
        boolean esValido=false;
        int resto; 
        String letras="TRWAGMYFPDXBNJZSQVHLCKE";
        char letra;
        String er="([0-9]{8})([A-Z])";
        Pattern p=Pattern.compile(er);
        Matcher m=p.matcher(dni);
        if(m.matches()){
            resto=Integer.parseInt(m.group(1))%23;
            letra=letras.charAt(resto);
            if(letra==dni.charAt(8)){
                esValido=true;
            }
        }
          return esValido;
    }
}
