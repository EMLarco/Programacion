
package com.mycompany.frutas_poo;

public class Durazno extends Frutas{
    private String estado;
    
    public Durazno(String nombre, String color, String sabor, String estado){
        super(nombre,color,sabor);
        this.estado=estado;
    }
    
    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Estado: "+estado);
    }
    
}
