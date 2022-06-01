Feature: Bank Manager can delete a customer

  Scenario: Verify bank manager can delete a customer
    Given I launch XYZ Bank website
    When I click 'Bank Manager Login' button
    When I click 'Customers' button
    When I enter a valid last name of a customer in the search box
    And I click the delete button
    Then I verify the customer is deleted