package jerarquia.empleados;

import Personal.Operario;
import Personal.Director;
import java.time.LocalDate;
import java.util.Scanner;

public class JerarquiaEmpleados {


    public static void main(String[] args) {
        Scanner scempleados = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Ingresar Director");
            System.out.println("2. Ingresar Operario");
            System.out.println("3. Mostrar información de los empleados");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scempleados.nextInt();
            scempleados.nextLine(); // Limpiar el buffer de entrada

            if (opcion == 1) {
                System.out.print("Ingrese el nombre del Director: ");
                String nombre = scempleados.nextLine();
                System.out.print("Ingrese la edad del Director: ");
                int edad = scempleados.nextInt();
                System.out.print("Ingrese la fecha de ingreso del Director (AAAA-MM-DD): ");
                String fechaIngresoStr = scempleados.next();
                LocalDate fechaIngreso = LocalDate.parse(fechaIngresoStr);
                System.out.print("Ingrese el salario anual del Director: ");
                double salario = scempleados.nextDouble();
                scempleados.nextLine(); // Limpiar el buffer de entrada
                System.out.print("Ingrese el nombre del departamento del Director: ");
                String departamento = scempleados.nextLine();
                System.out.print("Ingrese el número de personas a cargo del Director: ");
                int personal = scempleados.nextInt();

                Director director = new Director(nombre, edad, fechaIngreso, salario, departamento, personal);
                director.incentivar();
                System.out.println("Director creado exitosamente.");

            } else if (opcion == 2) {
                System.out.print("Ingrese el nombre del Operario: ");
                String nombre = scempleados.nextLine();
                System.out.print("Ingrese la edad del Operario: ");
                int edad = scempleados.nextInt();
                System.out.print("Ingrese la fecha de ingreso del Operario (AAAA-MM-DD): ");
                String fechaIngresoStr = scempleados.next();
                LocalDate fechaIngreso = LocalDate.parse(fechaIngresoStr);
                System.out.print("Ingrese el salario anual del Operario: ");
                double salario = scempleados.nextDouble();
                System.out.print("Ingrese el nivel de seguridad del Operario (entre 1 y 5): ");
                int nivel = scempleados.nextInt();

                Operario operario = new Operario(nombre, edad, fechaIngreso, salario, nivel);
                operario.incentivar();
                System.out.println("Operario creado exitosamente.");

            } else if (opcion == 3) {
                // Mostrar información de los empleados
                System.out.println("Información de los empleados:");

                // Aquí puedes tener una lista o arreglo que almacene los empleados creados
                // y mostrar sus detalles utilizando un bucle

            } else if (opcion == 4) {
                // Salir del programa
                System.out.println("Saliendo del programa...");
                break;
            } else {
                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }

            System.out.println();
        }

        scempleados.close();
        }
    }   
  
    

