Feature: user can login with valid credentials

  Background: user is on the Seamlessly login page
    Given user is on the Seamlessly login page


  @2428
  Scenario Outline: user should be able to login successfully with valid credentials
    When user types valid username "<UsernameOrEmail>"
    And user types valid password to "<password>"
    And user clicks on log in button
    And user should see the dashboard
    Then  user should log out
    Examples:
      | UsernameOrEmail | password    |
      | Employee31      | Employee123 |
      | Employee131     | Employee123 |

  @2429
  Scenario Outline: User can not login with any invalid credentials
    When User types invalid username "<UsernameOrEmail>"
    And User types invalid password to "<password>"
    And user clicks on log in button
    And user should see Wrong username or password warning

    Examples:
      | UsernameOrEmail | password     |
      | Employee31      | Employee1234 |
      ##valid username, invalid password
      | Employee1311    | Employee123  |
      ##invalid username, valid password
      | employeE31      | Employee123  |
      ##case insensitive valid username

  @2430
  Scenario Outline: User should see "Please fill out this field" message if password or username is empty
    When User types empty username "<UsernameOrEmail>"
    And User types empty password to "<password>"
    And user clicks on log in button
    Then Verify that user sees "<errorOrAlertMessage>"

    Examples:
      | UsernameOrEmail | password    | errorOrAlertMessage         |
      |                 | Employee123 | Please fill out this field. |
      ##empty username, valid password
      | Employee31      |             | Please fill out this field. |
      ##valid username, empty password
  @wip
  Scenario: User should see password in a form of dots by default
    When User types any value to password "input"
    Then Verify that the password is invisible








