public class Guerrero extends Criatura {
    private String tipoArma;

    public Guerrero(String nombre, int salud, int fuerza, String tipoArma) {
        super(nombre, salud, fuerza);
        this.tipoArma = tipoArma;
    }

    @Override
    public void atacar(Criatura objetivo) {
        if (!estaViva()) return;

        int dañoTotal = fuerza;

        System.out.println(nombre + " ataca con su " + tipoArma + "!");

        // Si tiene arma adicional, la usa
        if (arma != null) {
            arma.atacarConArma(objetivo);
            dañoTotal += arma.getDañoAdicional();
        }

        objetivo.defender(dañoTotal);
    }

    @Override
    public void defender(int daño) {
        // Guerrero tiene buena defensa
        int dañoRecibido = Math.max(1, daño - 3);
        salud -= dañoRecibido;
        System.out.println(nombre + " recibe " + dañoRecibido + " de daño (defensa con armadura)");
    }

    public String getTipoArma() { return tipoArma; }
}