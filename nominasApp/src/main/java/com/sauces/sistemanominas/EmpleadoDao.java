/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.sistemanominas;

import java.util.List;

/**
 *
 * @author Abel
 */
public interface EmpleadoDao {
    
    public List<Empleado> listar() throws DaoException;
    public int insertar(List<Empleado> listado) throws DaoException;
    
}
