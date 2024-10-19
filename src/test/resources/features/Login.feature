Feature: Login Related Scenarios

  @validCredentials @login
  Scenario: Login with Valid Credentials

    When user enters username and password
    And clicks on login button
    Then user is navigated to the dashboard page

  @emptyUsername @login @errorMessage
  Scenario: Login with an empty username field
    When user enters password
    And clicks on login button
    Then empty username error message for is displayed

  @emptyPassword @login @errorMessage
  Scenario: Login with an empty password field
    When user enters username
    And clicks on login button
    Then empty password error message is displayed

  @invalidUsername @invalidCredentials @errorMessage
  Scenario: Login using invalid credentials (incorrect username)
    When user enters incorrect username and correct password
    And clicks on login button
    Then error message is displayed

  @invalidPassword @invalidCredentials @errorMessage
  Scenario: Login using invalid credentials (incorrect password)
    When user enters correct username and incorrect password
    And clicks on login button
    Then error message is displayed

  @loginAfterError @login
  Scenario: Correcting input after error message being displayed and attempting to login
    When user enters incorrect username or incorrect password
    And clicks on login button
    And error message is displayed
    And user corrects the credentials and clicks on login button
    Then user is navigated to the dashboard page

  @errorMessage @login @visibilityErrorMessage
  Scenario: Error message should be clear and visible for the user
    When user enters incorrect username or incorrect password
    And clicks on login button
    And error message is displayed
    Then error message has to be visible and clear next to input field
