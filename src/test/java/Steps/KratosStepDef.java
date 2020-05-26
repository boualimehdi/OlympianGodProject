package Steps;

import eu.dauphine.sitn.agility.Human;
import eu.dauphine.sitn.agility.OlympianGod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class KratosStepDef {

    private Human human;
    private OlympianGod god;

    @Given("a human {string}")
    public void aHuman(String humanName) {
        this.human = new Human(humanName);
    }

    @And("an olympian god {string} known as {string}")
    public void anOlympianGodKnownAs(String godName, String godAlias) {
        if(godAlias.equalsIgnoreCase("god of war"))
            godAlias = "Dieu de la guerre";
        this.god = new OlympianGod(godName, godAlias);
    }

    @When("Kratos defies Ares")
    public void kratosDefiesAres() {
        this.human.defy(this.god);
    }

    @Then("Kratos becomes the new god of war")
    public void kratosBecomesTheNewGodOfWar() {
        Assert.assertTrue(this.human.isGod());
        Assert.assertTrue(this.human.getGod().getAlias().equalsIgnoreCase("Dieu de la guerre"));
    }

    @And("kratos becomes immortal")
    public void kratosBecomesImmortal() {
        Assert.assertFalse(this.human.getGod().getMortality());
    }

    @And("Ares loses his title")
    public void aresLosesHisTitle() {
        Assert.assertFalse(this.god.getAlias().equalsIgnoreCase("Dieu de la guerre"));
    }

    @And("Ares becomes mortal human")
    public void aresBecomesMortalHuman() {
        Assert.assertTrue(this.god.isHuman());
        Assert.assertTrue(this.god.getMortality());
    }
}
