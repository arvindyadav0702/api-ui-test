Feature: CoinDesk API - BPI Current Price

  Scenario: Verify the BPI contains USD, GBP, and EUR
    Given I send a GET request to the CoinDesk API
    Then the response should contain USD, GBP, and EUR
    And the GBP description should equal "British Pound Sterling"
