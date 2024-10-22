package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ExcelReader;
import java.io.IOException;
import java.util.*;

public class AddEmployeeSteps extends CommonMethods {

    @When("user enters an employee full name")
    public void user_enters_an_employee_full_name() {
        try {
            List<Map<String, String>> newEmployeeDetails = ExcelReader.read();
            for (Map<String, String> employee : newEmployeeDetails) {
                sendText(employee.get("First Name"), addEmployeePage.firstNameField);
                sendText(employee.get("Middle Name"), addEmployeePage.middleNameField);
                sendText(employee.get("Last Name"), addEmployeePage.lastNameField);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

        int employeeID = generateNumbers();

        try {
            List<Map<String, String>> newEmployeeDetails = ExcelReader.read();
            for (Map<String, String> employee : newEmployeeDetails) {
                sendText(employee.get("First Name"), addEmployeePage.firstNameField);
                sendText(employee.get("Middle Name"), addEmployeePage.middleNameField);
                sendText(employee.get("Last Name"), addEmployeePage.lastNameField);
                sendText(String.valueOf(employeeID), addEmployeePage.employeeIDField);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @And("user clicks on Add Employee button")
    public void userClicksOnAddEmployeeButton() {
        click(addEmployeePage.addEmployeeButton);
    }

    @And("user enters middlename")
    public void userEntersMiddlename() {
        try {
            List<Map<String, String>> newEmployeeDetails = ExcelReader.read();
            for (Map<String, String> employee : newEmployeeDetails) {
                sendText(employee.get("Middle Name"), addEmployeePage.middleNameField);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @And("clear error message or prompts is displayed for firstname and lastname fields")
    public void clearErrorMessageOrPromptsIsDisplayedForFirstnameAndLastnameFields() {
        Assert.assertTrue(addEmployeePage.empFirstNameErrorMsg.isDisplayed());
        Assert.assertTrue(addEmployeePage.empLastNameErrorMsg.isDisplayed());
    }

    @And("user enters an employee full name and existing ID {string}")
    public void userEntersAnEmployeeFullNameAndExistingID(String existingID) {
        try {
            List<Map<String, String>> newEmployeeDetails = newEmployeeDetails = ExcelReader.read();
            for (Map<String, String> employee : newEmployeeDetails) {
                sendText(employee.get("First Name"), addEmployeePage.firstNameField);
                sendText(employee.get("Middle Name"), addEmployeePage.middleNameField);
                sendText(employee.get("Last Name"), addEmployeePage.lastNameField);
                sendText(existingID, addEmployeePage.employeeIDField);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("clear error message is displayed")
    public void clearErrorMessageIsDisplayed() {
        Assert.assertTrue(addEmployeePage.employeeIdErrorMessage.isDisplayed());
    }
}
