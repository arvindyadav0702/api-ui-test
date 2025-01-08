Feature: Verify item can be added to the cart

  Scenario: Verify item can be added to Cart
    Given I open the browser and navigate to eBay
    When I search for "book"
    And I click on the first book in the list
    And I click on "Add to cart"
    Then I should see that the cart contains one item
