/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arreglostring;

/**
 *
 * @author Usuario
 */
import java.util.Scanner;

public class Apellidostring {
    public static void ingresarApellidos() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese cuántos apellidos desea ingresar: ");
        int nap = scanner.nextInt();
        String[] apellidos = new String[nap];

        System.out.println("Ingrese los apellidos:");
        for (int i = 0; i < nap; i++) {
            System.out.print("Apellido " + (i + 1) + ": ");
            apellidos[i] = scanner.next();
        }

        int selec;
        do {
            System.out.println("===Escoja una opción====");
            System.out.println("1: Mostrar apellidos");
            System.out.println("2: Salir");
            System.out.println("========================");
            selec = scanner.nextInt();

            switch (selec) {
                case 1:
                    System.out.println("Los apellidos ingresados son:");
                    for (String ap : apellidos) {
                        System.out.println(ap);
                    }
                    break;
                case 2:
                    System.out.println("Volvio al menú principal... Vuelva a escoger una opción");
                    break;
                default:
                    System.out.println("Opción inválida. Vuelva a intentarlo.");
            }
        } while (selec != 2);
    }
}
