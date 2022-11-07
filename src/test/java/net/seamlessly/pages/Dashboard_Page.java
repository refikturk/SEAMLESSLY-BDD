package net.seamlessly.pages;

import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_Page extends Seamlessly_BasePage {

    Seamlessly_LoginPage loginPage = new Seamlessly_LoginPage();

    @FindBy(xpath = "(//div[@id='app-dashboard']//h2)[1]")
    public WebElement dashboardText;

    public void user_is_on_the_dashboard_page(String url, String usernameOrMail, String validPass, String userFullName) {
        Driver.getDriver().get(ConfigurationReader.getProperty("seamlessly_login_page"));
        loginPage.loginSeamlessly(usernameOrMail,validPass);
        Assert.assertTrue(dashboardText.getText().contains(ConfigurationReader.getProperty(userFullName)));
    }


}
