
package practicapoo_08;

import java.io.*;

public class Motocicleta extends Vehiculo{
    boolean patada;
    @Override
    public void encendido(){
        encendido=true;
        estado="Vehiculo encendido";
    }
    @Override
    public void apagado(){
        encendido=false;
        estado="Vehiculo apagado";
    }
}
