package Personal;

import java.time.LocalDate;

public abstract class Empleado {
    private String nombre;
    private int edad;
    private LocalDate fechaIngreso;
    private double salario;
    public static final double BONO = 1000.0;

    public Empleado(String nombre, int edad, LocalDate fechaIngreso, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.fechaIngreso = fechaIngreso;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public abstract void incentivar();
}