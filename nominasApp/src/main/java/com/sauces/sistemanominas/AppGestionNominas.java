package com.sauces.sistemanominas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author daw1
 */
public class AppGestionNominas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SistemaNominas sn = new SistemaNominas();
        Scanner teclado = new Scanner(System.in);
        int opcion, opcionCrearEmpleado, opcionNombreArchivo, n;
        String dni, nombre;
        float salario, salarioHoras;
        int horas;
        Empleado e = null;
        String nombreArchivo;
        String extension;
        EmpleadoDao empleadoDao = null;
        int posicionPunto;
        LocalDate fechaEntrada = null, fechaSalida;
        LocalTime horaEntrada, horaSalida;
        Properties propiedadesRegistro = new Properties();
        Properties propiedadesFechas = new Properties();
        long segundosConectado = 0;
        String usuarioIntroducido, usuario = "", passwordIntroducido, password = "", fechaEntra = "";
        Path path = Paths.get("src/main/resources/Acceso.properties");

        try (BufferedReader br = Files.newBufferedReader(path)) {
            propiedadesRegistro.load(br);
            usuario = propiedadesRegistro.getProperty("Usuario");
            password = propiedadesRegistro.getProperty("Password");

            
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
       /*try (BufferedWriter bw=Files.newBufferedWriter(Paths.get("src/main/resources/Fechas.properties"))){
          //  propiedadesFechas.setProperty(fechaEntra, "23");
            propiedadesFechas.store(bw, "comentario");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }*/

        System.out.println("Introduzca usuario: ");
        usuarioIntroducido = teclado.nextLine();
        System.out.println("Introduzca contraseña: ");
        passwordIntroducido = teclado.nextLine();
        
        while (!usuarioIntroducido.equals(usuario) || !passwordIntroducido.equals(password)) {   //Aqui hay que leer con el registro

            System.out.println("Usuario o contraseña incorrecta");
            System.out.println("Introduzca usuario: ");
            usuarioIntroducido = teclado.nextLine();
            System.out.println("Introduzca contraseña: ");
            passwordIntroducido = teclado.nextLine();
        }
        
        fechaEntrada = LocalDate.now();
        horaEntrada = LocalTime.now();
        
        do {
            System.out.println("1. Crear empleado");
            System.out.println("2. Consultar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Listar empleados");
            System.out.println("5. Listar empleados por sueldo");
            System.out.println("6. Consultar total salarios");
            System.out.println("7. Listado empleados fijos");
            System.out.println("8. Guardar empleados");
            System.out.println("9. Cargar empleados");
            System.out.println("0. Salir");
            System.out.println("Seleccione opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    do {
                        System.out.println("CREAR EMPLEADO");
                        System.out.println("1. Crear empleado fijo");
                        System.out.println("2. Crear empleado eventual");
                        System.out.println("0.- Volver al menu principal");
                        opcionCrearEmpleado = teclado.nextInt();
                        teclado.nextLine();
                        switch (opcionCrearEmpleado) {
                            case 1:
                                System.out.println("Introduzca DNI: ");
                                dni = teclado.nextLine();
                                System.out.println("Introduzca nombre: ");
                                nombre = teclado.nextLine();
                                System.out.println("Introduzca salario");
                                salario = teclado.nextFloat();
                                teclado.nextLine();
                                try {
                                    e = new EmpleadoFijo(dni, nombre, salario);
                                } catch (DniException de) {
                                    System.out.println("Dni incorrecto");
                                }
                                if (sn.incluirEmpleado(e)) {
                                    System.out.println("Empleado incluido en el sistema");
                                } else {
                                    System.out.println("No se ha podido incluir al empleado en el sistema");
                                }
                                break;

                            case 2:
                                System.out.println("Introduzca DNI: ");
                                dni = teclado.nextLine();
                                System.out.println("Introduzca nombre: ");
                                nombre = teclado.nextLine();
                                System.out.println("Introduzca salario por hora");
                                salarioHoras = teclado.nextFloat();
                                teclado.nextLine();
                                System.out.println("Introduzca horas trabajadas");
                                horas = teclado.nextInt();
                                 {
                                    try {
                                        e = new EmpleadoEventual(dni, nombre, salarioHoras, horas);
                                    } catch (DniException ex) {
                                        Logger.getLogger(AppGestionNominas.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                if (sn.incluirEmpleado(e)) {
                                    System.out.println("Empleado incluido en el sistema");
                                } else {
                                    System.out.println("No se ha podido incluir al empleado en el sistema");
                                }
                                break;

                        }
                    } while (opcionCrearEmpleado != 0);
                    break;
                case 2:
                    System.out.println("DNI del empleado: ");
                    dni = teclado.nextLine();
                    e = sn.getEmpleado(dni);
                    if (e != null) {
                        System.out.println(e);
                    } else {
                        System.out.println("No existe un empleado con ese DNI");
                    }
                    break;
                case 3:
                    System.out.println("DNI del empleado a eliminar: ");
                    dni = teclado.nextLine();
                    e = sn.getEmpleado(dni);
                    if (e != null) {
                        sn.eliminarEmpleado(e);
                        System.out.println("Empleado eliminado del sistema");
                    } else {
                        System.out.println("No existe un empleado con ese DNI");
                    }
                    break;
                case 4:
                    for (Empleado empleado : sn.listarEmpleados()) {
                        System.out.println(empleado);
                    }
                    break;
                case 5:
                    for (Empleado empleado : sn.listarEmpleadosPorSueldo()) {
                        System.out.println(empleado);
                    }
                    break;
                case 6:
                    System.out.println("Total" + sn.getTotalSalarios());
                    break;
                case 7:
                    System.out.println("Listado de empleados fijos");
                    for (Empleado empleado : sn.listarEmpleados()) {
                        if (empleado instanceof EmpleadoFijo) {
                            System.out.println(empleado);
                        }
                    }
                    break;
                case 8:
                    do {
                        /*
                        System.out.println("Guardar empleados");
                        nombreArchivo=teclado.nextLine();
                        posicionPunto=nombreArchivo.lastIndexOf('.');
                        if(posicionPunto!=-1){
                            extension=nombreArchivo.substring(posicionPunto);
                        
                        switch(extension){
                        case ".csv": 
                            empleadoDao = new EmpleadoCsv(nombreArchivo);
                            break;
                        
                        case ".obj":
                            empleadoDao = new EmpleadoCsv(nombreArchivo);
                            break;
                        case ".json":
                            empleadoDao = new EmpleadoCsv(nombreArchivo);
                            break;
                        case ".xml":
                            empleadoDao = new EmpleadoCsv(nombreArchivo);
                            break;
                        default: System.out.println("Extension incorrecta");
                        }
                         */
                        System.out.println("Guardar empleados");
                        System.out.println("ELEGIR FORMATO");
                        System.out.println("1. csv");
                        System.out.println("2. obj");
                        System.out.println("3. json");
                        System.out.println("4. xml");
                        System.out.println("0.- Salir al menu principal");
                        opcionNombreArchivo = teclado.nextInt();
                        teclado.nextLine();

                        switch (opcionNombreArchivo) {
                            case 1:
                                System.out.println("Introduzca nombre archivo: ");
                                nombreArchivo = teclado.nextLine();
                                empleadoDao = new EmpleadoCsv(nombreArchivo);
                                System.out.println("Guardado");
                                break;

                            case 2:
                                System.out.println("Introduzca nombre archivo: ");
                                nombreArchivo = teclado.nextLine();
                                empleadoDao = new EmpleadoObj(nombreArchivo);
                                System.out.println("Guardado");
                                break;
                            case 3:
                                System.out.println("Introduzca nombre archivo: ");
                                nombreArchivo = teclado.nextLine();
                                empleadoDao = new EmpleadoJson(nombreArchivo);
                                System.out.println("Guardado");
                                break;
                            case 4:
                                System.out.println("Introduzca nombre archivo: ");
                                nombreArchivo = teclado.nextLine();
                                empleadoDao = new EmpleadoXml(nombreArchivo);
                                System.out.println("Guardado");
                                break;
                            default:
                                System.out.println("Extension incorrecta");

                        }
                        try {
                            if (empleadoDao != null) {
                                sn.setEmpleadoDao(empleadoDao);
                                n = sn.guardarEmpleados();
                                System.out.println("Se han almacenado " + n + " empleados");
                            }
                        } catch (DaoException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } while (opcionNombreArchivo != 0);

                    break;

                case 9:

                    do {
                        System.out.println("Cargar empleados");
                        System.out.println("ELEGIR FORMATO");
                        System.out.println("1. csv");
                        System.out.println("2. obj");
                        System.out.println("3. json");
                        System.out.println("4. xml");
                        System.out.println("0.- Salir al menu principal");
                        opcionNombreArchivo = teclado.nextInt();
                        teclado.nextLine();

                        /*
                        System.out.println("Guardar empleados");
                        System.out.println("Introduce nombre archivo");
                        nombreArchivo=teclado.nextLine();
                        posicionPunto=nombreArchivo.lastIndexOf('.');
                        if(posicionPunto!=-1){
                            extension=nombreArchivo.substring(posicionPunto);
                        
                        switch(extension){
                        case ".csv": 
                            empleadoDao = new EmpleadoCsv(nombreArchivo);
                            break;
                        
                        case ".obj":
                            empleadoDao = new EmpleadoCsv(nombreArchivo);
                            break;
                        case ".json":
                            empleadoDao = new EmpleadoCsv(nombreArchivo);
                            break;
                        case ".xml":
                            empleadoDao = new EmpleadoCsv(nombreArchivo);
                            break;
                        }
                         */
                        switch (opcionNombreArchivo) {
                            case 1:
                                System.out.println("Introduzca nombre archivo: ");
                                nombreArchivo = teclado.nextLine();
                                empleadoDao = new EmpleadoCsv(nombreArchivo);
                                System.out.println("Cargado");
                                break;

                            case 2:
                                System.out.println("Introduzca nombre archivo: ");
                                nombreArchivo = teclado.nextLine();
                                empleadoDao = new EmpleadoObj(nombreArchivo);
                                System.out.println("Cargado");
                                break;
                            case 3:
                                System.out.println("Introduzca nombre archivo: ");
                                nombreArchivo = teclado.nextLine();
                                empleadoDao = new EmpleadoJson(nombreArchivo);
                                System.out.println("Cargado");
                                break;
                            case 4:
                                System.out.println("Introduzca nombre archivo: ");
                                nombreArchivo = teclado.nextLine();
                                empleadoDao = new EmpleadoXml(nombreArchivo);
                                System.out.println("Cargado");
                                break;
                            default:

                        }
                        try {
                            if (empleadoDao != null) {
                                sn.setEmpleadoDao(empleadoDao);
                                n = sn.cargarEmpleados();
                                System.out.println("Se han cargado " + n + " empleados");
                            }
                        } catch (DaoException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } while (opcionNombreArchivo != 0);

                    break;

                case 0:
                    System.out.println("Adios");
                    fechaSalida = LocalDate.now();
                    horaSalida = LocalTime.now();
                    segundosConectado = Duration.between(LocalDateTime.of(fechaEntrada, horaEntrada), LocalDateTime.of(fechaSalida, horaSalida)).toSeconds();         //Control de la aplicacion (tiempo dentro de la aplicacion.

                    //luego cambiar a properties
                    System.out.println("Fecha entrada: " + fechaEntrada);
                    System.out.println("Hora entrada: " + horaEntrada);
                    System.out.println("Tiempo conectado: " + segundosConectado + " segundos");
                    break;
                default:
                    System.out.println("Error en la seleccion");
            }
        } while (opcion != 0);
    }

}