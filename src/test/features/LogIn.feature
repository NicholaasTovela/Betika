Feature: Betika website log in page
  Scenario Outline: Verify that a user is successfully logged in
    Given User successfully navigates to the betika "intent" page
    When I enter "<username>" and "<password>"
    And I click on the "log in button"
    Then I verify if the "Success" alert pops up

    Examples:
      | username       | password |
      | 254735 638271  | 2020     |


  Scenario Outline: Verify unsuccessful log in
    Given User successfully navigates to the betika "intent" page
    When I enter "<username>" and "<password>"
    And I click on the "log in button"
    Then I verify if the "Login Failed" alert pops up

    Examples:
      | username       | password |
      | 254735 638272  | 2128     |