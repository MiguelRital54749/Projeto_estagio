Feature: Validating GET Post's
	Scenario: Verify if post return 100 post
		Given User sends GET request to posts
		Then response should contain 100 post
		And Status code should be 200

	Scenario: Verify a new title
		Given User sends GET request to posts with ID1
		Then the title of the post should be "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"

	 


	

	
	
	
	
	
	

	
	
	