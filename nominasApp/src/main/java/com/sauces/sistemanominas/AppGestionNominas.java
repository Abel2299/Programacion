package com.sauces.sistemanominas;

import java.util.Scanner;

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
        int opcion;
        String dni, nombre;
        float salario, salarioHoras;
        int horas;
        Empleado e = null;

        do {
            System.out.println("1. Crear empleado fijo");
            System.out.println("2. Crear empleado eventual");
            System.out.println("3. Consultar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Listar empleados");
            System.out.println("6. Listar empleados por sueldo");
            System.out.println("7. Consultar total salarios");
            System.out.println("8. Listado empleados fijos");
            System.out.println("9. Guardar empleados");
            System.out.println("10. Cargar empleados");
            System.out.println("0. Salir");
            System.out.println("Seleccione opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca DNI: ");
                    dni = teclado.nextLine();
                    System.out.println("Introduzca nombre: ");
                    nombre = teclado.nextLine();
                    System.out.println("Introduzca salario");
                    salario = teclado.nextFloat();
                    teclado.nextLine();
                    e = new EmpleadoFijo(dni, nombre, salario);
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
                    e = new EmpleadoEventual(dni, nombre, salarioHoras, horas);
                    if (sn.incluirEmpleado(e)) {
                        System.out.println("Empleado incluido en el sistema");
                    } else {
                        System.out.println("No se ha podido incluir al empleado en el sistema");
                    }
                    break;
                case 3:
                    System.out.println("DNI del empleado: ");
                    dni = teclado.nextLine();
                    e = sn.getEmpleado(dni);
                    if (e != null) {
                        System.out.println(e);
                    } else {
                        System.out.println("No existe un empleado con ese DNI");
                    }
                    break;
                case 4:
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
                case 5:
                    for (Empleado empleado : sn.listarEmpleados()) {
                        System.out.println(empleado);
                    }
                    break;
                case 6:
                    for (Empleado empleado : sn.listarEmpleadosPorSueldo()) {
                        System.out.println(empleado);
                    }
                    break;
                case 7:
                    System.out.println("Total" + sn.getTotalSalarios());
                    break;
                case 8:
                    System.out.println("Listado de empleados fijos");
                    for (Empleado empleado : sn.listarEmpleados()) {
                        if (empleado instanceof EmpleadoFijo) {
                            System.out.println(empleado);
                        }
                    }
                    break;
                case 9:
                    System.out.println("Guardar empleados");
                    String path = "Empleado.obj";
                    sn.setEmpleadoDao(new EmpleadoObj(path));
                    sn.guardarEmpleados();
                    break;
                case 10:
                    System.out.println("Cargar empleados");

                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Error en la seleccion");
            }
        } while (opcion != 0);
    }

}
