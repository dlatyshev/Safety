Feature: Log in to the Safety application
  Log in to the Safety application using valid credentials

  Scenario: Log in to the Safety
    Given user entered the login page
    When user entered valid credentials and click login button
    Then Safety main page is opened