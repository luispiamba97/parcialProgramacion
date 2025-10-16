import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CriaturaTest {

    @Test
    void testDragonAtacar() {
        Dragon dragon = new Dragon("Test Dragon", 100, 10, "Escamas Normales");
        Guerrero guerrero = new Guerrero("Test Guerrero", 50, 5, "espada");
        
        dragon.atacar(guerrero);
        
        assertTrue(guerrero.getSalud() < 50, "El guerrero debería recibir daño");
        assertTrue(dragon.estaViva(), "El dragón debería seguir vivo");
    }

    @Test
    void testMagoLanzarHechizo() {
        Mago mago = new Mago("Test Mago", 60, 8, "Hechizo Test");
        Dragon dragon = new Dragon("Test Dragon", 100, 10, "Escamas");
        
        mago.lanzarHechizo(dragon);
        
        assertTrue(dragon.getSalud() < 100, "El dragón debería recibir daño del hechizo");
        assertEquals(80, mago.getMana(), "El mana debería disminuir en 20");
    }

    @Test
    void testCriaturaMorir() {
        Guerrero guerrero = new Guerrero("Test Guerrero", 10, 5, "espada");
        Dragon dragon = new Dragon("Test Dragon", 100, 20, "Escamas");
        
        dragon.atacar(guerrero);
        
        assertFalse(guerrero.estaViva(), "El guerrero debería morir");
        assertTrue(dragon.estaViva(), "El dragón debería seguir vivo");
    }

    @Test
    void testArmaDañoAdicional() {
        Arma arma = new Arma("Espada Test", 10);
        assertEquals(10, arma.getDanoAdicional(), "El daño adicional debería ser 10");
    }

    @Test
    void testVoladorInterface() {
        Dragon dragon = new Dragon("Test Dragon", 100, 10, "Escamas");
        assertTrue(dragon instanceof Volador, "El dragón debería implementar Volador");
    }

    @Test
    void testMagicoInterface() {
        Mago mago = new Mago("Test Mago", 60, 8, "Hechizo");
        assertTrue(mago instanceof Magico, "El mago debería implementar Mágico");
    }
}