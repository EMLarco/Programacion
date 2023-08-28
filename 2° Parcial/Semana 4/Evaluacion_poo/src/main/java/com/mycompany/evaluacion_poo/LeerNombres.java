
package com.mycompany.evaluacion_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeerNombres {
     public static List<String> leerNombres() {
        Scanner scanner = new Scanner(System.in);

        List<String> nombres = new ArrayList<>();

        System.out.println("Ingresa nombres (escribe 'fin' para terminar):");

        String nombre;
        while (true) {
            nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }
            nombres.add(nombre);
        }

        return nombres;
    }

    public static void mostrarNombres(List<String> nombres) {
        System.out.println("Nombres ingresados:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        System.out.println("Cantidad de nombres ingresados: " + nombres.size());
    }
}
