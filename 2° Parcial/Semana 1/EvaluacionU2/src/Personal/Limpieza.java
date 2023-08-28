package Personal;

public class Limpieza extends Personal{
	int calidadLimpieza;
	int mesesTrabajo;
    // Constructor
    public Limpieza(String nombre, String cedula, int ID, String apellido, double sueldoBasico,
                    int calidadLimpieza, int mesesTrabajo) {
        super(nombre, cedula, ID, apellido, sueldoBasico);
        this.calidadLimpieza = calidadLimpieza;
        this.mesesTrabajo = mesesTrabajo;
    }

    // Implementación del método para calcular la comisión 
    @Override
    public double calcularComision() {
    if(calidadLimpieza>5) {
    	sueldoBasico=sueldoBasico*0.15*calidadLimpieza;
    }
        return sueldoBasico;
    }

    // Implementación del método para calcular el pago total (solo sueldo básico, sin comisión)
    @Override
    public double calcularPago() {
        return sueldoBasico;
    }

    // Implementación del método para calcular la liquidación (solo sueldo básico, sin comisión)
    @Override
    public double calcularLiquidacion() {
    	sueldoBasico=sueldoBasico*mesesTrabajo;
        return sueldoBasico;
    }
}
	
