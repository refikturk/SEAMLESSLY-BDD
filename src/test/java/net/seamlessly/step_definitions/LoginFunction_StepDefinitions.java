package net.seamlessly.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.Seamlessly_LoginPage;
import net.seamlessly.utilities.ConfigurationReader;
import net.seamlessly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFunction_StepDefinitions {

    Seamlessly_LoginPage loginPage = new Seamlessly_LoginPage();

    @Given("user is on the Seamlessly login page")
    public void user_is_on_the_seamlessly_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("seamlessly_login_page"));
    }

    @When("user types valid username {string}")
    public void userTypesValidUsername(String arg0) {
        loginPage.username.sendKeys(arg0);
    }


    @When("user types valid password to {string}")
    public void user_types_valid_password_to(String str) {
        loginPage.password.sendKeys(str);
    }

    @When("user clicks on log in button")
    public void user_clicks_on_log_in_button() {
        loginPage.loginButton.click();
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        Assert.assertTrue(loginPage.user_should_see_the_dashboard());
    }

//    @Then("user should log out")
//    public void userShouldLogOut() {
//        loginPage.settingsMenu.click();
//        BrowserUtils.sleep(2);
//        loginPage.logOutButton.click();
//    }

    @When("User types invalid username {string}")
    public void user_types_invalid_username(String string) {
        loginPage.username.sendKeys(string);
    }

    @When("User types invalid password to {string}")
    public void user_types_invalid_password_to(String string) {
        loginPage.password.sendKeys(string);
    }

    @When("user should see Wrong username or password warning")
    public void user_should_see_wrong_username_or_password_warning() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.wrongUsernameOrPasswordMessage));
        Assert.assertTrue(loginPage.wrongUsernameOrPasswordMessage.isDisplayed());
    }

    @When("User types empty username {string}")
    public void user_types_invalid_empty_username(String string) {
        loginPage.username.sendKeys(string);
    }
    @When("User types empty password to {string}")
    public void user_types_invalid_empty_password_to(String string) {
        loginPage.password.sendKeys(string);
    }

    @Then("Verify that user sees {string}")
    public void verifyThatUserSees(String errorOrAlertMessage) {

        loginPage.verifyErrorOrAlertMessage(errorOrAlertMessage);

    }

    @When("User types any value to password {string}")
    public void user_types_any_value_to_password(String string) {
       loginPage.password.sendKeys("Employee123");
    }

    @Then("Verify that the password is invisible")
    public void verifyThatThePasswordIsInvisible() {
        Assert.assertTrue(loginPage.password.getAttribute("type").contains("password"));
    }
}
