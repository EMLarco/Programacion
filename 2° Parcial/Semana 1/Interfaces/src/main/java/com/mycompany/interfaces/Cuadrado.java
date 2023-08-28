package com.mycompany.interfaces;

public class Cuadrado implements Figura, Dibujar {
    
    double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        double resultado=lado*lado;
        return resultado;
    }

    @Override
    public void Dibujar() {
        System.out.println("Vas a dibujar!");
    }
    
}
