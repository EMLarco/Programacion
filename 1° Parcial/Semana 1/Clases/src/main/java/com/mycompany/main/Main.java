/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author Usuario
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");  
        System.out.println("=========Universidad de las Fuerzas Armadas ESPE=========");
        System.out.println("            Programacion Orientada a Objetos              ");
        System.out.println("=============Sistema de Gestion de Tienda=================");
        System.out.println("Integrantes: John Galarza, Juan Jimenez, Andres Pantoja, Sahid Bosquez");
        System.out.println("Grupo: 1."); 
        
        System.out.print("\033[H\033[2J");  
        
        Menu_1 usuario1 = new Menu_1();
        usuario1.menu_Cuenta();
    }
}
