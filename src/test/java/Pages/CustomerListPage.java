package Pages;

import Web.UseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerListPage {

    By searchPlaceholderLocator = By.xpath("//input[@placeholder='Search Customer']");
    By deleteButtonLocator = By.xpath("//button[text()='Delete']");
    By postCodeLocator = By.xpath("//td[contains(text(),'E55555')]");
    // By searchLastNameLocator = By.xpath("//a[contains(.,'Last Name']");
    //By searchAccountNumLocator = By.xpath("//td[contains(text(),'Account Number')]");
    //By searchPostcodeLocator = By.xpath("//a[contains(text(),'Post Code')]");


    public void enterLastName() {
        String lastName = "Potter";
        UseDriver.getDriver().findElement(searchPlaceholderLocator).sendKeys(lastName);
    }

    public void enterFirstName() {
        String firstName = "Ron";
        UseDriver.getDriver().findElement(searchPlaceholderLocator).sendKeys(firstName);
    }

    public void enterPostCode() {
        String postCode = "E55555";
        UseDriver.getDriver().findElement(searchPlaceholderLocator).sendKeys(postCode);
    }

    public void enterAcctNum() {
        String acctNum = "1001 1002";
        UseDriver.getDriver().findElement(searchPlaceholderLocator).sendKeys(acctNum);
    }

    public void deleteCustomer() {
        UseDriver.getDriver().findElement(deleteButtonLocator).click();
    }

    public boolean isWebElementDisplayed() {
        return UseDriver.getDriver().findElement(postCodeLocator).isDisplayed();
    }

}







