package SuperHeroes;

public class Rimuru extends SuperHeroe {
    // Atributo específico de Rimuru
    private String personalOmnipotencia;

    // Constructor de Rimuru que inicializa los atributos de la clase padre y el atributo específico
    public Rimuru(String poderes, int escala, int velocidad, String personalOmnipotencia) {
        // Llamada al constructor de la clase padre usando super()
        super(poderes, escala, velocidad);
        this.personalOmnipotencia = personalOmnipotencia;
    }

    // Método getter para acceder al atributo específico de Rimuru
    public String getPersonalOmnipotencia() {
        return personalOmnipotencia;
    }

    // Implementación del método habilidadEspecial() específico para Rimuru
    @Override
    public void habilidadEspecial() {
        System.out.println("Rimuru utiliza su omnipotencia para derrotar a su rival.");
    }
}
