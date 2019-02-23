Feature: Match list and minimum bet price

  @minimum_bet
  Scenario: Visitor should see minimum bet price
    Given Visitor is on the Application Home
    And   Visitor logs in to Application with "11041624582" username and "DenemeD1@" password
    And   User goes to Football Bet list
    And   User goes to Filter
    And   User selects 1 th League
    When  User adds first 4 match to bet list
    And   User goes to bet checkout list
    Then  User should see "Kupon bedeliniz en az 3 TL olmalıdır." warning message

  @match_list
  Scenario: Visitor should see same count
    Given Visitor is on the Application Home
    And   Visitor logs in to Application with "11041624582" username and "DenemeD1@" password
    And   User goes to Football Bet list
    And   User goes to Filter
    When  User selects 1 th League
    Then  User should see matches the number of selected league
