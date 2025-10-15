public abstract class Criatura {
    protected String nombre;
    protected int salud;
    protected int fuerza;
    protected Arma arma; // Nueva propiedad para el arma


    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
        this.arma = null; // Inicialmente sin arma
       
    }

    // Métodos abstractos
    public abstract void atacar(Criatura objetivo);
    public abstract void defender(int daño);

    // Método concreto
    public boolean estaViva() {
        return salud > 0;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getFuerza() { return fuerza; }
    public Arma getArma() { return arma; }
   

    
    public void setSalud(int salud) { this.salud = salud; }

    @Override
    public String toString() {
        return nombre + " (Salud: " + salud + ", Fuerza: " + fuerza + ")";
    }
}