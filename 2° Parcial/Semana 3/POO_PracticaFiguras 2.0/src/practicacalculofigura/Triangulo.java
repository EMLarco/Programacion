/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicacalculofigura;

/**
 *
 * @author xaldo
 */
public class Triangulo extends Figura {
    private double base;
    private double altura;
    
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public void calcularArea() {
        area = (base * altura) / 2;
        System.out.println("El area del triangulo es: " + area);
    }
    
    @Override
    public void calcularPerimetro() {
        // Suponiendo que es un triángulo equilátero
        perimetro = 3 * base;
        System.out.println("El perimetro del triangulo es: " + perimetro);
    }
    
}
