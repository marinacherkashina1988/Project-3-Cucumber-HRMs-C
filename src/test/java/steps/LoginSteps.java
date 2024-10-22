package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;
import utils.ConfigReader;

import java.time.Duration;

public class LoginSteps extends CommonMethods {

    @Given("user is able to access HRMs portal")
    public void user_is_able_to_access_hr_ms_portal() {
        driver = new ChromeDriver();
        driver.get(ConfigReader.read("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        initializePageObjects();
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        click(loginPage.loginButton);
    }

    @Then("user is navigated to the dashboard page with welcome message {string}")
    public void userIsNavigatedToTheDashboardPageWithWelcomeMessage(String welcomeMessage) {
        Assert.assertEquals(welcomeMessage, dashboardPage.welcomeMessage.getText());
    }

    @When("user enters password")
    public void user_enters_password() {
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("user enters username")
    public void user_enters_username() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
    }

    @Then("empty username error message {string} is displayed")
    public void emptyUsernameErrorMessageIsDisplayed(String emptyUsernameError) {
        Assert.assertEquals(emptyUsernameError, loginPage.errorMessage.getText());
    }

    @Then("empty password error message {string} is displayed")
    public void emptyPasswordErrorMessageIsDisplayed(String emptyPasswordError) {
        Assert.assertEquals(emptyPasswordError, loginPage.errorMessage.getText());
    }

    @When("user enters incorrect username {string} and correct password")
    public void userEntersIncorrectUsernameAndCorrectPassword(String wrongUsername) {
        sendText(wrongUsername, loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);

    }

    @When("user enters correct username and incorrect password {string}")
    public void userEntersCorrectUsernameAndIncorrectPassword(String wrongPassword) {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(wrongPassword, loginPage.passwordField);
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String invalidCredentialsError) {
        Assert.assertEquals(invalidCredentialsError, loginPage.errorMessage.getText());
    }

    @And("user corrects the credentials and clicks on login button")
    public void userCorrectsTheCredentialsAndClicksOnLoginButton() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
        click(loginPage.loginButton);
    }

    @Then("error message has to be visible and clear next to input field")
    public boolean errorMessageHasToBeVisibleAndClearNextToInputField() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        Assert.assertTrue(loginPage.errorMessageParent.equals(loginPage.loginButtonParent));
        return false;
    }
}
