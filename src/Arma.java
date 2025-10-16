public class Arma {
    private String nombre;
    private int danoAdicional;

    public Arma(String nombre, int danoAdicional) {
        this.nombre = nombre;
        this.danoAdicional = danoAdicional;
    }

    
    public void atacarConArma(Criatura objetivo) {
        int danoTotal = danoAdicional;
        objetivo.defender(danoTotal);
        System.out.println("¡Ataque con " + nombre + " infligiendo " + danoTotal + " de daño adicional!");
    }

    public int getDanoAdicional() {
        return danoAdicional;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " +" + danoAdicional + " daño";
    }
}

