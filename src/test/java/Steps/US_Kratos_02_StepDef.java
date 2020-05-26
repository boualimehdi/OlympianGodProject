package Steps;

import eu.dauphine.sitn.agility.Human;
import eu.dauphine.sitn.agility.OlympianGod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US_Kratos_02_StepDef {

    private Human human;
    private OlympianGod god;

    @Given("a human {string} and {string} the {string}")
    public void aHumanAndThe(String humanName, String godName, String godAlias) {
        this.human = new Human(humanName);
        this.god = new OlympianGod(godName, godAlias);
    }

    @And("the human is not {string}")
    public void theHumanIsNot(String kratosString) {
        Assert.assertFalse(this.human.getName().equalsIgnoreCase(kratosString));
    }

    @When("the human defies Ares")
    public void theHumanDefiesAres() {
        this.human.defy(this.god);
    }

    @Then("Ares beat him and keep his title")
    public void aresBeatHimAndKeepHisTitle() {
        Assert.assertFalse(this.god.getMortality());    //the god is still alive
        Assert.assertFalse(this.god.isHuman());         //the god is not a human
        Assert.assertFalse(this.human.isGod());         //the human did not become a god
    }
}
