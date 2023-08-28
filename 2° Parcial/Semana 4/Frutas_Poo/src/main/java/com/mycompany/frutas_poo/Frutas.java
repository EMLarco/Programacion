
package com.mycompany.frutas_poo;

public class Frutas {
    private String nombre;
    private String sabor;
    private String color;
    
    public Frutas (String nombre, String sabor, String color){
        this.nombre=nombre;
        this.sabor=sabor;
        this.color=color;
    }
    
    public void mostrarInformacion(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Color: "+color);
        System.out.println("Sabor: "+sabor);
    }
}
