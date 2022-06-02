@openAccount
  Feature: Open Account
    Background:
      Given I Launch XYZBank website
      Then I Click on Bank Manager Login button
      Then I click on Open Account button

    @accountOpen @sanity
    Scenario: Verify Open Account feature is working, By choosing data from Customer name and Currency dropdowns
      When I Choose Customer Name from Customer dropdown
      When I Choose Any Currency Type from Currency dropdown
      And I Click on Process button
      And I Verify: Account created successfully with account Number: message - is displayed

    @errorNoDataEntered
    Scenario: Verify Error popup displayed when Customer and Currency left blank
      When I Click on Process button
      Then I Verify: Please select an item in the list message - is displayed

    @noNameError
    Scenario: Verify Error popup displayed when only Currency - is entered
      When I Choose Any Currency Type from Currency dropdown
      And I Click on Process button
      Then I Verify: Please select an item in the list message - is displayed

    @noCurrencyError
    Scenario: Verify Error popup displayed when only Customer name is entered
      When I Choose Customer Name from Customer dropdown
      And I Click on Process button
      Then I Verify: Please select an item in the list message - is displayed