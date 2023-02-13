Feature: Reqres APi Automation Testing GET Single User
  @Tugas @Positive
  Scenario Outline: Get single users with valid parameter id
    Given Get single users with valid parameter id <id>
    When Send request get single user
    Then Status code should be 200 OK
    And Response body page should be "<email>"
    And Get single users json schema validator
    Examples:
      | id | email               |
      | 3  | emma.wong@reqres.in |
      | 4  | eve.holt@reqres.in  |
  @Tugas @Negative
  Scenario Outline: Get single users with invalid parameter id
    Given Get single users with invalid parameter id <id>
    When Send request get single user
    Then Status code should be 404 Not Found
   Examples:
     | id  |
     | 100 |
     | 300 |


