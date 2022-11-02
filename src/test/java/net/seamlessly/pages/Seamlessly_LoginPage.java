package net.seamlessly.pages;

import net.seamlessly.utilities.BrowserUtils;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Seamlessly_LoginPage {

    public Seamlessly_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "user")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(xpath = "a[@class='toggle-password']")
    public WebElement makeVisibleButton;


    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement wrongUsernameOrPasswordMessage;

    public void loginSeamlessly() {
        this.username.sendKeys("Employee31");
        this.loginButton.click();
    }

    public void loginSeamlessly(String usernameOrMail, String validPass) {
        username.sendKeys(ConfigurationReader.getProperty("usernameOrMail"));
        password.sendKeys(ConfigurationReader.getProperty("validPass"));
        loginButton.click();
    }

    public boolean user_should_see_the_dashboard() {
        String dashboard = Driver.getDriver().getCurrentUrl();
        boolean isloggedIn = dashboard.contains("dashboard");
        return isloggedIn;
    }


    public void verifyErrorOrAlertMessage(String errorOrAlertMessage) {
        if (errorOrAlertMessage.contains("Please fill out this field.")) {
            if (BrowserUtils.waitForVisibility(username, 1).getAttribute("validationMessage").contains(errorOrAlertMessage)) {
                Assert.assertTrue(username.getAttribute("validationMessage").contains(errorOrAlertMessage));
            } else if (BrowserUtils.waitForVisibility(password, 1).getAttribute("validationMessage").contains(errorOrAlertMessage)) {
                Assert.assertTrue(password.getAttribute("validationMessage").contains(errorOrAlertMessage));
            }
        }


    }

    public void userClicksOnLogInButtonOrPressEnter(String clickType) {
        if (clickType.equalsIgnoreCase("enter")) {
            loginButton.sendKeys(Keys.ENTER);
        } else if (clickType.equalsIgnoreCase("click")) {
            loginButton.click();
        } else {
            loginButton.click();
        }
    }

    public void wrongUsernameOrPasswordMessage(String expectedMessage){
        String warningMessage =  wrongUsernameOrPasswordMessage.getText();
        BrowserUtils.sleep(2);
        Assert.assertTrue(wrongUsernameOrPasswordMessage.isDisplayed());
        Assert.assertEquals(expectedMessage, warningMessage);
    }

}
