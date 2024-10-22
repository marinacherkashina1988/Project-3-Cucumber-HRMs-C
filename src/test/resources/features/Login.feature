Feature: Login Related Scenarios

  @validCredentials @login
  Scenario: Login with Valid Credentials
    When user enters username and password
    And clicks on login button
    Then user is navigated to the dashboard page with welcome message "Welcome Admin"

  @emptyUsername @login @errorMessage
  Scenario: Login with an empty username field
    When user enters password
    And clicks on login button
    Then empty username error message "Username cannot be empty" is displayed

  @emptyPassword @login @errorMessage
  Scenario: Login with an empty password field
    When user enters username
    And clicks on login button
    Then empty password error message "Password is empty" is displayed

  @invalidCredentials @errorMessage
  Scenario: Login using invalid credentials
    When user enters incorrect username "AdminTest" and correct password
    And clicks on login button
    Then error message "Invalid credentials" is displayed

    When user enters correct username and incorrect password "Human"
    And clicks on login button
    And error message "Invalid credentials" is displayed
    Then error message has to be visible and clear next to input field

    When user corrects the credentials and clicks on login button
    Then user is navigated to the dashboard page with welcome message "Welcome Admin"


