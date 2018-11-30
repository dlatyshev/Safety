Feature: Log in to the Safety application
  Log in to the Safety application using valid credentials

  Scenario Outline: Log in to the Safety
    Given user opened the "<browser>"
    Given user opened the login page
    When user entered "<login>" and "<password>" and clicked login button
    Then Safety home page was opened
    Then browser was closed

    Examples:
      | browser | login                                              | password  |
      | chrome  | roman.khudyakov@highpointsolutions.com.safety.dev1 | Poqw09123 |