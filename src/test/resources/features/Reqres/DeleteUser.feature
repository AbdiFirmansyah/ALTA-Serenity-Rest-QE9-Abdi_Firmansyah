Feature: Reqres APi Automation Testing DELETE User
  @Tugas @Negative
  Scenario: Delete user with invalid parameter id
    Given Delete user with invalid id "aw"
    When Send request delete user
    Then Status code should be 400 Bad Request
