package pageObject;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath = "//input[@type='text']")
    WebElement phoneNumberInputBox;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordInputBox;

    @FindBy(xpath = "//button[@class='button account__payments__submit session__form__button login button button__secondary']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[@class='title']")
    WebElement alert;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterPhoneNumber(String phoneNumber){
        phoneNumberInputBox.click();
        phoneNumberInputBox.sendKeys(phoneNumber);
    }

    public void enterPassword(String password){
        passwordInputBox.click();
        passwordInputBox.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void verifyAlert(String alertMessage) throws InterruptedException {
        if (alertMessage.equalsIgnoreCase("Login Failed")){
            Thread.sleep(5000);
            String alertMsg = alert.getText();
            Assert.assertEquals(alertMsg.toLowerCase(), alertMessage.toLowerCase());
        } else if (alertMessage.equalsIgnoreCase("Success")) {
            Thread.sleep(2000);
            String alertMsg = alert.getText();
            Assert.assertEquals(alertMsg.toLowerCase(), alertMessage.toLowerCase());
            Thread.sleep(5000);
        } else if (alertMessage.equalsIgnoreCase("Bet Placement Successful") || alertMessage.equalsIgnoreCase("Bet Submitted")) {
            String alertMsg = alert.getText();
            Assert.assertEquals(alertMsg.toLowerCase(), alertMessage.toLowerCase());
        }

    }

}
