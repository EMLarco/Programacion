/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.main.Administrador;
import com.mycompany.main.Cajero;
import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;

public class Menu {
    Scanner leer=new Scanner(System.in);
    Cajero cajero1 =new Cajero();
    Administrador admin = new Administrador();
    int opc;
    public void menu_Cuenta(){
        do{
            System.out.println("======MENÚ DE OPCIONES=====");
            System.out.println("1. Administrador");
            System.out.println("2. Cajero");
            System.out.println("3. Salir");
            opc = leer.nextInt();
            switch(opc){
                case 1: 
                    admin.menuAdministrador();
                    break;
                case 2:
                    cajero1.ingreso_cajero();
                    System.out.println("");
                    cajero1.menu_cajero();
                    break;
                case 3:
                    break;
                default: 
                System.out.println("Opcion no valida");
                break;
            }
        }while(opc!=3);
    }
}