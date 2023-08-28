package com.mycompany.interfaces;

import java.util.*;

public class Interfaces {

    public static void main(String[] args) {

        Scanner CalA = new Scanner(System.in);
        
        System.out.println("Bienvenido al programa de cálculo de áreas");
        System.out.println("Por favor, elija el tipo de figura:");
        System.out.println("1. Cuadrado");
        System.out.println("2. Circulo");
        System.out.println("3. Cilindro");
        System.out.print("Ingrese el número correspondiente a la figura: ");
        
        int opcion = CalA.nextInt();
        
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el lado del cuadrado: ");
                double ladoCuadrado = CalA.nextDouble();
                Cuadrado cuadrado = new Cuadrado(ladoCuadrado);
                double areaCuadrado = cuadrado.calcularArea();
                System.out.println("El área del cuadrado es: " + areaCuadrado);
                break;
            case 2:
                System.out.print("Ingrese el radio del círculo: ");
                double radioCirculo = CalA.nextDouble();
                Circulo circulo = new Circulo(radioCirculo);
                double areaCirculo = circulo.calcularArea();
                System.out.println("El área del círculo es: " + areaCirculo);
                break;
            case 3:
                System.out.print("Ingrese el radio del cilindro: ");
                double radioCilindro = CalA.nextDouble();
                System.out.print("Ingrese la altura del cilindro: ");
                double alturaCilindro = CalA.nextDouble();
                Cilindro cilindro = new Cilindro(radioCilindro, alturaCilindro);
                double areaCilindro = cilindro.calcularArea();
                System.out.println("El área del cilindro es: " + areaCilindro);
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        
        CalA.close();
    }

}

    

