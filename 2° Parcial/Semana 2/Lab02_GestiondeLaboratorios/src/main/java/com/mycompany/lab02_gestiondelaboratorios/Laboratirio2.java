
package com.mycompany.lab02_gestiondelaboratorios;

import java.util.*;


class Laboratorio2 extends Laboratorio {
    private String lugar;

    public Laboratorio2(String nombre, int capacidad, List<String> equipos, String lugar) {
        super(nombre, capacidad, equipos);
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }
}