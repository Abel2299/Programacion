/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

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
 * @author Alex
 */
public class EmpleadoXml implements EmpleadoDao {

    Path path;

    public EmpleadoXml(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public List<Empleado> listar() throws DaoException {
        List<Empleado> listado = new ArrayList<>();

        //Creamos un objeto de la clase XStream:
        XStream 
        xstream=new XStream(new DomDriver());
        //Configuración del objeto:
        XStream.setupDefaultSecurity(xstream);

        xstream.allowTypeHierarchy(EmpleadoFijo.class);
        xstream.allowTypeHierarchy(EmpleadoEventual.class);

        try ( BufferedReader fichero = Files.newBufferedReader(path);) {
            
            listado = (List<Empleado>) xstream.fromXML(fichero);
            
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
    public int insertar(List<Empleado> listado) throws DaoException {
        int n = 0;

        //Creamos un objeto de la clase XStream:
        XStream xstream = new XStream(new DomDriver());

        //Configuración del objeto:
        XStream.setupDefaultSecurity(xstream);

        xstream.allowTypeHierarchy(EmpleadoFijo.class);
        xstream.allowTypeHierarchy(EmpleadoEventual.class);

        //Hacemos las operaciones
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
