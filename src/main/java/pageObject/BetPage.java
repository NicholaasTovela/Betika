package pageObject;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BetPage extends TestBase {

    @FindBy(xpath = "//button[@class='prebet-match__odd']")
    WebElement randomOdds;

    @FindBy(xpath = "//button/span[contains(text(), 'Place Bet')]")
    WebElement btnPlaceBet;

    @FindBy(xpath = "//span[@class='prebet-match__teams__home']")
    List<WebElement> listOfTeams;

    @FindBy(xpath = "//button[@class='odd']")
    WebElement odd;

    public BetPage(){
        PageFactory.initElements(driver, this);
    }

    public void placeBetRandomly(){
        randomOdds.click();
        btnPlaceBet.click();
    }

    public void placeBetForChosenTeam(String teamNumber) throws InterruptedException {
        listOfTeams.get(Integer.parseInt(teamNumber)-1).click();
        Thread.sleep(2000);
        odd.click();
        btnPlaceBet.click();
    }
}
