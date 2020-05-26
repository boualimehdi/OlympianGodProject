import eu.dauphine.sitn.agility.Human;
import eu.dauphine.sitn.agility.OlympianGod;
import org.junit.Test;

import static org.junit.Assert.*;

public class OlympianGodTest {


    /**
     * Test method for OlympianGod(String name,String alias).
     */
    @Test
    public void testOlympianGod1() {
        OlympianGod zeus = new OlympianGod("Zeus", "Dieu des dieux");
        assertTrue(zeus.getName().equals("Zeus") && zeus.getAlias().equals("Dieu des dieux"));
        assertFalse(zeus.getName().equals("Ares") || zeus.getAlias().equals("Dieu de la guerre"));
    }

    /**
     * Test method for OlympianGod(String name, boolean mortality, String alias).
     */
    @Test
    public void testOlympianGod2() {
        OlympianGod zeus = new OlympianGod("Zeus", false, "Dieu des dieux");
        assertTrue(zeus.getName().equals("Zeus") && zeus.getMortality() == false && zeus.getAlias().equals("Dieu des dieux"));
        assertFalse(zeus.getName().equals("Ares") || zeus.getMortality() == true || zeus.getAlias().equals("Dieu de la guerre"));;
    }

    /**
     * Test method for OlympianGod(String name, boolean mortality, String alias, Human human).
     */
    @Test
    public void testOlympianGod3() {
        Human human = new Human("zeussus");
        OlympianGod zeus = new OlympianGod("Zeus", false, "Dieu des dieux", human);
        assertTrue(zeus.getName().equals("Zeus") && zeus.getMortality() == false &&
                zeus.getAlias().equals("Dieu des dieux") && zeus.getHuman().equals(human));
        assertFalse(zeus.getName().equals("Ares") || zeus.getMortality() == true ||
                zeus.getAlias().equals("Dieu de la guerre") || !zeus.getHuman().equals(human));
    }

    /**
     * Test method for {@link OlympianGod#getMortality()}.
     */
    @Test
    public void testGetMortality() {
        OlympianGod zeus = new OlympianGod("Zeus", "Dieu des dieux");
        assertFalse(zeus.getMortality());
        OlympianGod ares = new OlympianGod("Ares", false, "Dieu de la guerre");
        assertFalse(ares.getMortality());
        OlympianGod poseidon = new OlympianGod("poseidon", true, "Dieu de la mer et des océans");
        assertTrue(poseidon.getMortality());
    }

    /**
     * Test method for {@link OlympianGod#getName()}.
     */
    @Test
    public void testGetName() {
        //test for constructor 1
        OlympianGod zeus = new OlympianGod("Zeus", "Dieu des dieux");
        assertFalse(zeus.getName() == null);
        assertFalse(zeus.getName() == "Ares");
        assertTrue(zeus.getName() == "Zeus");
        //test for constructor 2
        OlympianGod ares = new OlympianGod("Ares", false, "Dieu de la guerre");
        assertFalse(ares.getName() == null);
        assertFalse(ares.getName() == "Zeus");
        assertTrue(ares.getName() == "Ares");
    }

    /**
     * Test method for {@link OlympianGod#setMortality(boolean)}.
     */
    @Test
    public void testSetMortality() {
        //test for constructor 1
        OlympianGod zeus = new OlympianGod("Zeus", "Dieu des dieux");
        assertTrue(zeus.getMortality() == false );
        zeus.setMortality(true);
        assertTrue(zeus.getMortality() == true);

        //test for constructor 2
        OlympianGod ares = new OlympianGod("Ares", false, "Dieu de la guerre");
        assertTrue(ares.getMortality() == false );
        ares.setMortality(true);
        assertTrue(ares.getMortality() == true);
    }

    /**
     * Test method for {@link OlympianGod#setName(String)}.
     */
    @Test
    public void testSetName() {
        //test for constructor 1
        OlympianGod zeus = new OlympianGod("Zeus", "Dieu des dieux");
        assertTrue(zeus.getMortality() == false );
        zeus.setMortality(true);
        assertTrue(zeus.getMortality() == true);

        //test for constructor 2
        OlympianGod ares = new OlympianGod("Ares", false, "Dieu de la guerre");
        assertTrue(ares.getMortality() == false );
        ares.setMortality(true);
        assertTrue(ares.getMortality() == true);
    }

    /**
     * Test method for {@link OlympianGod#getAlias()}.
     */
    @Test
    public void testGetAlias() {
        //test for constructor 1
        OlympianGod zeus = new OlympianGod("Zeus", "Dieu des dieux");
        assertFalse(zeus.getAlias() == null);
        assertFalse(zeus.getAlias() == "Dieu de la guerre");
        assertTrue(zeus.getAlias() == "Dieu des dieux");
        //test for constructor 2
        OlympianGod ares = new OlympianGod("Ares", false, "Dieu de la guerre");
        assertFalse(ares.getAlias() == null);
        assertFalse(ares.getAlias() == "Dieu des dieux");
        assertTrue(ares.getAlias() == "Dieu de la guerre");
    }

    /**
     * Test method for {@link OlympianGod#setAlias(String)}.
     */
    @Test
    public void testSetAlias() {
        //test for constructor 1
        OlympianGod zeus = new OlympianGod("Zeus", null);
        assertTrue(zeus.getAlias() == null);
        assertFalse(zeus.getAlias() == "Dieux des dieux");

        zeus.setAlias("Dieux des dieux");
        assertFalse(zeus.getAlias() == null);
        assertTrue(zeus.getAlias() == "Dieux des dieux");

        //test for constructor 2
        OlympianGod ares = new OlympianGod("Ares", false, null);
        assertTrue(ares.getAlias() == null);
        assertFalse(ares.getAlias() == "Dieu de la guerre");

        ares.setAlias("Dieu de la guerre");
        assertFalse(ares.getAlias() == null);
        assertTrue(ares.getAlias() == "Dieu de la guerre");
    }


    @Test
    public void testGetHuman() {
        //test for constructor 3
        OlympianGod aresGod = new OlympianGod("Ares", true, "Ancien dieu de la guerre", new Human("Ares"));
        assertTrue(aresGod.getHuman().getName().equals("Ares") && aresGod.getHuman().getGod()== null);
    }

    @Test
    public void testSetHuman() {
        // test for constructor 3
        OlympianGod aresGod = new OlympianGod("Ares", true, "Ancien dieu de la guerre", null);
        assertNull(aresGod.getHuman());
        aresGod.setHuman(new Human("Ares"));
        assertTrue(aresGod.getHuman().getName().equals("Ares") && aresGod.getHuman().getGod()== null);
    }

}