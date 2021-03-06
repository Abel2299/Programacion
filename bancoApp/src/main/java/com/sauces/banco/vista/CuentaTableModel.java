/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.banco.vista;

import com.sauces.banco.modelo.Cuenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daw1
 */
public class CuentaTableModel extends AbstractTableModel{

    private List<Cuenta> listado;
    private String[] columnas;

    public CuentaTableModel() {
        columnas = new String[]{"CODIGO, TITULAR, SALDO"};
        listado = new ArrayList<>();
    }

    public List<Cuenta> getCuentas() {
        return listado;
    }

    public void setCuentas(List<Cuenta> listado) {
        this.listado = listado;
        this.fireTableDataChanged();
    }

    public String[] getColumnas() {
        return columnas;
    }

    public void setColumnas(String[] columnas) {
        this.columnas = columnas;
    }
    
    
    
    @Override
    public int getRowCount() {
        return listado.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o = null;
        Cuenta c = listado.get(rowIndex);
        
        switch(columnIndex){
            case 0: o = c.getCodigo();
                break;
            case 1: o = c.getTitular();
                break;
            case 2: o = c.getSaldo();
                break;
        }
        return o;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clase=null;
        
        switch(columnIndex){
            case 0: clase = String.class;
                break;
            case 1: clase = String.class;
                break;
            case 2: clase = Float.class;
                break;
        }
        
        return clase;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    
}
