package steps;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.BetSlip;
import pageObject.LoginPage;

public class logInStepDef extends TestBase {

    LoginPage loginPage;
    BetSlip betSlip;

    @When("I enter {string} and {string}")
    public void i_enter_and(String phoneNumber, String password) {
        loginPage = new LoginPage();
        loginPage.enterPhoneNumber(phoneNumber);
        loginPage.enterPassword(password);
    }

    @And("I click on the {string}")
    public void iClickOnTheButton(String button) throws InterruptedException {
        if(button.equals("log in button")) {
            loginPage.clickLogin();
        } else if (button.equalsIgnoreCase("Load betslip")) {
            betSlip = new BetSlip();
            betSlip.clickButton();
        }
    }

    @Then("I verify if the {string} alert pops up")
    public void iVerifyIfTheAlertPopsUp(String alert) throws InterruptedException {
        if (alert.contains("betslip")){
            betSlip.verifyBetSlipError(alert);
        } else {
            loginPage.verifyAlert(alert);
        }

    }
}
