
package jerarquia_empleados;

import Personal.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Jerarquia_Empleados {

    public static void main(String[] args) {
        Scanner scempleados=new Scanner(System.in);
        
        while(true){
            System.out.println("Menú:");
            System.out.println("1. Ingresar Director");
            System.out.println("2. Ingresar Operario");
            System.out.println("3. Mostrar Informacion de los empleados");
            System.out.println("4. Salir");
            System.out.println("Ingrese una opción");
            int opcion=scempleados.nextInt();
            scempleados.nextLine();
            
            if(opcion==1){
                System.out.println("Ingrese el nombre el Director");
                String nombre=scempleados.nextLine();
                System.out.println("Ingrese la edad del Director");
                int edad=scempleados.nextInt();
                System.out.println("Ingrese la fecha de ingreso del Director (AA/MM/DD)");
                String fechaIngresoStr=scempleados.next();
                LocalDate fechaIngreso=LocalDate.parse(fechaIngresoStr);
                System.out.println("Ingrese el salario anual del Director");
                double salario=scempleados.nextDouble();
                scempleados.nextLine();
                System.out.println("Ingrese el nombre del departamento del Director");
                String departamento = scempleados.nextLine();
                System.out.println("Ingrese el numero de personas a cargo del Director");
                int personal=scempleados.nextInt();
                
                Director director=new Director(departamento,personal,nombre,salario,fechaIngreso,edad);
                director.incentivar();
                System.out.println("Director creado con exito");
                
            }else if(opcion==2){
                System.out.println("Ingrese el nombre del Operario");
                String nombre=scempleados.nextLine();
                System.out.println("Ingrese la edad del Operario");
                int edad=scempleados.nextInt();
                System.out.println("Ingrese la fecha de Ingreso del Operario");
                String fechaIngresoStr=scempleados.next();
                LocalDate fechaIngreso=LocalDate.parse(fechaIngresoStr);
                System.out.println("Ingrese el salario del Operario");
                double salario=scempleados.nextDouble();
                System.out.println("Ingrese el nivel de seguridad del Operario");
                int nivel=scempleados.nextInt();
                
                Operario operario=new Operario(nombre,edad,fechaIngreso,salario,nivel);
                operario.incentivar();
                System.out.println("Operario creado con exito");
            }else if(opcion==3){
                System.out.println("Informacion de los empleados");
            }else if(opcion==4){
                System.out.println("Saliendo de programa...");
                break;
            }else{
                System.out.println("Opcio invalida por favor ingrese una opcion valida");
            }
            System.out.println();
        }
        scempleados.close();
    }
    
}
