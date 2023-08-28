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
public class Menu_1 {
    Scanner leer = new Scanner(System.in);
    Cajero cajero1;
    Administrador admin = new Administrador();
    int opc;
    
     public Menu_1() {
        cajero1 = new Cajero(admin);
    }

    public void menu_Cuenta() {
        do {
            System.out.println("======MENÚ DE OPCIONES======");
            System.out.println("1. Administrador");
            System.out.println("2. Cajero");
            System.out.println("3. Salir");
            opc = leer.nextInt();

            switch (opc) {
                case 1:
                    admin.menuAdministrador();
                    break;
                case 2:
                    cajero1.ingreso_cajero();
                    System.out.println();
                    cajero1.menu_cajero();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opc != 3);
    }
}
