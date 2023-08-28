/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicacalculofigura;

/**
 *
 * @author xaldo
 */
public class Paralelogramo extends Figura {
     private double base;
    private double altura;
    
    public Paralelogramo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public void calcularArea() {
        area = base * altura;
        System.out.println("El area del paralelogramo es: " + area);
    }
    
    @Override
    public void calcularPerimetro() {
        perimetro = 2 * (base + altura);
        System.out.println("El perimetro del paralelogramo es: " + perimetro);
    }
}
