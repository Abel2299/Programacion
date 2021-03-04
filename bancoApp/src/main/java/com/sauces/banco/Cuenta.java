/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.banco;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ambrosio
 */
public class Cuenta {
    
    private String codigo;
    private String titular;
    private float saldo;
    private List<Movimiento> movimientos;

    /**
     *
     * @param codigo
     * @param titular
     * @param saldo
     */
    public Cuenta(String codigo, String titular, float saldo) {
        if(saldo>=0){
            this.codigo = codigo;
            this.titular = titular;
            this.saldo = saldo;
            movimientos=new ArrayList<>();
            movimientos.add(new Movimiento(LocalDate.now(),'I',saldo,this.saldo));
        }
    }
   
    /**
     *
     * @return
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
    
    /**
     *
     * @param desde
     * @param hasta
     * @return
     */
    public List<Movimiento> getMovimientos(LocalDate desde,LocalDate hasta){
        List<Movimiento> listado=new ArrayList<>();
        
        for(Movimiento m: movimientos){
            if(m.getFecha().isAfter(desde) && m.getFecha().isBefore(hasta)){
                listado.add(m);
            }
        }
        
        return listado;
    }
   
    /**
     * Get the value of saldo
     *
     * @return the value of saldo
     */
    public float getSaldo() {
        return saldo;
    }
    /**
     * Set the value of saldo
     *
     * @param saldo new value of saldo
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }


    /**
     * Get the value of titular
     *
     * @return the value of titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Set the value of titular
     *
     * @param titular new value of titular
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }
    /**
     * Get the value of codigo
     *
     * @return the value of codigo
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Set the value of codigo
     *
     * @param codigo new value of codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return codigo + "," + titular + "," + saldo;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
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
        final Cuenta other = (Cuenta) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    /**
     *
     * @param cantidad
     */
    public void ingresar(float cantidad){
        if(cantidad>0){
            saldo+=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),'I',cantidad,saldo));
        }
    }
    
    /**
     *
     * @param cantidad
     */
    public void reintegrar(float cantidad){
        if(cantidad>0 && cantidad<=saldo){
            saldo-=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),'R',-cantidad,saldo));
        }
    }
    
    /**
     *
     * @param destino
     * @param cantidad
     */
    public void realizarTransferencia(Cuenta destino,float cantidad){
        if(destino!=null && cantidad>0 && cantidad<=this.saldo){
            this.saldo-=cantidad;
            destino.saldo+=cantidad;
            this.movimientos.add(new Movimiento(LocalDate.now(),'T',-cantidad,this.saldo));
            destino.movimientos.add(new Movimiento(LocalDate.now(),'T',cantidad,destino.saldo));
        }
    }
    
    /**
     *
     * @return
     */
    public String listarMovimientos(){
        StringBuilder salida=new StringBuilder();
        
        for(Movimiento m: movimientos){
            salida.append(m.toString());
            salida.append("\n");
        }
        
        return salida.toString();
    }
    
}
