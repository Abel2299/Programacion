/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

/**
 *
 * @author daw1
 */
public class EmpleadoFijo extends Empleado{
    
    private static final long serialVersion= 3L;
    
    private float salario;

    /**
     * Get the value of Salario
     *
     * @return the value of Salario
     */
    public float getsalario() {
        return salario;
    }

    /**
     * Set the value of Salario
     *
     * @param Salario new value of Salario
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }

    public EmpleadoFijo(String dni, String nombre, float salario)throws DniException {
        super(dni, nombre);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString()+","+salario;
    }
    
    @Override
    public float ingresos() {
        return salario;
    }
    
}
