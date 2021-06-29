Feature: Login

  @GenerateLoginToken
  Scenario Outline: Verify StartEmmi Login API
    Given login API payload with "<accessCode>" and "<dob>"
    When "POST" request is sent with "loginToken" resource
    Then loginToken is generated with 200 statusCode

    Examples:
    |accessCode|dob|
    |10590510151|01/01/2020|


