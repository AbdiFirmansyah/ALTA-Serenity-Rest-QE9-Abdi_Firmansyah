Feature: Reqres APi Automation Testing PUT Update User
  @Tugas @Positive
  Scenario: put update user with valid json and valid parameter
    Given  Update user with valid json and parameter id 2
    When send request put update user
    Then Status code should be 200 OK
    And Response body name should be "Arshaka" and job is "superhero"
    And Validate update user json schema