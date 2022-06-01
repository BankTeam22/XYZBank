Feature: BM_Search_LastName

  Scenario: Verify bank manager can search Customer by last name
    Given I launch XYZ Bank website
    When I click 'Bank Manager Login' button
    When I click 'Customers' button
    When I search the customer by last name
    Then I press the delete button for this customer
    Then I verify if the customer is deleted
