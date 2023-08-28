package com.mycompany.interfaces;

public class Cilindro implements Rotar,Figura,Dibujar{

     double altura,radio;

    public Cilindro(double pi, double radio) {
        this.radio = radio;
        this.altura = altura;
    }
     
    @Override
    public void rodar() {
        System.out.println("Usted va a empezar a rodar!");
    }

    @Override
    public double calcularArea() {
        double pi=3.1416;
        double resultado=(2*pi*radio*radio)+(2*pi*radio*altura);
        return resultado;
    }

    @Override
    public void Dibujar() {
        System.out.println("Usted va a dibujar un cilindro");
    }
    
}
