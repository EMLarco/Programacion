/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Cajero {
    Scanner teclado = new Scanner(System.in);
    Administrador admin;

    int opcCajero, numProducto, indice;
    String nombreCajero, idCajero, nombreProducto;
    Double precioProducto;

    public Cajero(Administrador admin) {
        this.admin = admin;
    }

    public void ingreso_cajero() {
        System.out.println("=========MENU DE CAJERO==========");
        System.out.println();
        System.out.println("Ingresa tu Nombre:");
        nombreCajero = teclado.nextLine();
        System.out.println("Ingresa tu id: ");
        idCajero = teclado.nextLine();
        System.out.println(" ");
        System.out.println("Bienvenido!! Cajero " + idCajero + " " + nombreCajero);
        try {
            // Ponemos a "Dormir" el programa durante los ms que queremos
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
        // Borra la pantalla
        System.out.print("\033[H\033[2J");
    }

    public void menu_cajero() {
        do {
            System.out.println("=========MENU DE CAJERO==========");
            System.out.println("1. Consultar precios");
            System.out.println("2. Crear nueva factura");
            System.out.println("3: Salir");
            opcCajero = teclado.nextInt();
            // Consumir el salto de línea para evitar errores
            teclado.nextLine();
            // Borra la pantalla

            switch (opcCajero) {
                case 1:
                    System.out.println("==========Consultar precios===========");
                    System.out.println("Ingrese el nombre del producto: ");
                    nombreProducto = teclado.nextLine();
                    indice = admin.productos.indexOf(nombreProducto);
                    if (indice != -1) {
                        System.out.println("Producto encontrado: " + admin.productos.get(indice));
                        System.out.println("Precio del producto: $" + admin.precios.get(indice));
                    } else {
                        System.out.println("El producto ingresado no existe");
                    }
                    break;
                case 2:
                    System.out.println("=========Crear nueva factura==========");
                    // Resto del código...
                    break;
                case 3:
                    // Resto del código...
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcCajero != 3);
    }
}