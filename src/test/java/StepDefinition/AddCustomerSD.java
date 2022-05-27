package StepDefinition;

import Pages.BankManagerLogIn.AddCustomerPage;
import Web.UseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddCustomerSD {
    AddCustomerPage aCPage = new AddCustomerPage();

    @Given ("I launch XYZBank webpage")
    public void lunchWebPage() {
        UseDriver.openUrl("https://www.globalsqa.com/angularJs-protractor/BankingProject/");
    }
  //TQ-1
    //Scenario: Verify welcome message when adding new customer in "Add New Customer" section with all valid information
    @When   ("I click “Bank Manager Login” Button")
    public void clickBMLoginButt (){
        aCPage.bankManagerButt();
    }
    @And    ("I click “Add Customer” Button")
    public void clickaddCustomerButton(){
        aCPage.addCustomerButton();
    }
    @And   ("I enter Valid “First Name” in First name box")
    public void enterValFirstName (){
        aCPage.addFirstName("xyzname");
    }
    @And   ("I enter Valid “Last Name” in Last name box")
    public void enterValLastName (){
        aCPage.addLastName("hossen");
    }
    @And   ("I enter Valid “Post Code” in Post code box")
    public void enterValPostCode (){
        aCPage.addPostCode("12345");
    }
    @And   ("I click Add Customer on the Add Customer button")
    public void enterAddCustToSubmit (){
        aCPage.clickAddCusButt();
    }
    @Then  ("I verify welcome message when “Add New Customer” with valid First Name, Last Name and Post Code")
    public void verifyWelComeMessage (){
        Assert.assertTrue(aCPage.openAccountWelcomeMess(), "Error customer successfully added message did not displayed");
    }
  //TQ-2
    //Scenario: Verify on Add Customer Page, Error Message Displayed when “First Name” is not entered
    //When  I click “Bank Manager Login” Button
    //@And   ("I enter Valid “Last Name” in Last name box")
    //@And   ("I enter Valid “Post Code” in Post code box")
    //@And   ("I click Add Customer Button Without filling up the “First Name” Box")
    @Then  ("I verify if error message displayed when “First Name” is not Entered")
    public void verifyErrorMessageOnFirstNameNotEntered (){
        Assert.assertTrue(aCPage.errorMessageDisplayed(), "Error please fill out this field message did not displayed");
    }

  //TQ-3
    //Scenario: Verify on Add Customer Page, Error Message Displayed when “Last Name” is not entered
    //When  I click “Bank Manager Login” Button
    //And   I enter Valid “First Name” in First name box
    //And   I enter Valid “Post Code” in Post code box
    //And   I click Add Customer Button Without filling up the “Last Name” Box
    @Then  ("I verify if error message displayed when “Last Name” is not Entered")
    public void verifyErrorMessageOnLastNameNotEntered (){
        Assert.assertTrue(aCPage.errorMessageDisplayed(), "Error please fill out this field message did not displayed");
    }
  //TQ-4
    //Scenario: Verify on Add Customer Page, Error Message Displayed when “Post Code” is not entered
    //When  I click “Bank Manager Login” Button
    //And   I enter Valid “First Name” in First name box
    //And   I enter Valid “Last Name” in Last Name box
    //And   I click Add Customer Button Without filling up the “Post Code” Box
    @Then  ("I verify if error message displayed when “Post Code” is not Entered")
    public void verifyErrorMessageOnPostCodeNotEntered (){
        Assert.assertTrue(aCPage.errorMessageDisplayed(), "Error please fill out this field message did not displayed");
    }

}
