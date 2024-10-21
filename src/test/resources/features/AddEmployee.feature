Feature: Adding new employees related scenarios

  Background:
    When user enters username and password
    And clicks on login button
    And user clicks on PIM option
    And user clicks on Add Employee button

  @addByName @addEmployee
  Scenario: adding a new employee without providing an employee ID
    And user enters an employee full name
    And user clicks on Save button
    Then user is navigated to the new employee profile page

  @addByID @addEmployee
  Scenario: adding a new employee by providing an employee ID
    And user enters an employee full name and ID
    And user clicks on Save button
    Then user is navigated to the new employee profile page

  @validationError @addEmployee
  Scenario: Validating an error message when user attempts to submit or provide incomplete information
    And user enters middlename
    And user clicks on Save button
    Then clear error message or prompts is displayed for firstname and lastname fields

  @existingIdError @addEmployee @failedToSave
  Scenario: Validating an error message when user attempts to add an employee with an existing ID
    And user enters an employee full name and existing ID
    And user clicks on Save button
    Then clear error message is displayed




