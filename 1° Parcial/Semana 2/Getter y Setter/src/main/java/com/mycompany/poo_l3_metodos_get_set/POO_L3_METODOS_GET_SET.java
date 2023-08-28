/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo_l3_metodos_get_set;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class POO_L3_METODOS_GET_SET {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre, apellido;
        int edad;
        
        System.out.println("Ingresar nombre: ");
        nombre=teclado.nextLine();
        System.out.println("Ingresar apellido: ");
        apellido=teclado.nextLine();
        System.out.println("Ingrese su edad: ");
        edad=teclado.nextInt();
        //creamos un objeto
        Persona persona1= new Persona();
        persona1.setNombre(nombre);
        persona1.setApellido(apellido);
        persona1.setEdad(edad);
        // mostrar los valores almacenados en cada atributo
        System.out.println("El nombre es: " + persona1.getNombre());
        System.out.println("El apellido es: " + persona1.getApellido());
        System.out.println("La edad es: "+ persona1.getEdad());
        

    }
}
