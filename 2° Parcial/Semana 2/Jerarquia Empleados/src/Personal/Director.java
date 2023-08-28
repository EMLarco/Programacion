package Personal;

import Personal.Empleado;
import java.time.LocalDate;

public class Director extends Empleado {
    private String departamento;
    private int personal;

    public Director(String nombre, int edad, LocalDate fechaIngreso, double salario, String departamento, int personal) {
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
    public void incentivar() {
        if (getFechaIngreso().getMonthValue() > 30 && personal > 20) {
            setSalario(getSalario() + (2 * BONO));
        } else if (getFechaIngreso().getMonthValue() > 30 || personal > 20) {
            setSalario(getSalario() + BONO);
        }
    }
}