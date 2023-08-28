package Jerarquia_Productos;

//Clase abstracta Producto que implementa la interfaz Pedido y proporciona los atributos comunes y métodos básicos

public abstract class Productos implements Pedido {
    private String nombre;
    private double precio;

    // Constructor de la clase "Producto" que recibe el nombre y precio del producto

    public Productos(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getter para obtener el nombre del producto

    public String getNombre() {
        return nombre;
    }

    // Getter para obtener el precio del producto

    public double getPrecio() {
        return precio;
    }
}