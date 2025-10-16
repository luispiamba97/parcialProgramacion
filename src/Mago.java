public class Mago extends Criatura implements Magico {
    private String hechizos;
    private int mana;

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
        this.mana = 100;
    }

    @Override
    public void atacar(Criatura objetivo) {
        if (!estaViva()) return;

        // El mago puede elegir entre ataque normal o hechizo
        if (mana >= 20) {
            lanzarHechizo(objetivo);
        } else {
            ataqueNormal(objetivo);
        }
    }

    private void ataqueNormal(Criatura objetivo) {
        int danoTotal = fuerza;
        System.out.println(nombre + " realiza un ataque mágico básico!");

        if (arma != null) {
            danoTotal += arma.getDanoAdicional();
        }

        objetivo.defender(danoTotal);
    }

    @Override
    public void defender(int dano) {
        // Mago tiene poca defensa física
        salud -= dano;
        System.out.println(nombre + " recibe " + dano + " de daño (baja defensa física)");
    }

    // Implementación de Mágico
    @Override
    public void lanzarHechizo(Criatura objetivo) {
        if (mana >= 20) {
            int danoHechizo = fuerza + 10;
            mana -= 20;
            System.out.println(nombre + " lanza hechizo: " + hechizos + "!");
            
            if (arma != null) {
                danoHechizo += arma.getDanoAdicional();
            }

            objetivo.defender(danoHechizo);
            System.out.println("Mana restante: " + mana);
        } else {
            ataqueNormal(objetivo);
        }
    }

    @Override
    public void aprenderHechizo(String nuevoHechizo) {
        hechizos = nuevoHechizo;
        System.out.println(nombre + " ha aprendido el hechizo: " + nuevoHechizo);
    }

    public int getMana() { return mana; }
    public String getHechizos() { return hechizos; }

    public void setArma(Arma varitaMagica) {
        
        this.arma = varitaMagica;
        
       
    }

   
}