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

    public Vivienda( String referencia, float superficie, int precio, TipoOperacion operacion, int dormitorios) throws ReferenciaException {
        super(referencia, superficie, precio, operacion);
        if(dormitorios<0){
            throw new IllegalArgumentException("Datos incorrectos");
        }
        this.dormitorios = dormitorios;
    }

    public int getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(int dormitorios) {
        if(dormitorios<0){
            throw new IllegalArgumentException("Datos incorrectos");
        }
        this.dormitorios = dormitorios;
    }

    @Override
    public String toString() {
        return super.toString()+", "+dormitorios;
    }
    
    @Override
    public float getComision() {
        float comision;
        
        if(dormitorios<=2){
            comision=getPrecio()*0.02f;
        }
        else{
            comision=getPrecio()*0.03f;
        }
        
        return comision;
    }
}
