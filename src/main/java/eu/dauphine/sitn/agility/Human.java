package eu.dauphine.sitn.agility;

public class Human {

    private String name;
    private OlympianGod god;

    /**
     * Constructor 1
     * @param name
     */
    public Human(String name) {
        this.name = name;
        this.god = null;
    }
    /**
     * Constructor 2
     * @param name
     * @param god
     */
    public Human(String name, OlympianGod god) {
        this.name = name;
        this.god = god;
    }

    /**
     * Checks if the human is a god or not
     * @return true if the human is a god, false otherwise
     */
    public boolean isGod() {
        return (this.god == null)? false: true;
    }
    /**
     * in the Greek mythology if Kratos defies Ares, he wins and become the new god of war instead of Ares.
     * Ares dies after its defeat.
     * This function aims to check if Krators defies Ares. if it's the case it sets Kratos the new god of war
     * and makes Ares mortal.
     * @param olympianGod
     */
    public void defy(OlympianGod olympianGod) {
        if(this.name.equals("Kratos") && olympianGod.getName().equals("Ares")) {
            this.god = new OlympianGod(this.name, false,"Dieu de la guerre"); //Kratos is the new god of war and he is immortal
            olympianGod.setMortality(true);
            olympianGod.setAlias("Ares n'est plus le dieu de la guerre il a été "+
                    "battu par Kratos le nouveau dieu de la guerre");
            olympianGod.setHuman(new Human("Ares"));
        }
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the god
     */
    public OlympianGod getGod() {
        return god;
    }
    /**
     * @param god the god to set
     */
    public void setGod(OlympianGod god) {
        this.god = god;
    }
}
