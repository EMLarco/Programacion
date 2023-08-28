
package com.mycompany.lab02_gestiondelaboratorios;

import java.util.*;




class Laboratorio1 extends Laboratorio {
    private String espacio;

    public Laboratorio1(String nombre, int capacidad, List<String> equipos, String espacio) {
        super(nombre, capacidad, equipos);
        this.espacio = espacio;
    }

    public String getEspacio() {
        return espacio;
    }
}