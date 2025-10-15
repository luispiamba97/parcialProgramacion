public class Dragon extends Criatura implements Volador {
    private String escamas;
    private boolean volando;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
        this.volando = false;
    }

    @Override
    public void atacar(Criatura objetivo) {
        if (!estaViva()) return;

        int dañoBase = fuerza * 2; // Dragón tiene ataque más fuerte
        int dañoTotal = dañoBase;

        System.out.println(nombre + " ataca con sus garras y aliento de fuego!");

        // Si tiene arma, usa el daño adicional
        if (arma != null) {
            dañoTotal += arma.getDañoAdicional();
            System.out.println("Usando " + arma.getNombre() + " para daño adicional!");
        }

        objetivo.defender(dañoTotal);
    }

    @Override
    public void defender(int daño) {
        // Las escamas proporcionan algo de defensa
        int dañoRecibido = Math.max(1, daño - 5);
        salud -= dañoRecibido;
        System.out.println(nombre + " recibe " + dañoRecibido + " de daño (protección de escamas: " + escamas + ")");
    }

    // Implementación de Volador
    @Override
    public void volar() {
        volando = true;
        System.out.println(nombre + " despliega sus alas y comienza a volar!");
    }

    @Override
    public void aterrizar() {
        volando = false;
        System.out.println(nombre + " aterriza suavemente en el suelo.");
    }

    public String getEscamas() { return escamas; }
    public boolean isVolando() { return volando; }
}