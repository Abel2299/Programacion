/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.inmobiliaria;

/**
 *
 * @author daw1
 */
public class Vivienda extends Inmueble{
    
    private int dormitorios;

    public Vivienda( String referencia, float superficie, int precio, TipoOperacion operacion, int dormitorios) {
        super(referencia, superficie, precio, operacion);
        this.dormitorios = dormitorios;
    }

    public int getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(int dormitorios) {
        this.dormitorios = dormitorios;
    }

    @Override
    public String toString() {
        return "Vivienda{" + "dormitorios=" + dormitorios + '}';
    }

    
    
    @Override
    public float getComision() {
        return
    }

    @Override
    public boolean referenciaValida(String referencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
