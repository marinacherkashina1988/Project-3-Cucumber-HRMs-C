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

    @Then("user is navigated to the dashboard page")
    public void user_is_navigated_to_the_dashboard_page() {
        Assert.assertEquals(dashboardPage.welcomeMessage.getText(), ConfigReader.read("welcomeMessage"));
    }

    @When("user enters password")
    public void user_enters_password() {
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("user enters username")
    public void user_enters_username() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
    }

    @Then("empty username error message for is displayed")
    public void emptyUsernameErrorMessageForIsDisplayed() {
        Assert.assertEquals(loginPage.errorMessage.getText(), ConfigReader.read("emptyUsernameError"));
    }

    @Then("empty password error message is displayed")
    public void emptyPasswordErrorMessageIsDisplayed() {
        //make a screenshot because it is failing: Empty and empty
        Assert.assertEquals(loginPage.errorMessage.getText(), ConfigReader.read("emptyPasswordError"));
    }

    @When("user enters incorrect username and correct password")
    public void userEntersIncorrectUsernameAndCorrectPassword() {
        sendText(ConfigReader.read("incorrectUserName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
    }

    @When("user enters correct username and incorrect password")
    public void userEntersCorrectUsernameAndIncorrectPassword() {
        sendText(ConfigReader.read("userName"), loginPage.usernameField);
        sendText(ConfigReader.read("incorrectPassword"), loginPage.passwordField);
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        Assert.assertEquals(loginPage.errorMessage.getText(), ConfigReader.read("incorrectCredentialsError"));
    }

    @When("user enters incorrect username or incorrect password")
    public void userEntersIncorrectUsernameOrIncorrectPassword() {
        sendText(ConfigReader.read("incorrectUserName"), loginPage.usernameField);
        sendText(ConfigReader.read("password"), loginPage.passwordField);
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