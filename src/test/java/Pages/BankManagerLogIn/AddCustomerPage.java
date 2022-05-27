package Pages.BankManagerLogIn;

import Web.UseDriver;
import Web.WebCommands;
import org.openqa.selenium.By;

public class AddCustomerPage extends WebCommands {

    By bankManagerLoginButtonLoc = By.xpath("//button[normalize-space()='Bank Manager Login']");
    By addCustButtonLoc = By.xpath("//button[normalize-space()='Add Customer']");
    By firstNameBoxLoc = By.xpath("//input[@placeholder='First Name']");
    By lastNameBoxLoc = By.xpath("//input[@placeholder='Last Name']");
    By postCodeBoxLoc = By.xpath("//input[@placeholder='Post Code']");
    By addCustButtonToSubmitApplication = By.xpath("//button[@type='submit']");
    By openAccountMessageLoc = By.xpath("//button[normalize-space()='Open Account']");
    By errorMessageLoc = By.xpath("//button[normalize-space()='Open Account']");


    public void bankManagerButt (){
        clickThis(bankManagerLoginButtonLoc);
    }
    public void addCustomerButton (){
        clickThis(addCustButtonLoc);
    }
    public void addFirstName (String fName){
        type(firstNameBoxLoc, fName);
    }
    public void addLastName (String lName){
        type(lastNameBoxLoc, lName);
    }
    public void addPostCode (String postCd){
        type(postCodeBoxLoc, postCd);
    }
    public void clickAddCusButt (){
        clickThis(addCustButtonToSubmitApplication);
    }
    public boolean openAccountWelcomeMess (){
        return isWebElementDisplayed(openAccountMessageLoc);
    }
    public boolean errorMessageDisplayed (){
        return isWebElementDisplayed(errorMessageLoc);
    }
}
