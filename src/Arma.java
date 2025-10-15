public class Arma {
    private String nombre;
    private int dañoAdicional;

    public Arma(String nombre, int dañoAdicional) {
        this.nombre = nombre;
        this.dañoAdicional = dañoAdicional;
    }

    public void atacarConArma(Criatura objetivo) {
        int dañoTotal = dañoAdicional;
        objetivo.defender(dañoTotal);
        System.out.println("¡Ataque con " + nombre + " infligiendo " + dañoTotal + " de daño adicional!");
    }

    public int getDañoAdicional() {
        return dañoAdicional;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " +" + dañoAdicional + " daño";
    }
}
