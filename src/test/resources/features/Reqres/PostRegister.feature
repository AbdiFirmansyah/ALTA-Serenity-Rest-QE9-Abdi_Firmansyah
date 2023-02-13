Feature: Reqres APi Automation Testing POST Register User
  @Tugas @Positive
  Scenario: Post register user with valid json file
    Given Register user with valid json
    When Send request post register user
    Then Status code should be 200 OK
    And Response body id should be 4 and token is "QpwL5tke4Pnpja7X4"
    And Validate register user json schema
    @Tugas @Negative
    Scenario: Post register user with invalid json file
      Given Register user with invalid json
      When Send request post register user
      Then Status code should be 400
      And Validate json schema failed register user

