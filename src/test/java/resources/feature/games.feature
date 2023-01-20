Feature: Testing functionality of Get Bingo lobby feed

  Scenario: Verify that the 'non-null' game frequency has been set to 300,000
    When User send a GET request to the Get Bingo Lobby feed end point
    Then verifies that the non-null game frequency has been set to 300000