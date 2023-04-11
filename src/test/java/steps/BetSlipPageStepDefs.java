package steps;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.BetSlip;

public class BetSlipPageStepDefs extends TestBase {
    BetSlip betSlip;

    @When("I enter betslip id {string}")
    public void iEnterBetslipId(String betSlipId) {
        betSlip = new BetSlip();
        betSlip.inputBetSlipId(betSlipId);
    }
}
