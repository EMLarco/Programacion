package com.mycompany.lab02_gestiondelaboratorios;

import java.util.*;

class Laboratorio {
    private String nombre;
    private int capacidad;
    private List<String> equipos;

    public Laboratorio(String nombre, int capacidad, List<String> equipos) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.equipos = equipos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public List<String> getEquipos() {
        return equipos;
    }

    public boolean verificarDisponibilidad(String horario, List<Asignatura> asignaturas) {
        for (Asignatura asignatura : asignaturas) {
            if (asignatura.getHorario().equals(horario) && asignatura.getLaboratorioAsignado() == this) {
                return false; // El horario está ocupado
            }
        }
        return true; // El horario está disponible
    }

}