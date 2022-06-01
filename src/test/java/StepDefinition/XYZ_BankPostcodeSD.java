package StepDefinition;

import Helper.Check;
import Pages.CustomerListPage;
import Pages.LaunchPage;
import Pages.ManagerHomepage;
import Web.UseDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static Helper.Check.*;

public class XYZ_BankPostcodeSD {

    @Given("^I launch XYZ Bank website$")
    public void launchXYZ_Bank() {
        UseDriver.openUrl("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }
    @When("^I click 'Bank Manager Login' button$")
    public void clickBankManagerLogin() {
        LaunchPage lp = new LaunchPage();
        lp.clickManagerLogin();
    }
    @When("^I click 'Customers' button$")
    public void clickCustomersButton() {
        ManagerHomepage mgrHome = new ManagerHomepage();
        mgrHome.clickCustomer();
    }
    @When("^I enter a valid postcode of a customer in the search box$")
    public void searchByPostCode() {
        CustomerListPage customerListP = new CustomerListPage();
        customerListP.enterPostCode();
    }
    @Then("^I verify the customer info is displayed in the result list$")
    public void verifyPostCodeDisplayedInSearchResult() {
        Check.checkTrue("Customer postcode result is as expected");
    }
}
