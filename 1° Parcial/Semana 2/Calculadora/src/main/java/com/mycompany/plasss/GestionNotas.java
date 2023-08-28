/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.plasss;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;
import java.util.Scanner;

public class GestionNotas {
    public static void main(String[] args) {
        ArrayList<Double> notas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("Menú:");
            System.out.println("1. Agregar nota");
            System.out.println("2. Ver nota media");
            System.out.println("3. Ver número de aprobados");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese una nota: ");
                    double nota = scanner.nextDouble();
                    notas.add(nota);
                    System.out.println("Nota agregada correctamente.");
                    break;
                case 2:
                    if (notas.size() > 0) {
                        double suma = 0;
                        for (double n : notas) {
                            suma += n;
                        }
                        double notaMedia = suma / notas.size();
                        System.out.println("Nota media: " + notaMedia);
                    } else {
                        System.out.println("No se han ingresado notas.");
                    }
                    break;
                case 3:
                    if (notas.size() > 0) {
                        int aprobados = 0;
                        for (double n : notas) {
                            if (n >= 5.0) {
                                aprobados++;
                            }
                        }
                        System.out.println("Número de aprobados: " + aprobados);
                    } else {
                        System.out.println("No se han ingresado notas.");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }
}

