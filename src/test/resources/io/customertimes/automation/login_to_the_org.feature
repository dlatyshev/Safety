Feature: Log in to the Safety application
  Log in to the Safety application using valid credentials
  Scenario: Log in to the Safety
    Given user entered the website
    When user clicked the login button
    Then login page is opened
    When user entered valid credentials and press Enter
    Then org main page is opened