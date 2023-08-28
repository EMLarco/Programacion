
package practicapoo_08;


public class PracticaPoo_08 {

 
    public static void main(String[] args) {
        
        Automovil auto1= new Automovil();
        Motocicleta moto1= new Motocicleta();
        Vehiculo carro1=new Vehiculo();
        
        auto1.encendido();
        moto1.encendido();
        carro1.encendido();
        
        System.out.println(""+auto1.estado);
        System.out.println(""+moto1.estado);
        System.out.println(""+carro1.estado);
    }
    
}
