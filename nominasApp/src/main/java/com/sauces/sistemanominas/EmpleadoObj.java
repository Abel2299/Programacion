/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abel
 */
public class EmpleadoObj implements EmpleadoDao {

    private Path path;

    public EmpleadoObj(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }

    @Override
    public List<Empleado> listar() throws DaoException {
        List<Empleado> listaEmpleados = new ArrayList<>();
        Empleado empleado;
        try (InputStream is = Files.newInputStream(path);
                ObjectInputStream entrada = new ObjectInputStream(is)) {

            while (is.available() > 0) {
                empleado = (Empleado) entrada.readObject();
                listaEmpleados.add(empleado);
            }

        } catch (EOFException eofe) {
            throw new DaoException(eofe.toString());
        } catch (IOException ex) {
            throw new DaoException(ex.toString());
        } catch (ClassNotFoundException cnfe) {
            throw new DaoException("Error en el nombre del fichero");
        }
        return listaEmpleados;
    }

    @Override
    public int insertar(List<Empleado> listado) {
        int contadorEmpleadosGuardados = 0;
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(path.toString()))){

            for (Empleado e : listado) {              //Recorrer lista con for each
                salida.writeObject(e);
                contadorEmpleadosGuardados++;
            }

        } catch (IOException ex) {
            System.out.println("Error de entrada salida");
        }
        return contadorEmpleadosGuardados;
    }

}
