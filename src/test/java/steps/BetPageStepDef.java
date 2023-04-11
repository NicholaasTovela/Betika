package steps;


import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.BetPage;

public class BetPageStepDef extends TestBase {
    BetPage betPage;


    @Given("User successfully navigates to the betika {string} page")
    public void userSuccessfullyNavigatesToTheBetikaIntentPage(String page) throws InterruptedException {
        initialization(page);
        Thread.sleep(9000);
    }

    @When("I place bet randomly by randomly clicking odds")
    public void iPlaceBetRandomlyByRandomlyClickingOdds() {
        betPage = new BetPage();
        betPage.placeBetRandomly();
    }

    @When("I place bet for select teams on line number {string} from the list")
    public void iPlaceBetForSelectTeamsOnLineNumberFromTheList(String number) throws InterruptedException {
        betPage = new BetPage();
        betPage.placeBetForChosenTeam(number);
    }
}
