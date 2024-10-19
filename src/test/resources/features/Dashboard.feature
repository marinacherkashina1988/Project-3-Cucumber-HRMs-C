Feature: Dashboard Related Scenarios

  Background:
    Given user is able to access HRMs portal
    When user enters username and password
    And clicks on login button

  @PIM @dashboard
  Scenario: selecting PIM drop down menu
    And user clicks on PIM option
    Then drop down menu is displayed