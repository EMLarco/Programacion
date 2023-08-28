package com.mycompany.interfaces;

public class Circulo implements Figura, Dibujar, Rotar {
    
    double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }
   
    @Override
    public double calcularArea() {
        double pi=3.14;
        double resultado=pi*radio*radio;
        
        return resultado;
    }

    @Override
    public void Dibujar() {
        System.out.println("Vas a dibujar un circulo!");
    }

    @Override
    public void rodar() {
        System.out.println("Usted va rodar!");
    }
    
}
