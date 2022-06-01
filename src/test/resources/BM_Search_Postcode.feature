Feature: BM_Search_Postcode

  Scenario: Verify bank manager can search customer by postcode
    Given I launch XYZ Bank website
    When I click 'Bank Manager Login' button
    When I click 'Customers' button
    When I enter a valid postcode of a customer in the search box
    Then I verify the customer info is displayed in the result list