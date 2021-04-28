/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daw1
 */
public class VehiculoCsv implements VehiculoDao{
    
    public Path path;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public VehiculoCsv(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public List<Vehiculo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(List<Vehiculo> listado) throws DaoException {
        int n=0;
        
        try(BufferedWriter fichero = Files.newBufferedWriter(path)){
            
            for(Vehiculo v: listado){
                fichero.write(v.getClass().getSimpleName()+", "+v.toString());
                fichero.newLine();
                n++;
            }
            
        }catch (IOException ex) {
             throw new DaoException(ex.getMessage());
        }
        
        return n;
    }   
    
    
    
}
