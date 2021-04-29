/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.StreamException;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daw1
 */
public class VehiculoXml implements VehiculoDao{

    Path path;

    public VehiculoXml(String path) {
        this.path = Paths.get(path);
    }
    
    @Override
    public List<Vehiculo> listar() throws DaoException {
        List<Vehiculo> listado = new ArrayList<>();
        
        XStream xstream = new XStream(new DomDriver());
        
        XStream.setupDefaultSecurity(xstream);
        
        xstream.allowTypeHierarchy(Turismo.class);
        xstream.allowTypeHierarchy(Furgoneta.class);
        
        try(BufferedReader fichero=Files.newBufferedReader(path)){
            listado = (List<Vehiculo>) xstream.fromXML(fichero);
        }catch(NoSuchFileException nsfe){
            throw new DaoException("Error en el nombre del fichero");
        }catch(StreamException se){
            throw new DaoException("Formato de archivo incorrecto");
        } 
        catch (IOException ex) {
            throw new DaoException(ex.toString());
        }
       
        
        return listado;
    }

    @Override
    public int insertar(List<Vehiculo> listado) throws DaoException {
        int n=0;
        
        XStream xstream = new XStream(new DomDriver());
        
        XStream.setupDefaultSecurity(xstream);
        
        xstream.allowTypeHierarchy(Turismo.class);
        xstream.allowTypeHierarchy(Furgoneta.class);
        
         try ( BufferedWriter fichero = Files.newBufferedWriter(path)) {
            xstream.toXML(listado, fichero);
        } catch (NoSuchFileException nsfe) {
            throw new DaoException("Error en el nombre del fichero");
        } catch (IOException ex) {
            throw new DaoException("Error de entrada salida");
        }
        
        return n;
    }
    
}
