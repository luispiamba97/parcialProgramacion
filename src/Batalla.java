public class Batalla {

    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("=== COMIENZA LA BATALLA ===");
        System.out.println(criatura1.getNombre() + " vs " + criatura2.getNombre());
        System.out.println("===========================\n");

        int turno = 1;

        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("--- Turno " + turno + " ---");

            // Criatura 1 ataca a Criatura 2
            if (criatura1.estaViva()) {
                criatura1.atacar(criatura2);
            }

            // Criatura 2 ataca a Criatura 1 si sigue viva
            if (criatura2.estaViva()) {
                criatura2.atacar(criatura1);
            }

            System.out.println("Estado: " + criatura1.getNombre() + " (" + criatura1.getSalud() + " HP) - " + 
                             criatura2.getNombre() + " (" + criatura2.getSalud() + " HP)");
            System.out.println();
            turno++;

            // Prevenir bucles infinitos
            if (turno > 50) {
                System.out.println("¡Batalla demasiado larga! Se declara empate.");
                break;
            }
        }

        // Determinar ganador
        System.out.println("=== FIN DE LA BATALLA ===");
        if (criatura1.estaViva()) {
            System.out.println("¡" + criatura1.getNombre() + " es el ganador!");
        } else if (criatura2.estaViva()) {
            System.out.println("¡" + criatura2.getNombre() + " es el ganador!");
        } else {
            System.out.println("¡Ambas criaturas han caído en batalla!");
        }
    }
}