
package com.mycompany.evaluacion_poo;

import java.util.List;

public class VerificarPrimo {
        public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void verificarPrimo(List<Integer> numeros) {
        if (numeros.size() < 4) {
            System.out.println("La lista no tiene suficientes elementos para verificar si el cuarto número es primo.");
            return;
        }

        int cuartoNumero = numeros.get(3);
        if (esPrimo(cuartoNumero)) {
            System.out.println("El cuarto número (" + cuartoNumero + ") es primo.");
        } else {
            System.out.println("El cuarto número (" + cuartoNumero + ") no es primo.");
        }
    }
}
