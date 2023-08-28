
package com.mycompany.frutas_poo;


public class Guineo extends Frutas {
    private String dulce;
    
    public Guineo (String nombre, String color,String sabor, String dulce){
        super(nombre,color,sabor);
        this.dulce=dulce;
    }
    
    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Dulce: "+dulce);
    }
}
