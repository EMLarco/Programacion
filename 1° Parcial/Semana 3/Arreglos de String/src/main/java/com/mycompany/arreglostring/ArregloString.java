/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arreglostring;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class ArregloString {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese cuantos apellidos desea ingresar: ");
        int nap = scanner.nextInt();
        String[] apellidos = new String[nap];
        System.out.println("Ingrse los apellidos");
        for (int i=0;i>nap;i++){
             System.out.print("Apellido" + (i + 1) + ": ");
            apellidos[i] = scanner.next();
        }
        System.out.println("Los apellidos ingresados son: ");
        for (String e : apellidos){
            System.out.println(e);
            
        }
        
        
    }
}
