package Personal;

public class Docente extends Personal {
	private double rendimiento;
	private int diasPuntuales;
	private int diasFaltantes;
	private int mesesTrabajo;
	private double comision;
	//Constructor
	public Docente(String nombre, String cedula, int iD, String apellido, double sueldoBasico, double rendimiento,
			int diasPuntuales, int diasFaltantes, int mesesTrabajo) {
		super(nombre, cedula, iD, apellido, sueldoBasico);
		this.rendimiento = rendimiento;
		this.diasPuntuales = diasPuntuales;
		this.diasFaltantes = diasFaltantes;
		this.mesesTrabajo = mesesTrabajo;
	}
	//Getter y Setter
	
	
	public double getRendimiento() {
		return rendimiento;
	}

	public int getMesesTrabajo() {
		return mesesTrabajo;
	}


	public void setMesesTrabajo(int mesesTrabajo) {
		this.mesesTrabajo = mesesTrabajo;
	}


	public void setRendimiento(double rendimiento) {
		this.rendimiento = rendimiento;
	}

	public int getDiasPuntuales() {
		return diasPuntuales;
	}

	public void setDiasPuntuales(int diasPuntuales) {
		this.diasPuntuales = diasPuntuales;
	}

	public int getDiasFaltantes() {
		return diasFaltantes;
	}

	public void setDiasFaltantes(int diasFaltantes) {
		this.diasFaltantes = diasFaltantes;
	}

	// Implementación del método para calcular la comisión (15% del sueldo básico según el rendimiento)
    @Override
    public double calcularComision() {
    	comision=sueldoBasico* (0.15 * (rendimiento+((diasPuntuales-diasFaltantes)/10)))-sueldoBasico;
        return comision;
    }

    // Implementación del método para calcular el pago total (sueldo básico + comisión)
    @Override
    public double calcularPago() {
        return sueldoBasico + comision;
    }

    // Implementación del método para calcular la liquidación (solo sueldo básico, sin comisión)
    @Override
    public double calcularLiquidacion() {
        return sueldoBasico*mesesTrabajo;
    }
}
	

