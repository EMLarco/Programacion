package Personal;

public abstract class Personal {
	protected String nombre;
	protected String cedula;
	protected int iD;
	protected String apellido;
	protected double sueldoBasico;
	//Constructor
	public Personal(String nombre, String cedula, int iD, String apellido, double sueldoBasico) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.iD = iD;
		this.apellido = apellido;
		this.sueldoBasico = sueldoBasico;
	}
	
	//Metodos abstractos a ser implementados por las clases hijas
	 public abstract double calcularComision();
	 public abstract double calcularPago();
	 public abstract double calcularLiquidacion();
	//Getter y Setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

}
