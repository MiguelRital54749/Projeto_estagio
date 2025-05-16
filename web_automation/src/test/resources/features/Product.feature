
Feature: Work in the product area

  Scenario Outline: The user add two items in the cart and check the value of all two
    Given   User is on login page
    When    User enters username
    And     User enters password
    Then    User clicks on signing button
    And User adds two products to cart "<firstProduct>" "<secondProduct>"
    And User clicks on shopping cart
    And User clicks checkout
    And User add the information with firstName "<firstName>", lastName "<lastName>" and zipCode "<zipcode>"
    And User click in the continue
    Then Verify if the total price is correct
    Examples:
      | firstProduct | secondProduct | firstName | lastName | zipcode |
      | add-to-cart-sauce-labs-backpack | add-to-cart-sauce-labs-bike-light | standard | user | 1234 |

  Scenario Outline: The user remove one item for the cart and check if has been successfully remove
    Given   User is on login page
    When    User enters username
    And     User enters password
    Then    User clicks on signing button
    And User adds two products to cart "<firstProduct>"
    And User clicks on shopping cart
    And User remove the item "<Product>" from the cart
    Then Verify if the item "<Product>" is remove
    Examples:
      | firstProduct |  Product |
      | add-to-cart-sauce-labs-backpack | remove-sauce-labs-backpack |

 Scenario Outline: The user add an item in the cart and finalize the buy
   Given   User is on login page
   When    User enters username
   And     User enters password
   Then    User clicks on signing button
   And User adds two products to cart "<firstProduct>" "<secondProduct>"
   And User clicks on shopping cart
   And User clicks checkout
   And User add the information with firstName "<firstName>", lastName "<lastName>" and zipCode "<zipcode>"
   And User click in the continue
   Then user finalize the buy and return to initial page
   Examples:
     | firstProduct | secondProduct | firstName | lastName | zipcode |
     | add-to-cart-sauce-labs-backpack | add-to-cart-sauce-labs-bike-light | standard | user | 1234 |




