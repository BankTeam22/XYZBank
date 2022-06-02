package StepDefinition;

import Helper.Check;
import Helper.Misc;
import Pages.HomePage;
import Pages.OpenAccountPage;
import Web.UseDriver;
//import cucumber.api.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Test;

    public class OpenAccountSD {
        HomePage hp = new HomePage();
        OpenAccountPage openAcctPage = new OpenAccountPage();

        @Given ("^I Launch XYZBank website$")
        public void launchHopePage()  {
            UseDriver.openUrl();
        }

        @Then("^I Click on Bank Manager Login button$")
        public void iClickOnBankManagerLoginButton() {
            hp.clickBankManagerLogin();
        }

        @Then("^I click on Open Account button$")
        public void iClickOnOpenAccountButton() {
            openAcctPage.clickOpenAccountButton();
        }

        @When("^I Choose Customer Name from Customer dropdown$")
        public void iChooseCustomerNameFromCustomerDropdown() {
            openAcctPage.selectCustomerName("Ron Weasly");
        }

        @When("^I Choose Any Currency Type from Currency dropdown$")
        public void iChooseAnyCurrencyTypeFromCurrencyDropdown() {
            openAcctPage.chooseCurrency("Dollar");
        }

        @And("^I Click on Process button$")
        public void iClickOnProcessButton() {
            openAcctPage.clickProcessButton();
        }

        @Then("^I Verify: Please select an item in the list message - is displayed$")
        public void iVerifyPleaseSelectAnItemInTheListMessageIsDisplayed() {
            //Need to assert here
        }

        @And("^I Verify: Account created successfully with account Number: message - is displayed$")
        public void iVerifyAccountCreatedSuccessfullyWithAccountNumberMessageIsDisplayed() {
            openAcctPage.waitForAlert();
            String message = openAcctPage.getTextFromAlert().substring(0,50);
            openAcctPage.clickPositiveButtonOnAlert();
            Misc.sleep(1);
            Check.checkEquals(message, "Account created successfully with account Number :", "Expected message for the account opening is - not shown!" );

        }



    }
