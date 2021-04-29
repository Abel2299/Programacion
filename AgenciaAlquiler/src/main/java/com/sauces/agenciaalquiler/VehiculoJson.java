/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class VehiculoJson implements VehiculoDao {

    Path path;
    int n;

    public VehiculoJson(String path) {
        this.path = Paths.get(path);
    }

    @Override
    public List<Vehiculo> listar() throws DaoException {
        List<Vehiculo> listado = new ArrayList<>();
        Type tipo = new TypeToken<List<Vehiculo>>() {}.getType();
               
        RuntimeTypeAdapterFactory<Vehiculo> vehiculoAdapter=RuntimeTypeAdapterFactory.of(Vehiculo.class,"type");
        
        vehiculoAdapter.registerSubtype(Turismo.class, "Turismo");
        vehiculoAdapter.registerSubtype(Furgoneta.class, "Furgoneta");
        
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(vehiculoAdapter);
        
        Gson gson = builder.create();
        
        try ( BufferedReader fichero = Files.newBufferedReader(path)) {
            listado = gson.fromJson(fichero, tipo);
        } catch (NoSuchFileException nsfe) {
            throw new DaoException("Error en el nombre del fichero");
        } catch (JsonParseException jpe) {
            throw new DaoException("Formato de archivo incorrecto");
        } catch (IOException ex) {
            throw new DaoException("Error de entrada salida");
        }
        
        return listado;
    }

    @Override
    public int insertar(List<Vehiculo> listado) throws DaoException {
        java.lang.reflect.Type tipo = new com.google.gson.reflect.TypeToken<List<Vehiculo>>() {
        }.getType();

        RuntimeTypeAdapterFactory<Vehiculo> vehiculoAdapter
                = RuntimeTypeAdapterFactory.of(Vehiculo.class, "type");

        vehiculoAdapter.registerSubtype(Turismo.class, "Turismo");
        vehiculoAdapter.registerSubtype(Furgoneta.class, "Furgoneta");

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.registerTypeAdapterFactory(vehiculoAdapter);

        Gson gson = builder.create();

        try ( BufferedWriter fichero = Files.newBufferedWriter(path)) {
            gson.toJson(listado, tipo, fichero);
            n = listado.size();
        } catch (NoSuchFileException nsfe) {
            throw new DaoException("Error en el nombre del fichero");
        } catch (IOException ex) {
            throw new DaoException("Error de entrada salida");
        }

        return n;
    }

}
