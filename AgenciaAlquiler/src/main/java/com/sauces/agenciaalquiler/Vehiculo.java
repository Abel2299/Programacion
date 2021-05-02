/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Abel
 */
public abstract class Vehiculo implements Comparable<Vehiculo>, Serializable {
    private Matricula matricula;
    private Grupo grupo;

    public Vehiculo(String matricula, Grupo grupo) throws MatriculaException {
        this.matricula = new Matricula(matricula);
        this.grupo = grupo;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    @Override
    public String toString() {
        return  matricula + "," + grupo ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        /*if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!this.matricula.equals(other.matricula)) {
            return false;
        }
        return true;*/
        
        
        if(this==obj){
            return true;
        }
        if(obj!=null){
            if(obj instanceof Vehiculo){
                Vehiculo v=(Vehiculo)obj;
                if(this.matricula.equals(v.matricula)){
                    return true;
                }
            }
        }
        
        return false;
    }

    @Override
    public int compareTo(Vehiculo o) {
        return this.matricula.compareTo(o.matricula);
    }

    public abstract float getPrecioAlquiler();
    
    public abstract float getPrecioAlquiler(int dias);    
    
}
