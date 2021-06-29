Feature: Picker Page

  @PickerPage
  Scenario: Verify programs are shown at the Picker page
    Given programsPicker API
    When "GET" request is sent with "programsPicker" resource
    And "1" is provided for viewGroup
    Then response is generated with 200 statusCode

