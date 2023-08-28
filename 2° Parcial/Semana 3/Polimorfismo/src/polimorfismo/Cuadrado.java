package polimorfismo;

public class Cuadrado extends Figura{
    
    private double lado;

    public Cuadrado(double lado, String color) {
        super(color);
        this.lado = lado;
    }

    @Override
    public double superficie() {
        double resultado=lado*lado;
        return resultado;
    }
    
}