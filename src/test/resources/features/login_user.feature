Feature: Login

  Scenario Outline: Successful login with existing credentials
    Given that the user navigates on the StartSharp page
    When he logs with credentials "<user>" and "<password>"
    Then he should see a message related to "<expected_message>"

    Examples:
      | user  | password | expected_message |
      | admin | serenity | Tablero          |