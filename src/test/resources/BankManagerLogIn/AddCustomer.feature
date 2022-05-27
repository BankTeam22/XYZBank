
@regression @sanity
Feature: XYZBank

  Background:
    Given I launch XYZBank webpage

  #TQ-1
  @regression @addNewCustomer
  Scenario: Verify welcome message when adding new customer in "Add New Customer" section with all valid information
    When  I click “Bank Manager Login” Button
    And   I click “Add Customer” Button
    And   I enter Valid “First Name” in First name box
    And   I enter Valid “Last Name” in Last name box
    And   I enter Valid “Post Code” in Post code box
    And   I click Add Customer on the Add Customer button
    Then  I verify welcome message when “Add New Customer” with valid First Name, Last Name and Post Code

  #TQ-2
  @regression @errorMsgFN
  Scenario: Verify on Add Customer Page, Error Message Displayed when “First Name” is not entered
    When  I click “Bank Manager Login” Button
    And   I enter Valid “Last Name” in Last name box
    And   I enter Valid “Post Code” in Post code box
    And   I click Add Customer on the Add Customer button
    Then  I verify if error message displayed when “First Name” is not Entered

  #TQ-3
  @regression @errMsgLN
  Scenario: Verify on Add Customer Page, Error Message Displayed when “Last Name” is not entered
    When  I click “Bank Manager Login” Button
    And   I enter Valid “First Name” in First name box
    And   I enter Valid “Post Code” in Post code box
    And   I click Add Customer on the Add Customer button
    Then  I verify if error message displayed when “Last Name” is not Entered

  #TQ-4

  @regression @errMsgPC
  Scenario: Verify on Add Customer Page, Error Message Displayed when “Post Code” is not entered
    When  I click “Bank Manager Login” Button
    And   I enter Valid “First Name” in First name box
    And   I enter Valid “Last Name” in Last name box
    And   I click Add Customer on the Add Customer button
    Then  I verify if error message displayed when “Post Code” is not Entered

