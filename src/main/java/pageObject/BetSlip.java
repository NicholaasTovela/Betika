package pageObject;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BetSlip extends TestBase {

    @FindBy(xpath = "//input[@name='sharing-code']")
    WebElement inputBetSlipId;

    @FindBy(xpath = "//button[@class='button account__payments__submit button button__secondary share-code-button']")
    WebElement btnLoadBetSlip;

    @FindBy(xpath = "//span[@class='error']")
    WebElement errorBetSlip;

    public BetSlip(){
        PageFactory.initElements(driver, this);
    }

    public void inputBetSlipId(String betslipId){
        inputBetSlipId.click();
        inputBetSlipId.sendKeys(betslipId);
    }

    public void clickButton(){
        btnLoadBetSlip.click();
    }

    public void verifyBetSlipError(String message) throws InterruptedException {
        Thread.sleep(2000);
        String actualMsg = errorBetSlip.getText();
        Assert.assertEquals(actualMsg, message);
    }
}
