import eu.dauphine.sitn.agility.Human;
import eu.dauphine.sitn.agility.OlympianGod;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {

    @Test
    public void testHuman1() {
        String humanName = "Mehdi";
        Human human = new Human(humanName);
        checkEqualConstructor1(human, humanName);
    }

    /**
     * This method checks the content of the first constructor.
     * @param human
     * @param humanName
     */
    private void checkEqualConstructor1(Human human, String humanName) {
        assertTrue(human.getName().equals(humanName));
        assertNull(human.getGod());
        assertFalse(human.isGod());
    }

    @Test
    public void testHuman2() {
        Human human = new Human("Imed", new OlympianGod("Hermes", "Dieu du commerce et du vent"));
        assertTrue(human.getName().equals("Imed"));
        assertNotNull(human.getGod());
        assertTrue(human.isGod());
    }

    @Test
    public void testIsGod() {
        //for constructor 1
        Human human = new Human("Kratos");
        assertNull(human.getGod());
        assertFalse(human.isGod());
        human.setGod(new OlympianGod("Kratos", "Dieu de la guerre"));
        assertNotNull(human.getGod());
        assertTrue(human.isGod());

        //for constructor 2
        Human human2 = new Human("Zam",null);
        assertNull(human2.getGod());
        assertFalse(human2.isGod());
        human2.setGod(new OlympianGod("Hades", "Dieu des enfers"));
        assertNotNull(human2.getGod());
        assertTrue(human2.isGod());
    }

    @Test
    public void testDefy() {
        //for constructor 1
        Human kratos = new Human("Kratos");
        OlympianGod ares = new OlympianGod("Ares", "Dieu de la guerre");
        kratos.defy(ares);
        assertTrue(kratos.isGod());
        assertTrue(kratos.getGod().getName().equals("Kratos") &&
                kratos.getGod().getAlias().equals("Dieu de la guerre") &&
                kratos.getGod().getMortality() == false);
        assertTrue(ares.isHuman());
        //for constructor 2
        Human eros = new Human("Eros");
        OlympianGod ares2 = new OlympianGod("Ares", "Dieu de la guerre");
        eros.defy(ares2);
        assertFalse(eros.isGod());
        assertFalse(ares2.isHuman());
    }

    @Test
    public void testGetName() {
        //for the first constructor
        Human human = new Human("Kratos");
        assertTrue(human.getName().equals("Kratos"));
        assertFalse(human.getName() == null);
        //for the second constructor
        Human person = new Human("Zam", null);
        assertTrue(person.getName().equals("Zam"));
        assertFalse(person.getName() == null);
    }

    @Test
    public void testSetName() {
        //for the first constructor
        Human human = new Human("Kratos");
        assertTrue(human.getName().equals("Kratos"));
        human.setName("Zam");
        assertTrue(human.getName().equals("Zam"));
        assertFalse(human.getName()== null);

        //for the first constructor
        Human person = new Human("Kratos", null);
        assertTrue(person.getName().equals("Kratos"));
        person.setName("Zam");
        assertTrue(person.getName().equals("Zam"));
        assertFalse(person.getName()== null);
    }

    @Test
    public void testGetGod() {
        //for the first constructor
        Human human = new Human("Zam");
        assertTrue(human.getGod() == null);

        //for the second constructor
        OlympianGod eros = new OlympianGod("Eros", "Dieu de l'amour");
        Human human2 = new Human("Eros", eros);
        assertTrue(human2.getGod() == eros);

        //for the defy method and isGod
        Human kratos = new Human("Kratos");
        kratos.defy(new OlympianGod("Ares", "Dieu de la guerre"));
        assertTrue(kratos.isGod());
        assertTrue(kratos.getGod().getName().equals("Kratos") &&
                kratos.getGod().getAlias().equals("Dieu de la guerre") &&
                kratos.getGod().getMortality() == false);
    }

    @Test
    public void testSetGod() {
        //for the first constructor
        Human kratos = new Human("Kratos");
        assertNull(kratos.getGod());
        kratos.setGod(new OlympianGod("Kratos", true, "Pas encore dieu de la guerre"));
        assertTrue(kratos.isGod());
        assertTrue(kratos.getGod().getName().equals("Kratos") && kratos.getGod().getMortality() &&
                kratos.getGod().getAlias().equals("Pas encore dieu de la guerre"));
        //for the second constructor
        Human human = new Human("Kratos", new OlympianGod("Kratos", true, "Pas encore dieu de la guerre"));
        human.setGod(new OlympianGod("Eros", "Dieu de l'amour"));
        assertFalse(human.getGod().getName().equals("Kratos") && human.getGod().getAlias().equals("Pas encore dieu de la guerre"));
        assertTrue(human.getGod().getName().equals("Eros") && human.getGod().getAlias().equals("Dieu de l'amour"));
    }
}