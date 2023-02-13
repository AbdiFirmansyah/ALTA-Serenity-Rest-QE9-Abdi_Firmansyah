Feature: Reqres api Automation Testing POST Login User
  @Tugas @Positive
  Scenario: Post login user with valid data
    Given User login with valid username and password
    When Send request post login user
    Then Status code should be 200 OK
    And Validate json schema successes login user
  @Tugas @Negative
  Scenario: User login with valid email and empty password
    Given Send login with empty password
    When Send request post login
    Then Status code should be 400 Bad Request
    And Responses body status should be "Missing password"
    And Validate empty password json schema


