package polimorfismo;

public class Polimorfismo {

    public static void main(String[] args) {
        //Llamamos al metodo mostrar
        mostrarDatosFigura(new Triangulo(4,5,"Amarillo"));
        mostrarDatosFigura(new Circulo(5,"Verde"));
        
    }
    /*Aplicando Polimorfismo
    la gran ventaja del polimorfismo es la reutilizacion de codigo
    al forzar a todas las clases a tener el mismo.
    Este expresion vale para cualquier subclase de figura
    cuyos objetos vengan aqui como parametros.
    */
    
    private static void mostrarDatosFigura(Figura f){
        System.out.println("Color: "+f.getColor());
        System.out.println("Superficie: "+f.superficie());
    }
}
