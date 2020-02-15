Feature: Demo Get Employees
    As a member of SDET team
    I need to verify the results of Get Employees API
    To avoid any unexpected failures

 Scenario: Verify the Get Employees API
    When I perform Get Employees Rest API call against the demo endpoint
    Then I should get a list of employees successfully