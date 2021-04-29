/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.sauces.ud06;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author daw1
 */
public class LineaMovil implements Comparable<LineaMovil>{
    private String numero;
    private String titular;
    private Tarifa tarifa;
    private int datosDisponibles;
    private List<Consumo> consumos = new ArrayList<>();

    public LineaMovil(String numero, String titular, Tarifa tarifa) throws NumeroFormatException {
        this.numero = numero;
        this.titular = titular;
        this.tarifa = tarifa;
        this.datosDisponibles = iniciarDatosDisponibles();
        consumos=new ArrayList<>();
        Pattern patron = Pattern.compile("^[67][0-9]{8}");
        Matcher mat = patron.matcher(numero);
        if(!mat.matches()){
            throw new NumeroFormatException("Numero incorrecto");
        }
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public int getDatosDisponibles() {
        return datosDisponibles;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
    
    public int iniciarDatosDisponibles(){
        return tarifa.getDatos()*1000;
    }

    public float registrarLlamada(LocalDateTime fechaHora, String numero, int duracion){
        if(duracion<0){
            throw new IllegalArgumentException("Duracion incorrecta");
        }
        
        float importe;
        importe=tarifa.getPrecioEstablecimiento()+(duracion/60)*tarifa.getPrecioMinuto();
        
        Llamada llamada = new Llamada(fechaHora, importe, numero, duracion);
        
        consumos.add(llamada);

        return importe; 
    }

    public float registrarSMS(LocalDateTime fechaHora, String numero){
        float importe;
        importe=tarifa.getPrecioSMS();
        
        SMS sms = new SMS(fechaHora, importe, numero);
        
        consumos.add(sms);
        
        return importe;
    }
    
    public int registrarConsumoDatos(LocalDateTime fechaHora, int volumen) throws DatosException{
        
        if(volumen<0 || volumen>datosDisponibles){
           throw new DatosException("Datos incorrecto");
        }
        
        float importe = 0;
        /*Datos datos = new Datos(fechaHora, importe, volumen);*/
        
        datosDisponibles=datosDisponibles - volumen;
       /* consumos.add(datos);        Creamos el new directamente aqui*/
       
        consumos.add(new Datos(fechaHora, importe, volumen)); 
        return datosDisponibles;
    }
    
    public String getConsumo(TipoConsumo tipoConsumo){
        String tipoconsumo;
        Iterator<Consumo> iterador=consumos.iterator();
                
         while(iterador.hasNext()){
             
        }
         return "";   
    }
    
    public Consumo getConsumoMayorImporte(){        
        return Collections.max(consumos, new ComparadorImporte());
        
    }
    
    public List<Consumo> listarConsumos(LocalDateTime desde, LocalDateTime hasta){
        for (int i=0;i<consumos.size();i++) {
            System.out.println(consumos.get(i));
        }
        
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
           if(obj instanceof LineaMovil){
            LineaMovil lm=(LineaMovil)obj;
            if(this.numero.equals(lm.numero)){
                return true;
            }
        }    
        }
        return false;
    }
    
    @Override
    public int compareTo(LineaMovil o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
