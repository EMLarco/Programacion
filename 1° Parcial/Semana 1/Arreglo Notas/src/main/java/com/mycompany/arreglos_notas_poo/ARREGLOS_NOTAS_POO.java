/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arreglos_notas_poo;
import java.util.Scanner;
import notas1.GestionNotas;



/**
 *
 * @author Usuario
 */
public class ARREGLOS_NOTAS_POO {
    public static void main(String [] args){
        GestionNotas gnotas=new GestionNotas();
        int op;
        Scanner sc=new Scanner(System.in);
        
        double notas;
        do{
            System.out.println("1: Añadir nota");
            System.out.println("2: Ver media");
            System.out.println("3: Ver Aprobado");
            System.out.println("4: Salir");
           op = sc.nextInt();
           switch (op){
               case 1:
                   System.out.println("Ingrese una nota: ");
                   notas=Double.parseDouble(sc.nextLine());
                   gnotas.guardarNot(notas);
                   break;
               case 2:
                   System.out.println("La media es: "+gnotas.media());
               case 3:
                   System.out.println("");
           }
        }while (op!=4);
        
    }
}
