package Jerarquia_Productos;

public class Ofertado extends Productos {
	
    private int dias;

    // Constructor de la clase "Ofertado" que recibe el nombre, precio y número de días restantes para la oferta

    public Ofertado(String nombre, double precio, int dias) {
        super(nombre, precio);
        this.dias = dias;
    }

    // Getter para obtener el número de días restantes para la oferta del producto

    public int getDias() {
        return dias;
    }

    // Implementación del método obtenerPrecioPedido() de la interfaz "Pedido"

    @Override
    public double obtenerPrecioPedido(int unidades) {
        double precioFinal = 0;
        if (dias == 1) {
            precioFinal = getPrecio() * unidades * 0.8; // Aplicar descuento del 20% si queda 1 día de oferta
        } else if (dias >= 2 && dias <= 3) {
            precioFinal = getPrecio() * unidades * 0.85; // Aplicar descuento del 15% si quedan 2 o 3 días de oferta
        } else if (dias > 3) {
            precioFinal = getPrecio() * unidades * 0.9; // Aplicar descuento del 10% si quedan más de 3 días de oferta
        }
        return precioFinal;
    }
}