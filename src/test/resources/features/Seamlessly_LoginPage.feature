Feature: user can login with valid credentials

  Background: user is on the Seamlessly login page
    Given user is on the Seamlessly login page


  @SEAMLES-2428
  Scenario Outline: user should be able to login successfully with valid credentials
    When user types valid username "<UsernameOrEmail>"
    And user types valid password to "<password>"
    And user clicks on log in button or press enter "<buttonType>"
    Then user should see the dashboard

    Examples:
      | UsernameOrEmail | password    | buttonType|
      | Employee31      | Employee123 | click     |


  @SEAMLES-2429
  Scenario Outline: User can not login with any invalid credentials
    When User types invalid username "<UsernameOrEmail>"
    And User types invalid password to "<password>"
    And user clicks on log in button
    And user should see Wrong username or password warning

    Examples:
      | UsernameOrEmail | password     |
      | Employee31      | Employee1234 |


  @SEAMLES-2430
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








