package Main;

import Personal.*;
import java.util.*;

public class Main {

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     System.out.println("Bienvenido al sistema de cálculo de pagos por tipo de personal.");
     System.out.println("Por favor, ingrese el tipo de personal (Limpieza, Tecnico, Administrativo, Docente):");
     String tipoPersonal = scanner.nextLine();

     Personal personal = null;

     switch (tipoPersonal.toLowerCase()) {
         case "limpieza":
             personal = crearLimpieza(scanner);
             break;
         case "tecnico":
             personal = crearTecnico(scanner);
             break;
         case "administrativo":
             personal = crearAdministrativo(scanner);
             break;
         case "docente":
             personal = crearDocente(scanner);
             break;
         default:
             System.out.println("Tipo de personal no válido.");
             break;
     }

     if (personal != null) {
         double comision = personal.calcularComision();
         double pagoTotal = personal.calcularPago();
         double liquidacion = personal.calcularLiquidacion();
         String nombre = personal.getNombre();
         String apellido = personal.getApellido();
         String cedula = personal.getCedula();
         int iD = personal.getiD();
         
         System.out.println("Nombre: "+ nombre);
         System.out.println("Apellido: "+ apellido);
         System.out.println("CD: "+cedula);
         System.out.println("ID: "+iD);
         System.out.println("Comisión: $" + comision);
         System.out.println("Pago Total: $" + pagoTotal);
         System.out.println("Liquidación: $" + liquidacion);
     }

     scanner.close();
 }

 private static Limpieza crearLimpieza(Scanner scanner) {
     System.out.println("Ingrese el nombre del personal de limpieza:");
     String nombre = scanner.nextLine();
     System.out.println("Ingrese la cédula del personal de limpieza:");
     String cedula = scanner.nextLine();
     System.out.println("Ingrese el ID del personal de limpieza:");
     int ID = Integer.parseInt(scanner.nextLine());
     System.out.println("Ingrese el apellido del personal de limpieza:");
     String apellido = scanner.nextLine();
     System.out.println("Ingrese el sueldo básico del personal de limpieza:");
     double sueldoBasico = Double.parseDouble(scanner.nextLine());
     System.out.println("Ingrese la calidad de limpieza del personal de limpieza:");
     int calidadLimpieza = Integer.parseInt(scanner.nextLine());
     System.out.println("Ingrese los meses de trabajo del personal de Limpieza");
     int mesesTrabajo = Integer.parseInt(scanner.nextLine());

     return new Limpieza(nombre, cedula, ID, apellido, sueldoBasico, calidadLimpieza, mesesTrabajo);
 }

 private static Tecnico crearTecnico(Scanner scanner) {
	 System.out.println("Ingrese el nombre del personal Tecnico:");
     String nombre = scanner.nextLine();
     System.out.println("Ingrese la cédula del personal Tecnico:");
     String cedula = scanner.nextLine();
     System.out.println("Ingrese el ID del personal Tecnico:");
     int ID = Integer.parseInt(scanner.nextLine());
     System.out.println("Ingrese el apellido del personal Tecnico:");
     String apellido = scanner.nextLine();
     System.out.println("Ingrese el sueldo básico del personal Tecnico:");
     double sueldoBasico = Double.parseDouble(scanner.nextLine());
     System.out.println("Ingrese la cantidad de equipos reparados por el personal Tecnico:");
     int equiposReparados = Integer.parseInt(scanner.nextLine());
     System.out.println("Ingrese el rendimiento del personal Tecnico");
     double rendimiento = Double.parseDouble(scanner.nextLine());
     System.out.println("Ingrese los meses de trabajo del personal Tecnico");
     int mesesTrabajo = Integer.parseInt(scanner.nextLine());

     return new Tecnico(nombre, cedula, ID, apellido, sueldoBasico,equiposReparados,rendimiento,mesesTrabajo);
 }

 private static Administrativo crearAdministrativo(Scanner scanner) {
	 System.out.println("Ingrese el nombre del personal Administrativo:");
     String nombre = scanner.nextLine();
     System.out.println("Ingrese la cédula del personal Administrativo:");
     String cedula = scanner.nextLine();
     System.out.println("Ingrese el ID del personal Administrativo:");
     int ID = Integer.parseInt(scanner.nextLine());
     System.out.println("Ingrese el apellido del personal Administrativo:");
     String apellido = scanner.nextLine();
     System.out.println("Ingrese el sueldo básico del personal Administrativo:");
     double sueldoBasico = Double.parseDouble(scanner.nextLine());
     System.out.println("Ingrese la cantidad de años contratados que lleva el personal Administrativo:");
     int anosContratado = Integer.parseInt(scanner.nextLine());
     System.out.println("Ingrese la opinion del personal sobre el personal Administrativo");
     int personalOpinion = Integer.parseInt(scanner.nextLine());
     System.out.println("Ingrese los meses de Trabajo del personal Administrativo");
     int mesesTrabajo = Integer.parseInt((scanner.nextLine()));
     
     return new Administrativo(nombre,cedula,ID,apellido,sueldoBasico,anosContratado,personalOpinion,mesesTrabajo);
 }

 private static Docente crearDocente(Scanner scanner) {
	 System.out.println("Ingrese el nombre del personal Docente:");
     String nombre = scanner.nextLine();
     System.out.println("Ingrese la cédula del personal Docente:");
     String cedula = scanner.nextLine();
     System.out.println("Ingrese el ID del personal Docente:");
     int ID = Integer.parseInt(scanner.nextLine());
     System.out.println("Ingrese el apellido del personal Docente:");
     String apellido = scanner.nextLine();
     System.out.println("Ingrese el sueldo básico del personal Docente:");
     double sueldoBasico = Double.parseDouble(scanner.nextLine());
     System.out.println("Ingrese el rendimiento (0-10) del personal Docente");
     double rendimiento = Double.parseDouble(scanner.nextLine());
     System.out.println("Ingrese los meses de Trabajo del personal Docente");
     int mesesTrabajo = Integer.parseInt(scanner.nextLine());
     System.out.println("Ingrese los dias que falto el personal Docente:");
     int diasFaltantes = Integer.parseInt(scanner.nextLine());
     System.out.println("Ingrese los dias que llego antes el personal Docente:");
     int diasPuntuales = Integer.parseInt(scanner.nextLine());
     
     return new Docente(nombre,cedula,ID,apellido,sueldoBasico,rendimiento,mesesTrabajo,diasFaltantes,diasPuntuales);
 }
}



