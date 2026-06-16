Feature: Logout

  Scenario Outline: Successful logout with existing credentials
    Given that the user navigates on the StartSharp page
    When he logs with credentials "<user>" and "<password>"
    And he logs out
    Then he should be redirected to the login page

    Examples:
      | user  | password |
      | admin | serenity |