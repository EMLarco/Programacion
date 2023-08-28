/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicacalculofigura;

import java.util.Scanner;

/**
 *
 * @author ESPE
 */
public class PracticaCalculoFigura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Elegir una opcion:");
            System.out.println("1. Cuadrado");
            System.out.println("2. Triangulo");
            System.out.println("3. Rectangulo");
            System.out.println("4. Paralelogramo");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double ladoCuadrado = sc.nextDouble();
                    Cuadrado cuadrado = new Cuadrado(ladoCuadrado);
                    cuadrado.calcularArea();
                    cuadrado.calcularPerimetro();
                    break;
                case 2:
                    System.out.print("Ingrese la base del triangulo: ");
                    double baseTriangulo = sc.nextDouble();
                    System.out.print("Ingrese la altura del triangulo: ");
                    double alturaTriangulo = sc.nextDouble();
                    Triangulo triangulo = new Triangulo(baseTriangulo, alturaTriangulo);
                    triangulo.calcularArea();
                    triangulo.calcularPerimetro();
                    break;
                case 3:
                    System.out.print("Ingrese la base del rectangulo: ");
                    double baseRectangulo = sc.nextDouble();
                    System.out.print("Ingrese la altura del rectangulo: ");
                    double alturaRectangulo = sc.nextDouble();
                    Rectangulo rectangulo = new Rectangulo(baseRectangulo, alturaRectangulo);
                    rectangulo.calcularArea();
                    rectangulo.calcularPerimetro();
                    break;
                case 4:
                    System.out.print("Ingrese la base del paralelogramo: ");
                    double baseParalelogramo = sc.nextDouble();
                    System.out.print("Ingrese la altura del paralelogramo: ");
                    double alturaParalelogramo = sc.nextDouble();
                    Paralelogramo paralelogramo = new Paralelogramo(baseParalelogramo, alturaParalelogramo);
                    paralelogramo.calcularArea();
                    paralelogramo.calcularPerimetro();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            
            System.out.println();
        } while (opcion != 0);
        
        sc.close();
    }
}
