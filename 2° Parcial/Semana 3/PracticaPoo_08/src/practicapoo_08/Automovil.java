
package practicapoo_08;

import java.io.*;

public class Automovil extends Vehiculo{
    boolean pararisas;
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
