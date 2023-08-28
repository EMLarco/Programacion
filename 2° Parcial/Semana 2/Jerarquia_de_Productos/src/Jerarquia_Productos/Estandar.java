package Jerarquia_Productos;

//Clase Estandar que extiende la clase Producto y agrega el atributo seccion

public class Estandar extends Productos {
    private String seccion;

    // Constructor de la clase "Estandar" que recibe el nombre, precio y sección del producto

    public Estandar(String nombre, double precio, String seccion) {
        super(nombre, precio);
        this.seccion = seccion;
    }
    
    // Getter para obtener la sección del producto
    
    public String getSeccion() {
        return seccion;
    }

    // Implementación del método obtenerPrecioPedido() de la interfaz "Pedido"
    
    @Override
    public double obtenerPrecioPedido(int unidades) {
        double precioFinal = getPrecio() * unidades;
        if (unidades >= 5) {
            precioFinal *= 0.9; //Aplicar descuento del 10% si se compran 5 unidades o más
        }
        return precioFinal;
    }
}