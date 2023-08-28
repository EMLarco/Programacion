package SuperHeroes;

public class SpiderMan extends SuperHeroe {
    // Atributo específico de Spider-Man
    private String personalTelarana;

    // Constructor de SpiderMan que inicializa los atributos de la clase padre y el atributo específico
    public SpiderMan(String poderes, int escala, int velocidad, String personalTelarana) {
        // Llamada al constructor de la clase padre usando super()
        super(poderes, escala, velocidad);
        this.personalTelarana = personalTelarana;
    }

    // Método getter para acceder al atributo específico de Spider-Man
    public String getPersonalTelarana() {
        return personalTelarana;
    }

    // Implementación del método habilidadEspecial() específico para Spider-Man
    @Override
    public void habilidadEspecial() {
        System.out.println("Spider-Man dispara telarañas para atrapar a su rival.");
    }
}
