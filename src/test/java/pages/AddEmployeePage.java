package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeeButton;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "employeeId")
    public WebElement employeeIDField;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id = "frmEmpPersonalDetails")
    public WebElement personalDetails;

    @FindBy(id = "photofile")
    public WebElement photoField;

    @FindBy(xpath = "//input[@id='firstName']/following-sibling::span[@for='firstName' and text()='Required']")
    public WebElement empFirstNameErrorMsg;

    @FindBy(xpath = "//input[@id='lastName']/following-sibling::span[@for='lastName' and text()='Required']")
    public WebElement empLastNameErrorMsg;

    @FindBy(xpath = "//div[contains(text(),'Id Exists')]")
    public WebElement employeeIdErrorMessage;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

}
