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
public class Local extends Inmueble{
    private float escaparate;

    public Local(String referencia, float superficie, int precio, TipoOperacion operacion, float escaparate) {
        super(referencia, superficie, precio, operacion);
        this.escaparate = escaparate;
    }

    public float getEscaparate() {
        return escaparate;
    }

    public void setEscaparate(float escaparate) {
        if(escaparate<0){
            throw new IllegalArgumentException("Datos incorrectos");
        }
        this.escaparate = escaparate;
    }    
    
    @Override
    public float getComision() {
        float nuevoPrecio;
        
        
        
        return nuevoPrecio;
    }

    @Override
    public boolean referenciaValida(String referencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
