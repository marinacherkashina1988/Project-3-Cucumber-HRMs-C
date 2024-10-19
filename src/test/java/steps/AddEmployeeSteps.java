package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class AddEmployeeSteps extends CommonMethods {

    @When("user enters an employee full name")
    public void user_enters_an_employee_full_name() {
        sendText(ConfigReader.read("firstName"), addEmployeePage.firstNameField);
        sendText(ConfigReader.read("middleName"), addEmployeePage.middleNameField);
        sendText(ConfigReader.read("lastName"), addEmployeePage.lastNameField);
    }

    @When("user clicks on Save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("user is navigated to the new employee profile page")
    public void user_is_navigated_to_the_new_employee_profile_page() {
        Assert.assertTrue(addEmployeePage.personalDetails.isDisplayed());
    }

    @And("user enters an employee full name and ID")
    public void userEntersAnEmployeeFullNameAndID() {

        sendText(ConfigReader.read("firstName"), addEmployeePage.firstNameField);
        sendText(ConfigReader.read("middleName"), addEmployeePage.middleNameField);
        sendText(ConfigReader.read("lastName"), addEmployeePage.lastNameField);

        Properties properties = new Properties();
        int employeeIdParsed = 0;

        try (FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE_PATH)) {
            properties.load(fis);
            System.out.println(ConfigReader.read("employeeID"));
            employeeIdParsed = Integer.parseInt(ConfigReader.read("employeeID"));
            employeeIdParsed++;
        } catch (IOException e) {
            e.printStackTrace();
        }

        properties.setProperty("employeeID", String.valueOf(employeeIdParsed));

        try (FileOutputStream output = new FileOutputStream(Constants.CONFIG_FILE_PATH)) {
            properties.store(output, "Updated Employee ID on run");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sendText(ConfigReader.read("employeeID"), addEmployeePage.employeeIDField);
    }

    @And("user clicks on Add Employee button")
    public void userClicksOnAddEmployeeButton() {
        click(addEmployeePage.addEmployeeButton);
    }

    @And("user uploads profile photo")
    public void userUploadsProfilePhoto() {
        addEmployeePage.photoField.sendKeys(ConfigReader.read("profilePhoto"));
    }

    @And("user enters middlename")
    public void userEntersMiddlename() {
        sendText(ConfigReader.read("middleName"), addEmployeePage.middleNameField);
    }

    @And("clear error message or prompts is displayed for firstname and lastname fields")
    public void clearErrorMessageOrPromptsIsDisplayedForFirstnameAndLastnameFields() {
        Assert.assertTrue(addEmployeePage.empFirstNameErrorMsg.isDisplayed());
        Assert.assertTrue(addEmployeePage.empLastNameErrorMsg.isDisplayed());
    }

    @And("user enters an employee full name and existing ID")
    public void userEntersAnEmployeeFullNameAndExistingID() {
        sendText(ConfigReader.read("firstName"), addEmployeePage.firstNameField);
        sendText(ConfigReader.read("middleName"), addEmployeePage.middleNameField);
        sendText(ConfigReader.read("lastName"), addEmployeePage.lastNameField);
        sendText(ConfigReader.read("existingID"), addEmployeePage.employeeIDField);
    }

    @Then("clear error message is displayed")
    public void clearErrorMessageIsDisplayed() {
        Assert.assertTrue(addEmployeePage.employeeIdErrorMessage.isDisplayed());
    }
}
