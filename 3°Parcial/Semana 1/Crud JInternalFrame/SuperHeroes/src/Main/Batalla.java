package Main;

import SuperHeroes.*;
import java.util.Scanner;


public class Batalla {
    public static void main(String[] args) {
        Scanner sph = new Scanner(System.in);

        // Variables para almacenar los datos de los superhéroes
        String poderes, personalTelarana, personalOmiciensia, personalOmnipotencia;
        int escala, velocidad;

        // Menú para que el usuario ingrese los datos de Spider-Man
        System.out.println("Ingresa los datos de Spider-Man:");
        System.out.print("Poderes: ");
        poderes = sph.nextLine();
        System.out.print("Escala (Considerar a manera de numeros): ");
        escala = sph.nextInt();
        System.out.print("Velocidad: ");
        velocidad = sph.nextInt();
        sph.nextLine(); // Limpiamos el buffer
        System.out.print("Poder de Telaraña: ");
        personalTelarana = sph.nextLine();

        SuperHeroe spiderMan = new SpiderMan(poderes, escala, velocidad, personalTelarana);
        // Menú para que el usuario ingrese los datos de Spider-Man
        System.out.println("\nIngresa los datos de Yan Sen:");
        System.out.print("Poderes: ");
        poderes = sph.nextLine();
        System.out.print("Escala (Considerar a manera de numeros): ");
        escala = sph.nextInt();
        System.out.print("Velocidad: ");
        velocidad = sph.nextInt();
        sph.nextLine(); // Limpiamos el buffer
        System.out.print("Nivel de Omiciensia: ");
        personalOmiciensia = sph.nextLine();

        SuperHeroe yanSen = new YanSen(poderes, escala, velocidad, personalOmiciensia);
        // Menú para que el usuario ingrese los datos de Spider-Man
        System.out.println("\nIngresa los datos de Rimuru:");
        System.out.print("Poderes: ");
        poderes = sph.nextLine();
        System.out.print("Escala (Considerar a manera de numeros): ");
        escala = sph.nextInt();
        System.out.print("Velocidad: ");
        velocidad = sph.nextInt();
        sph.nextLine(); // Limpiamos el buffer
        System.out.print("Nivel de Omnipotencia: ");
        personalOmnipotencia = sph.nextLine();

        SuperHeroe rimuru = new Rimuru(poderes, escala, velocidad, personalOmnipotencia);

        // Cerramos el scanner ya que ya no lo necesitamos
        sph.close();

        // Mostramos los datos de los superhéroes
        System.out.println("\nDatos de los superhéroes:");
        mostrarDatosSuperheroe(spiderMan);
        mostrarDatosSuperheroe(yanSen);
        mostrarDatosSuperheroe(rimuru);

        // Simulación de la batalla
        System.out.println("\n¡Comienza la batalla!");
        spiderMan.habilidadEspecial();
        yanSen.habilidadEspecial();
        rimuru.habilidadEspecial();

        // Spider-Man vs. Yan Sen
        spiderMan.atacar(yanSen);

        // Spider-Man vs. Rimuru
        spiderMan.atacar(rimuru);

        // Yan Sen vs. Rimuru
        yanSen.atacar(rimuru);
    }

    // Método auxiliar para mostrar los datos de un superhéroe
    public static void mostrarDatosSuperheroe(SuperHeroe superHeroe) {
        System.out.println("\nNombre del superhéroe: " + superHeroe.getClass().getSimpleName());
        System.out.println("Poderes: " + superHeroe.getPoderes());
        System.out.println("Escala: " + superHeroe.getEscala());
        System.out.println("Velocidad: " + superHeroe.getVelocidad());
    }
}
