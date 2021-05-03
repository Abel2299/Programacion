/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author daw1
 */
public abstract class Empleado implements Comparable<Empleado>, Serializable {

    private static final long serialVersion = 2L;

    private Dni dni;
    private String nombre;

    public String getDni() {
        return dni.toString();
    }

    public void setDni(Dni dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(String dni, String nombre) throws DniException {
        this.dni = new Dni(dni);
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return dni + ", " + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (obj instanceof Empleado) {
                Empleado e = (Empleado) obj;
                if (this.dni.equals(e.dni)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public int compareTo(Empleado o) {          //arg0
        return this.dni.compareTo(o.dni);
    }

    public abstract float ingresos();       //metodo abstracto

}
