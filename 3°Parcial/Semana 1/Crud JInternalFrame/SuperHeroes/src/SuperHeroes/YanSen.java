package SuperHeroes;

public class YanSen extends SuperHeroe {
    // Atributo específico de Yan Sen
    private String personalOmiciensia;

    // Constructor de YanSen que inicializa los atributos de la clase padre y el atributo específico
    public YanSen(String poderes, int escala, int velocidad, String personalOmiciensia) {
        // Llamada al constructor de la clase padre usando super()
        super(poderes, escala, velocidad);
        this.personalOmiciensia = personalOmiciensia;
    }

    // Método getter para acceder al atributo específico de Yan Sen
    public String getPersonalOmiciensia() {
        return personalOmiciensia;
    }

    // Implementación del método habilidadEspecial() específico para Yan Sen
    @Override
    public void habilidadEspecial() {
        System.out.println("Yan Sen controla la energía omiciensia para proteger la ciudad de su rival.");
    }
}
