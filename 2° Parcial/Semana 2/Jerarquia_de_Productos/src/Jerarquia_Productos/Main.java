package Jerarquia_Productos;

import java.util.*;

public class Main {

	public static void main(String[] args) {
	
	int unidades= 5;
	
	Scanner scp= new Scanner(System.in);
	
    // Crear productos estándar y ofertados utilizando el método crearProductoEstandar() y crearProductoOfertado()

	Estandar pEstandar1 = crearProductoEstandar(scp);
    Estandar pEstandar2 = crearProductoEstandar(scp);

    Ofertado pOfertado1 = crearProductoOfertado(scp);
    Ofertado pOfertado2 = crearProductoOfertado(scp);
    Ofertado pOfertado3 = crearProductoOfertado(scp);
    
    // Calcular el total del pedido sumando los precios de cada producto

    double totalPedido = pEstandar1.obtenerPrecioPedido(unidades) +
            pEstandar2.obtenerPrecioPedido(unidades) +
            pOfertado1.obtenerPrecioPedido(unidades) +
            pOfertado2.obtenerPrecioPedido(unidades) +
            pOfertado3.obtenerPrecioPedido(unidades);

    // Mostrar el total del pedido en la consola

    System.out.println("Total del pedido: $" + totalPedido);
    
    
	}
	
    // Método para crear un producto estándar solicitando los atributos al usuario

	 private static Estandar crearProductoEstandar(Scanner sce) {
	        System.out.println("Ingrese el nombre del producto estándar:");
	        String nombre = sce.nextLine();
	        System.out.println("Ingrese el precio del producto estándar:");
	        double precio = Double.parseDouble(sce.nextLine());
	        System.out.println("Ingrese la sección del producto estándar:");
	        String seccion = sce.nextLine();
	        return new Estandar(nombre, precio, seccion);
	    }
	 
	    // Método para crear un producto ofertado solicitando los atributos al usuario

	 private static Ofertado crearProductoOfertado(Scanner sco) {
	        System.out.println("Ingrese el nombre del producto ofertado:");
	        String nombre = sco.nextLine();
	        System.out.println("Ingrese el precio del producto ofertado:");
	        double precio = Double.parseDouble(sco.nextLine());
	        System.out.println("Ingrese el número de días restantes para la oferta del producto:");
	        int dias = Integer.parseInt(sco.nextLine());
	        return new Ofertado(nombre, precio, dias);
	    }

}
