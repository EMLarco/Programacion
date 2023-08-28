/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicacalculofigura;

/**
 *
 * @author xaldo
 */
public class Rectangulo extends Figura {
     private double base;
    private double altura;
    
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public void calcularArea() {
        area = base * altura;
        System.out.println("El area del rectangulo es: " + area);
    }
    
    @Override
    public void calcularPerimetro() {
        perimetro = 2 * (base + altura);
        System.out.println("El perimetro del rectangulo es: " + perimetro);
    }
    
}
