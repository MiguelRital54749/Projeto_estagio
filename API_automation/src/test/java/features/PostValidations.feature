Feature: Validating Post method
  Scenario Outline: User create a new post and expect the return ID
    Given User create a new post with the "<title>", "<body>" and ID 11
    Then The response status code should be 201
    And The response should contain a post with ID
    Examples:
    |title | body |
    |hello | Bye  |
