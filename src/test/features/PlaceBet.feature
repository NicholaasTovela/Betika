Feature: Placing bets on betika
  Scenario: Successfully place random bet
    Given User successfully navigates to the betika "betting" page
    When I place bet randomly by randomly clicking odds
    Then I verify if the "Bet Placement Successful" alert pops up

  Scenario: Successfully place bet team of choice
    Given User successfully navigates to the betika "betting" page
    When I place bet for select teams on line number "2" from the list
    Then I verify if the "Bet Submitted" alert pops up


