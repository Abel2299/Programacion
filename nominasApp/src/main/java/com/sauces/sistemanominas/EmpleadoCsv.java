/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

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
public class EmpleadoCsv implements EmpleadoDao {

    private Path path;

    /**
     * Get the value of path
     *
     * @return the value of path
     */
    public Path getPath() {
        return path;
    }

    /**
     * Set the value of path
     *
     * @param path new value of path
     */
    public void setPath(Path path) {
        this.path = path;
    }

    public EmpleadoCsv(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public List<Empleado> listar() throws DaoException {
        List<Empleado> listado = new ArrayList<>();
        Empleado empleado = null;
        String linea;
        String tipo, dni, nombre;
        float salario = 0, salarioHora;
        int horas;
        String[] tokens;
        try ( BufferedReader fichero = Files.newBufferedReader(path)) {
            linea = fichero.readLine();
            while (linea != null) {

                tokens = linea.split(",");
                tipo = tokens[0];
                dni = tokens[1];
                nombre = tokens[2];
                switch (tipo) {
                    case "EmpleadoFijo":
                        salario = Float.parseFloat(tokens[3]);
                        empleado = new EmpleadoFijo(dni, nombre, salario);
                        break;
                    case "EmpleadoEventual":
                        salarioHora = Float.parseFloat(tokens[3]);
                        horas = Integer.parseInt(tokens[4]);
                        empleado = new EmpleadoEventual(dni, nombre, salario, horas);
                        break;
                    default: throw new DaoException("Formato de archivo incorrecto");
                }
                listado.add(empleado);
                linea = fichero.readLine();
            }
        } catch (NoSuchFileException nsfe) {
            throw new DaoException("Error en el nombre del fichero");
        } catch (NumberFormatException nfe ) {  //| ArrayIndexOutofBoundsException aiobe
            throw new DaoException("Formato de arvhivo incorrecto");
        } catch (IOException ex) {
            throw new DaoException(ex.toString());
        } catch (DniException ex) {
            throw new DaoException(ex.getMessage());
        }

        return listado;
    }

    @Override
    public int insertar(List<Empleado> listado) throws DaoException {
        int n = 0;
        try ( BufferedWriter fichero = Files.newBufferedWriter(path)) {
            for (Empleado e : listado) {
                fichero.write(e.getClass().getSimpleName() + "," + e.toString());
                fichero.newLine();
                n++;
            }
        } catch (NoSuchFileException nsfe) {
            throw new DaoException("Error en el nombre del fichero");
        } catch (IOException ex) {
            throw new DaoException("Error de entrada salida");
        }
        return n;
    }

}
