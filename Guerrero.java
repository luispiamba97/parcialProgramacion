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
            danoTotal += arma.getDanoAdicional();
        }

        objetivo.defender(danoTotal);
    }

    @Override
    public void defender(int dano) {
        // Guerrero tiene buena defensa
        int danoRecibido = Math.max(1, dano - 3);
        salud -= danoRecibido;
        System.out.println(nombre + " recibe " + danoRecibido + " de dano (defensa con armadura)");
    }

    public String getTipoArma() { return tipoArma; }
}