Feature: Reqres APi Automation Testing QE-9
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list user
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page |
      | 1    |
      | 2    |
  @Latihan
  Scenario: Post create new user with valid json file
    Given Create new user with valid json
    When Send request post create user
    Then Status code should be 201 Created
    And Response body name should be "Abdi Firmansyah" and job is "QE-9"
  @Latihan
  Scenario Outline: put update user with valid json and valid parameter id
    Given  Update user with valid json and parameter id <id>
    When send request put update user
    Then Status code should be 200 OK
    And Response body name should be "Abdi Firmansyah" and job is "QE-9"
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
    @Latihan
    Scenario Outline: Delete user with parameter id
      Given Delete user with valid id <id>
      When Send request delete user
      Then Status code should be 204 No content
      Examples:
        | id |
        | 1  |
        | 2  |

