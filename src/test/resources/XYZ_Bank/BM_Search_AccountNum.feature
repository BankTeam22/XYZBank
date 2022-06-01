Feature: Search by Account number

  Scenario: Verify bank manager can search customer by account number
    Given I launch XYZ Bank website
    When I click 'Bank Manager Login' button
    When I click 'Customers' button
    When I enter a valid account number of a customer in the search box
    Then I verify the customer info is displayed in the result list