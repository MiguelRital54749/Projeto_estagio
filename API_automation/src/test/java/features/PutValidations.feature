Feature: Validating Put method
  Scenario: User update a new title and validate the answer
    Given User updates the post with ID 1 with title "update title", body "update body", and userid 1
    Then The response status code should be 200
    And The response give id 1
