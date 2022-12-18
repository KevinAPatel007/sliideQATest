@login
Feature: Login
  Scenario: User access the web site for first time (when not logged in yet)
    Given the user opens web site for the first time
    Then login screen with user name and password entries
  And login button is displayed

  Scenario: User access the web site for first time
    Given the user opens web site for the first time
    Then login screen with user name and password entries
    And login button is displayed

  Scenario: User login succeed (credentials provided below)
    Given the user provided right user name and password
    When sign in button is clicked
    Then user is taken to the news page

  Scenario: User opens web site next time (when previously logged in)
    Given the user opens web site next time
    Then user is taken straight to the news page




