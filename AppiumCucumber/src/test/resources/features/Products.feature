
Feature: Product scenarios

  Scenario Outline: Add Product in the Cart and Validate
    Given I'm logged in
    And I click product title "<title>"
    And I Add product in the Cart
    And I click CartButton
    Then the product is listed with title "<title>" and price "<price>" should be equal to menu
    Examples:
      | title                   | price |
      | Sauce Labs Backpack| $29.99 |

  Scenario Outline: Finish the Buy

    When I click in the checkoutButton
    And complete the firstName "<FirstName>" lastName "<LastName>" and PostalCode "<ZipPostalCode>"
    And I click in continue button
    And I click in finish button
    Then I click in Back Home
    Examples:
    | FirstName     |   LastName    | ZipPostalCode
    | user          | Standard      | sdasda





