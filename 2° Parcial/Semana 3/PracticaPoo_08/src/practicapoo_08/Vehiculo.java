
package practicapoo_08;

import java.io.*;

public class Vehiculo {
    String placa;
    int numRuedas;
    boolean encendido;
    String estado;
  
    public void setnumRuedas(int ruedas){
    numRuedas=ruedas;

    }
    
    public void encendido(){
        encendido=true;
        estado="Vehiculo encendido";
    }
    
    public void apagado(){
        encendido=false;
        estado="Vehiculo apagado";
    }
    
    
}

