/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab02_gestiondelaboratorios;

import java.util.*;

public class Lab02_GestiondeLaboratorios {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir cantidad de laboratorios
        System.out.print("Ingrese la cantidad de laboratorios: ");
        int cantidadLaboratorios = scanner.nextInt();

        List<Laboratorio> laboratorios = new ArrayList<>();

        // Pedir información de cada laboratorio
        for (int i = 0; i < cantidadLaboratorios; i++) {
            System.out.println("\nLaboratorio " + (i + 1));
            System.out.print("Ingrese el nombre del laboratorio: ");
            String nombreLaboratorio = scanner.next();

            System.out.print("Ingrese la capacidad del laboratorio: ");
            int capacidadLaboratorio = scanner.nextInt();

            System.out.print("Ingrese la cantidad de equipos disponibles: ");
            int cantidadEquipos = scanner.nextInt();

            List<String> equipos = new ArrayList<>();
            for (int j = 0; j < cantidadEquipos; j++) {
                System.out.print("Ingrese el nombre del equipo " + (j + 1) + ": ");
                String equipo = scanner.next();
                equipos.add(equipo);
            }

            // Agregar laboratorio a la lista
            laboratorios.add(new Laboratorio(nombreLaboratorio, capacidadLaboratorio, equipos));
        }

        // Pedir cantidad de asignaturas
        System.out.print("\nIngrese la cantidad de asignaturas: ");
        int cantidadAsignaturas = scanner.nextInt();

        List<Asignatura> asignaturas = new ArrayList<>();

        // Pedir información de cada asignatura
        for (int i = 0; i < cantidadAsignaturas; i++) {
            System.out.println("\nAsignatura " + (i + 1));
            System.out.print("Ingrese el nombre de la asignatura: ");
            String nombreAsignatura = scanner.next();

            System.out.print("Ingrese el horario de la asignatura: ");
            String horarioAsignatura = scanner.next();

            System.out.print("Ingrese el número del laboratorio asignado (1-" + cantidadLaboratorios + "): ");
            int numeroLaboratorio = scanner.nextInt();

            // Obtener el laboratorio asignado
            Laboratorio laboratorioAsignado = laboratorios.get(numeroLaboratorio - 1);

            // Verificar disponibilidad del horario en el laboratorio asignado
            boolean disponibilidad = laboratorioAsignado.verificarDisponibilidad(horarioAsignatura, asignaturas);

            if (!disponibilidad) {
                System.out.println("El laboratorio está ocupado en el horario indicado. Asignatura no válida.");
                continue; // Salta a la siguiente iteración del bucle sin agregar la asignatura
            }

            // Agregar asignatura a la lista
            asignaturas.add(new Asignatura(nombreAsignatura, horarioAsignatura, laboratorioAsignado));
        }

        // Mostrar información de los laboratorios
        System.out.println("\nInformación de los laboratorios:");
        for (Laboratorio laboratorio : laboratorios) {
            System.out.println("\nNombre: " + laboratorio.getNombre());
            System.out.println("Capacidad: " + laboratorio.getCapacidad());
            System.out.println("Equipos disponibles: " + laboratorio.getEquipos());
        }

        // Mostrar información de las asignaturas y laboratorios asignados
        System.out.println("\nInformación de las asignaturas:");
        for (Asignatura asignatura : asignaturas) {
            System.out.println("\nAsignatura: " + asignatura.getNombre());
            System.out.println("Horario: " + asignatura.getHorario());
            System.out.println("Laboratorio asignado: " + asignatura.getLaboratorioAsignado().getNombre());
        }

        scanner.close();
    }
}
