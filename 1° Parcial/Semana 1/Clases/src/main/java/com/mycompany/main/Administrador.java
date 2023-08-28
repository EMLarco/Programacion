package com.mycompany.main;

import java.util.Scanner;
import java.util.ArrayList;

public class Administrador {
    
    String nombreAdmin, nombreProducto;
    String usuario, contrasenia; // Nuevas variables miembro
    int opc, indice;
    Scanner in = new Scanner(System.in);
    ArrayList<String> productos = new ArrayList<>();
    ArrayList<Double> precios = new ArrayList<Double>();

    public void menuAdministrador() {
    if (usuario == null || contrasenia == null) {
        System.out.println("=======ACCESO DE ADMINISTRADOR=======");
        System.out.println("Ingrese su nombre de usuario:");
        usuario = in.nextLine();
        System.out.println("Ingrese su contraseña:");
        contrasenia = in.nextLine();
        System.out.println("Inicio de sesión exitoso.");
        System.out.println();
    } else {
        System.out.println("=======ACCESO DE ADMINISTRADOR=======");
        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = in.nextLine();
        System.out.println("Ingrese su contraseña:");
        String password = in.nextLine();

        if (!nombreUsuario.equals(usuario) || !password.equals(contrasenia)) {
            System.out.println("Nombre de usuario o contraseña incorrectos. No tiene acceso al menú de administrador.");
            return;
        }
    }

    do {
        System.out.println("=======MENÚ DE ADMINISTRADOR=======");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto");
        System.out.println("3. Eliminar producto");
        System.out.println("4. Limpiar pantalla");
        System.out.println("5. Mostrar productos");
        System.out.println("6. Salir");
        System.out.println("Ingrese una opción:");
        opc = in.nextInt();
        in.nextLine(); // Limpiar el búfer de entrada

        switch (opc) {
            case 1:
                agregarProducto();
                break;
            case 2:
                buscarProducto();
                break;
            case 3:
                eliminarProducto();
                break;
            case 4:
                System.out.print("\033[H\033[2J");
                break;
            case 5:
                mostrarProductos();
                break;
            case 6:
                // Salir del menú
                break;
            default:
                System.out.println("Opción no válida.");
        }
    } while (opc != 6);
}

    public void agregarProducto() {
        System.out.println("Ingrese el nombre del producto:");
        String nombreProducto = in.nextLine();
        System.out.println("Ingrese el precio del producto:");
        double precioProducto = in.nextDouble();
        in.nextLine(); // Limpiar el búfer de entrada
        productos.add(nombreProducto);
        precios.add(precioProducto);
        System.out.println("Producto agregado exitosamente: " + nombreProducto);
    }

    public void buscarProducto() {
        System.out.println("Ingrese el nombre del producto a buscar:");
        nombreProducto = in.nextLine();
        indice = productos.indexOf(nombreProducto);

        if (indice != -1) {
            System.out.println("Producto encontrado: " + productos.get(indice));
            System.out.println("Precio del producto: $" + precios.get(indice));
        } else {
            System.out.println("El producto ingresado no existe");
        }
    }

    public void eliminarProducto() {
        System.out.println("Ingrese el número del producto a eliminar:");
        int numeroProducto = in.nextInt();
        in.nextLine(); // Limpiar el búfer de entrada
        if (numeroProducto > 0 && numeroProducto <= productos.size()) {
            String nombreProducto = productos.remove(numeroProducto - 1);
            double precioProducto = precios.remove(numeroProducto - 1);
            System.out.println("Producto eliminado exitosamente: " + nombreProducto);
            System.out.println("Precio del producto eliminado: $" + precioProducto);
        } else {
            System.out.println("El número de producto ingresado no es válido.");
        }
    }

    public void mostrarProductos() {
        for (String e : productos) {
            System.out.println(e);
        }
    }
}
