Feature: Log in to the Safety application
  Log in to the Safety application using valid credentials

  Scenario Outline: Log in to the Safety
    Given user entered the login page
    When user entered "<login>" and "<password>" and click login button
    Then Safety main page is opened

    Examples:
      | login                                              | password  |
      | roman.khudyakov@highpointsolutions.com.safety.dev1 | Poqw09123 |