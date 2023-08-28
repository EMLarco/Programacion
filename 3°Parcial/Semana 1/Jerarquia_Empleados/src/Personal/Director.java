
package Personal;

import java.time.LocalDate;
import Personal.Empleado;


public class Director extends Empleado{
    private String departamento;
    private int personal;

    public Director(String departamento, int personal, String nombre, double salario, LocalDate fechaIngreso, int edad) {
        super(nombre, edad, fechaIngreso, salario);
        this.departamento = departamento;
        this.personal = personal;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getPersonal() {
        return personal;
    }

    @Override
    public void incentivar(){
        if(getFechaIngreso().getMonthValue()>30&&personal>20){
            setSalario(getSalario()+(2*BONO));
        }else if(getFechaIngreso().getMonthValue()>30||personal>20){
            setSalario(getSalario()+BONO);
        }
    }
}
