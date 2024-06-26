Feature: Adding goods to storage

  Scenario: Successful addition of goods
    Given I have access to the warehouse management system
    When I add the following goods
      | name    | quantity | price |
      | Milk    | 10       | 22.50 |
      | Bread   | 15       | 10.75 |
      | Apples  | 20       | 15.00 |
    Then the system should contain all these goods
    And the total number of goods in storage should be 45