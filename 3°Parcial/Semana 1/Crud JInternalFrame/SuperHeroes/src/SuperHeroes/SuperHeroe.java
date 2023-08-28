package SuperHeroes;

//Clase abstracta SuperHeroe que servirá como clase padre para los superhéroes
public abstract class SuperHeroe {
 // Atributos a heredar a todos los superhéroes
 private String poderes;
 private int escala;
 private int velocidad;

 // Constructor de la clase SuperHeroe que inicializa los atributos 
 public SuperHeroe(String poderes, int escala, int velocidad) {
     this.poderes = poderes;
     this.escala = escala;
     this.velocidad = velocidad;
 }

 // Métodos getter para acceder a los atributos de la clase
 public String getPoderes() {
     return poderes;
 }

 public int getEscala() {
     return escala;
 }

 public int getVelocidad() {
     return velocidad;
 }

 // Método abstracto que debe ser implementado por las clases hijas.
 // Este método representa la habilidad especial de cada superhéroer

 public abstract void habilidadEspecial();

 // Método para simular un ataque
 public void atacar(SuperHeroe oponente) {
    // Se calcula la "fuerza" del ataque como la suma de escala y velocidad
    int fuerzaAtaque = this.getEscala() + this.getVelocidad();
    int fuerzaDefensa = oponente.getEscala() + oponente.getVelocidad();

    // Comparamos las fuerzas de ataque y defensa para determinar el resultado
    if (fuerzaAtaque > fuerzaDefensa) {
        System.out.println(this.getClass().getSimpleName() + " gana la batalla contra " + oponente.getClass().getSimpleName());
    } else if (fuerzaAtaque < fuerzaDefensa) {
        System.out.println(this.getClass().getSimpleName() + " pierde la batalla contra " + oponente.getClass().getSimpleName());
    } else {
        System.out.println("¡Es un empate entre " + this.getClass().getSimpleName() + " y " + oponente.getClass().getSimpleName() + "!");
    }
 }
 
}