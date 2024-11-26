@All
Feature: Login Tests

  Scenario Outline: Happy path

    Given I go to the main page
    When I enter the username <username>
    And I enter the password <password>
    And I click in Login button
    Then I should be redirected to inventory page
    And I wait 5 seconds

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  Scenario Outline: Wrong password tests

    Given I go to the main page
    When I enter the username <username>
    And I enter the password <password>
    And I click in Login button
    Then An error button should be displayed
    And I wait 5 seconds

    Examples:
      | username                | password            |
      | standard_user           | firstWrongPassword  |
      | standard_user           | ‘ or 1=1;           |
      | locked_out_user         | secondWrongPassword |
      | locked_out_user         | abcd/*/%%(          |
      | problem_user            | thirdWrongPassword  |
      | problem_user            | 12345676789         |
      | performance_glitch_user | fourthWrongPassword |
      | performance_glitch_user | ''' or 2=2          |
      | error_user              | fifthWrongPassword  |
      | error_user              |                     |
      | visual_user             | sixthWrongPassword  |
      | visual_user             | 常用漢字              |