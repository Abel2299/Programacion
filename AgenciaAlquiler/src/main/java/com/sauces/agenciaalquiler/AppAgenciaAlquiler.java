/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.agenciaalquiler;

import java.util.Scanner;

/**
 *
 * @author Abel
 */
public class AppAgenciaAlquiler {
    public static void main(String[] args) {
        
        Scanner teclado=new Scanner(System.in);
        AgenciaAlquiler aa = new AgenciaAlquiler("nombre");
        String nombre, matricula;
        int plazas, opcion, opcionMenuVehiculos;
        float capacidad;
        String grupo;
        Turismo turismo;
        Furgoneta furgoneta;
        Vehiculo vehiculo;

        do{
                System.out.println("AGENCIA DE ALQUILER");
                System.out.println("1. Crear vehiculo");
                System.out.println("2. Consultar vehiculo");
                System.out.println("3. Eliminar vehiculo");
                System.out.println("4. Listar vehiculo");
                System.out.println("5. Consultar alquiler mas barato");
                System.out.println("0. Salir");
                System.out.println("Seleccione opcion");
                opcion=teclado.nextInt();
                teclado.nextLine();
                switch(opcion){
                    case 1:
                        do{
                               System.out.println("CREAR VEHICULO");
                               System.out.println("1. Crear turismo");
                               System.out.println("2. Crear furgoneta");
                               System.out.println("0. Volver al menu principal");
                               opcionMenuVehiculos=teclado.nextInt();
                               teclado.nextLine();
                               switch(opcionMenuVehiculos){
                                   case 1:
                                       System.out.println("Introduzca matricula");
                                       matricula=teclado.nextLine();
                                       System.out.println("Introduzca grupo");
                                       grupo=teclado.nextLine();
                                       System.out.println("Introduzca plazas");
                                       plazas=teclado.nextInt();
                                       teclado.nextLine();
                                       turismo = new Turismo(matricula,Grupo.valueOf(grupo.toUpperCase()), plazas);
                                       System.out.println("Turismo creado");
                                       aa.incluirVehiculo(turismo);   
                                       break;
                                   case 2:
                                       System.out.println("Introduzca matricula");
                                       matricula=teclado.nextLine();
                                       System.out.println("Introduzca grupo");
                                       grupo=teclado.nextLine();
                                       System.out.println("Introduzca capadidad");
                                       capacidad=teclado.nextFloat();
                                       teclado.nextLine();
                                       furgoneta = new Furgoneta(matricula,Grupo.valueOf(grupo.toUpperCase()),capacidad);
                                       System.out.println("Furgoneta creada");
                                       aa.incluirVehiculo(furgoneta);
                                       break;
                               }   
                        }while(opcionMenuVehiculos!=0);
                        break;
                    case 2:
                          System.out.println("CONSULTAR VEHICULO");
                          System.out.println("Inserte matricula");
                          matricula=teclado.nextLine();
                          vehiculo = aa.consultarVehiculo(matricula);
                          if(vehiculo!=null){
                              System.out.println("Datos del vehiculo: ");
                              System.out.println("Matricula: "+vehiculo.getMatricula());
                              System.out.println("Grupo: "+vehiculo.getGrupo());
                          //Falta mostrar  plazas o capacidad
                          }
                          else{
                              System.out.println("Matricula no encontrada");
                          }
                        break;
                    case 3:
                        System.out.println("ELIMINAR VEHICULO");
                        System.out.println("Introduzca la matricula del vehiculo para borrar");
                        matricula=teclado.nextLine();
                        vehiculo = aa.consultarVehiculo(matricula);
                        if(vehiculo!=null){
                          aa.eliminarVehiculo(vehiculo);
                            System.out.println("Vehiculo eliminado");
                        }
                        else{
                            System.out.println("Matricula no encontrada");
                       }
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                                     
                }
        }while(opcion!=0);
        
        
        
    }
}
    

