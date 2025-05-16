Feature:Validating delete method
  Scenario: Verify if Delete Place functionality is working
    Given User Sends DELETE request to post with ID 1
    Then The response status code should be 200