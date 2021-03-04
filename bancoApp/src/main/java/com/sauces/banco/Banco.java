/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.banco;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
        cuentas = new HashSet<>();
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
    public Set<Cuenta> getCuentas() {
        Set<Cuenta> newHashSet = new HashSet<>(cuentas);
        return newHashSet;
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
    public boolean abrirCuenta(String codigo, String titular, float saldo) {            
         return cuentas.add(new Cuenta(codigo,titular,saldo));
    }

    /**
     *
     * @param codigo
     * @return
     */
    public boolean cancelarCuenta(String codigo) {          
         return cuentas.remove(new Cuenta(codigo,null,0));
    }

    /**
     *
     * @return
     */
    public float getTotalDepositos() {
        float total = 0;

        for (Cuenta c : cuentas) {
            total += c.getSaldo();
        }

        return total;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public Cuenta getCuenta(String codigo) {
        Cuenta c = null, cuenta;
        Iterator<Cuenta> iterador = cuentas.iterator();

        while (iterador.hasNext() && c == null) {
            cuenta = iterador.next();
            if (cuenta.getCodigo().equals(codigo)) {
                c = cuenta;
            }
        }
        
        if (c != null) {
            return c;
        } else {
            return null;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return nombre;
    }

}
