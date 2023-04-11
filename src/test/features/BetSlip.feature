Feature: Betika Betslip page
  Scenario: Enter invalid betslip id
    Given User successfully navigates to the betika "betslip" page
    When I enter betslip id "DRXVPC"
    And I click on the "Load betslip"
    Then I verify if the "Sorry. We can't find this betslip." alert pops up