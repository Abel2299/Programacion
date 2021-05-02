/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

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
public class VehiculoCsv implements VehiculoDao {

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
    public List<Vehiculo> listar() throws DaoException {
        List<Vehiculo> listado = new ArrayList<>();
        Vehiculo vehiculo = null;
        String linea, tipo, matricula, grupo;
        int plazas, capacidad;
        String[] tokens;

        try (BufferedReader fichero = Files.newBufferedReader(path)) {
            linea = fichero.readLine();

            while (linea != null) {
                tokens = linea.split(",");
                tipo = tokens[0];
                matricula = tokens[1];
                grupo = tokens[2];
                
                switch (tipo) {
                    case "Turismo":
                        plazas = Integer.parseInt(tokens[3]);
                        vehiculo = new Turismo(matricula, Grupo.valueOf(grupo), plazas);
                        break;
                    case "Furgoneta":
                        capacidad = Integer.parseInt(tokens[3]);
                        vehiculo = new Furgoneta(matricula,Grupo.valueOf(grupo),capacidad);
                }
                listado.add(vehiculo);
                linea = fichero.readLine();
            }
        } catch (NoSuchFileException nsfe) {
            throw new DaoException("Error en el nombre del fichero");
        } catch (NumberFormatException nfe ) {  //| ArrayIndexOutofBoundsException aiobe
            throw new DaoException("Formato de arvhivo incorrecto");
        }catch (IOException ex) {
            throw new DaoException(ex.toString());
        } catch (MatriculaException ex) {
            throw new DaoException(ex.getMessage());
        }

        return listado;
    }

    @Override
    public int insertar(List<Vehiculo> listado) throws DaoException {
        int n = 0;

        try (BufferedWriter fichero = Files.newBufferedWriter(path)) {

            for (Vehiculo v : listado) {
                fichero.write(v.getClass().getSimpleName() + "," + v.toString());
                fichero.newLine();
                n++;
            }

        } catch (IOException ex) {
            throw new DaoException(ex.getMessage());
        }

        return n;
    }

}
