/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.ud06;

/**
 *
 * @author daw1
 */
public class Tarifa {
    private String nombre;
    private float precioEstablecimiento;
    private float precioMinuto;
    private float precioSMS;
    private int datos;

    public Tarifa(String nombre, float precioEstablecimiento, float precioMinuto, float precioSMS, int datos) {
        this.nombre = nombre;
        this.precioEstablecimiento = precioEstablecimiento;
        this.precioMinuto = precioMinuto;
        this.precioSMS = precioSMS;
        this.datos = datos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioEstablecimiento() {
        return precioEstablecimiento;
    }

    public void setPrecioEstablecimiento(float precioEstablecimiento) {
        this.precioEstablecimiento = precioEstablecimiento;
    }

    public float getPrecioMinuto() {
        return precioMinuto;
    }

    public void setPrecioMinuto(float precioMinuto) {
        this.precioMinuto = precioMinuto;
    }

    public float getPrecioSMS() {
        return precioSMS;
    }

    public void setPrecioSMS(float precioSMS) {
        this.precioSMS = precioSMS;
    }

    public int getDatos() {
        return datos;
    }

    public void setDatos(int datos) {
        this.datos = datos;
    }
    
}
