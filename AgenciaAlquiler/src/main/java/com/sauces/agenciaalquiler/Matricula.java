/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author daw1
 */
public class Matricula implements Serializable{
    
    private String matricula;

    public Matricula(String matricula) throws MatriculaException {
        if(!esValido(matricula)){
            throw new MatriculaException("Matricula incorrecta");
        }
        this.matricula = matricula;
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matricula other = (Matricula) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  matricula ;
    }
    
    public int compareTo(Matricula m){
        return this.matricula.compareTo(m.matricula);
    }
    
    public boolean esValido(String matricula){
    boolean esValido=false; 
    String patron="[0-9]{4}[BCDFGHJKLMNPRSTVWXYZ]{3}";  //[A-Z && [^AEIOUQ]]
    
    Pattern p=Pattern.compile(patron);
    Matcher m=p.matcher(matricula);
    
    if(m.matches()){
        esValido=true;
    }
    
    return esValido;
    }
    
}
