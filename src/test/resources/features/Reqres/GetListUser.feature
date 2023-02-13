Feature: Reqres APi Automation Testing GET List User
  @Tugas @Positive
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
    @Tugas @Negative
    Scenario: Get list users with invalid parameter page
      Given Get list parameter with invalid page "hgfhgdjhgd"
      When Send request get list users
      Then Status code should be 404 Not Found