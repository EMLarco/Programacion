/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicacalculofigura;

/**
 *
 * @author xaldo
 */
public class Cuadrado extends Figura{
     private double lado;
    
    public Cuadrado(double lado) {
        this.lado = lado;
    }
    
    @Override
    public void calcularArea() {
        area = lado * lado;
        System.out.println("El area del cuadrado es: " + area);
    }
    
    @Override
    public void calcularPerimetro() {
        perimetro = 4 * lado;
        System.out.println("El perimetro del cuadrado es: " + perimetro);
    }
}