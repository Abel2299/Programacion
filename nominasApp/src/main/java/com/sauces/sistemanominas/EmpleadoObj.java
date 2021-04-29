/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class EmpleadoObj implements EmpleadoDao {

    private final Path path;

    public EmpleadoObj(String path) {
        this.path = Paths.get(path);
    }

    public Path getPath() {
        return path;
    }
    
    @Override
    public List<Empleado> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int insertar(List<Empleado> listado) {
        System.out.println("Insertado"+ listado.size());
        int contadorEmpleadosGuardados = 0;
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(path.toString()))) {

            for (Empleado e : listado) {              //Recorrer lista con for each
                salida.writeObject(e);
                contadorEmpleadosGuardados++;
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return contadorEmpleadosGuardados;
    }

}
