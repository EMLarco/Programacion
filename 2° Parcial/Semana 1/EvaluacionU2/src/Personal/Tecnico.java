package Personal;

public class Tecnico extends Personal {
	private int equiposReparados;
	private double rendimiento;
	private int mesesTrabajo;
	//Constructor
	public Tecnico(String nombre, String cedula, int iD, String apellido, double sueldoBasico, int equiposReparados,
			double rendimiento, int mesesTrabajo) {
		super(nombre, cedula, iD, apellido, sueldoBasico);
		this.equiposReparados = equiposReparados;
		this.rendimiento = rendimiento;
		this.mesesTrabajo = mesesTrabajo;
	}
	//Getter y Setter
	public int getEquiposReparados() {
		return equiposReparados;
	}
	
	public void setEquiposReparados(int equiposReparados) {
		this.equiposReparados = equiposReparados;
	}
	
	public double getRendimiento() {
		return rendimiento;
	}
	
	public void setRendimiento(double rendimiento) {
		this.rendimiento = rendimiento;
	}
	
	  // Implementación del método para calcular la comisión (15% del sueldo básico según el rendimiento)
    @Override
    public double calcularComision() {
        return sueldoBasico * 0.15 * rendimiento;
    }

    // Implementación del método para calcular el pago total (sueldo básico + comisión)
    @Override
    public double calcularPago() {
        return sueldoBasico + calcularComision();
    }

    // Implementación del método para calcular la liquidación (solo sueldo básico, sin comisión)
    @Override
    public double calcularLiquidacion() {
    	sueldoBasico=sueldoBasico*mesesTrabajo;
        return sueldoBasico;
    }
	
}
