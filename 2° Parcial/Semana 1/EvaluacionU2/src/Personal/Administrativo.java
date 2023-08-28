package Personal;

public class Administrativo extends Personal {
	private int anosContratado;
	private int personalOpinion;
	private int mesesTrabajo;
	//Constructor
	public Administrativo(String nombre, String cedula, int iD, String apellido, double sueldoBasico,
			int anosContratado, int personalOpinion, int mesesTrabajo) {
		super(nombre, cedula, iD, apellido, sueldoBasico);
		this.anosContratado = anosContratado;
		this.personalOpinion = personalOpinion;
		this.mesesTrabajo = mesesTrabajo;
	}
	
	// Implementación del método para calcular la comisión
    @Override
    public double calcularComision() {
    	if (anosContratado>5) {
    		sueldoBasico=sueldoBasico*0.15;
    	}
        return sueldoBasico;
    }

    // Implementación del método para calcular el pago total
    @Override
    public double calcularPago() {
    	sueldoBasico=sueldoBasico*(personalOpinion/100);
        return sueldoBasico;
    }

    // Implementación del método para calcular la liquidación (solo sueldo básico, sin comisión)
    @Override
    public double calcularLiquidacion(){
    	sueldoBasico=sueldoBasico*mesesTrabajo;
        return sueldoBasico;
    }
}
