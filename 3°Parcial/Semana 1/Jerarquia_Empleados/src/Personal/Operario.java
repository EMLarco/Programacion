
package Personal;

import java.time.LocalDate;
import Personal.Empleado;

public class Operario extends Empleado {
    private int nivel;
    
    public Operario(String nombre, int edad, LocalDate fechaIngreso, double salario, int nivel) {
        super(nombre, edad, fechaIngreso, salario);
        this.nivel=nivel;
    }
    
    public int getNivel(){
        return nivel;
    }
    
    @Override
    public void incentivar(){
        if(getEdad()>30&&nivel>2){
            setSalario(getSalario()+(2*BONO));
        }else if(getEdad()>30||nivel>2){
            setSalario(getSalario()+BONO);
        }
    }
    
    public void actualizarNIvel(){
        if(getFechaIngreso().getYear()>2&&nivel<5){
            nivel++;
        }
    }
}
