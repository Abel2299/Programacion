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

    public Local(String referencia, float superficie, int precio, TipoOperacion operacion, float escaparate) throws ReferenciaException {
        super(referencia, superficie, precio, operacion);
        if(escaparate < 0){
            throw new IllegalArgumentException("Valor incorrecto");
        }
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
    public String toString() {
        return super.toString()+", "+escaparate;
    }

    @Override
    public float getComision() {
        return getPrecio()*0.01f;
    }
}
