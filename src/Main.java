
public class Main {
    public static void main (String[] args) {
        // Crear armas
        Arma espadaLegendaria = new Arma("Espada Legendaria", 15);
        Arma varitaMagica = new Arma("Varita Mágica", 10);
        Arma garrasAfiladas = new Arma("Garras Afiladas", 12);
        Arma hachaPesada = new Arma("Hacha Pesada", 18);

        // Crear criaturas
        Dragon dragon = new Dragon("Draco", 120, 15, "Escamas de Diamante");
        Mago mago = new Mago("Merlín", 80, 12, "Bola de Fuego");
        Guerrero guerrero = new Guerrero("Conan", 100, 18, "espada larga");
        Guerrero guerrero2 = new Guerrero("Thor", 110, 16, "martillo");

        // Equipar armas
        dragon.setArma(garrasAfiladas);
        mago.setArma(varitaMagica);
        guerrero.setArma(espadaLegendaria);
        guerrero2.setArma(hachaPesada);

        // Demostrar habilidades especiales
        System.out.println("=== DEMOSTRACIÓN DE HABILIDADES ===");
        if (dragon instanceof Volador) {
            ((Volador) dragon).volar();
        }
        
        if (mago instanceof Magico) {
            ((Magico) mago).aprenderHechizo("Rayo de Hielo");
        }
        System.out.println();

        // Simular batallas
        System.out.println("BATALLA 1: Guerrero vs Mago");
        Batalla.simularBatalla(guerrero, mago);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Resetear salud para nueva batalla
        dragon.setSalud(120);
        guerrero2.setSalud(110);

        System.out.println("BATALLA 2: Dragón vs Guerrero");
        Batalla.simularBatalla(dragon, guerrero2);
    }
}