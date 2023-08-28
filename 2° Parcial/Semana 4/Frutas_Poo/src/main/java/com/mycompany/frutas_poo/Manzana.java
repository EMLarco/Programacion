
package com.mycompany.frutas_poo;

public class Manzana extends Frutas{
    private String variedad;
    
    public Manzana(String nombre, String color, String sabor, String variedad){
        super(nombre,color,sabor);
        this.variedad=variedad;
    }
    
    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Variedad: "+variedad);
    }
}
