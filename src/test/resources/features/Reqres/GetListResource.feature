Feature: Reqres APi Automation Testing GET List Resource
  @Tugas @Positive
  Scenario: Get list user with unknown parameter
    Given Get list users with unknown parameter
    When Send request get list unknown
    Then Status code should be 200 OK
    And Validate get list resource json schema

