package com.mycompany.frutas_poo;

public class Frutas_Poo {

    public static void main(String[] args) {
        Manzana manzanaRoja=new Manzana("Manzana Roja","rojo","Agria","Grande");
        manzanaRoja.mostrarInformacion();
        System.out.println();
        
        Guineo guineomosqueado=new Guineo ("Guineo", "Marron","Dulce", "Si");
        guineomosqueado.mostrarInformacion();
        
        System.out.println();
        
        Durazno duraznillo=new Durazno("Durazno","Amarillo","Dulce", "Recien Cosechado");
        duraznillo.mostrarInformacion();
        
        System.out.println();
    }
}
