/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class VehiculoObj implements VehiculoDao{
    
    public Path path;

    public VehiculoObj(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public List<Vehiculo> listar() throws DaoException {
        List<Vehiculo> listaVehiculo = new ArrayList<>();
        Vehiculo vehiculo;
        try (InputStream is = Files.newInputStream(path);
                ObjectInputStream entrada = new ObjectInputStream(is)) {

            while (is.available() > 0) {
                vehiculo = (Vehiculo) entrada.readObject();
                listaVehiculo.add(vehiculo);
            }

        } catch (EOFException eofe) {
            throw new DaoException(eofe.toString());
        } catch (IOException ex) {
            throw new DaoException(ex.toString());
        } catch (ClassNotFoundException cnfe) {
            throw new DaoException("Error en el nombre del fichero");
        }
        return listaVehiculo;
    }

    @Override
    public int insertar(List<Vehiculo> listado) throws DaoException {
        int contadorVehiculosGuardados = 0;
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(path.toString()))){

            for (Vehiculo e : listado) {              //Recorrer lista con for each
                salida.writeObject(e);
                contadorVehiculosGuardados++;
            }

        } catch (IOException ex) {
            System.out.println("Error de entrada salida");
        }
        return contadorVehiculosGuardados;
    }
    
    
    
}
