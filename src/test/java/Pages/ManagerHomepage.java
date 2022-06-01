package Pages;

import Web.UseDriver;
import org.openqa.selenium.By;

public class ManagerHomepage {
    By customerButtonLocator = By.xpath("//button[contains(@ng-click, 'showCust()')]");

    public void clickCustomer() {
        UseDriver.getDriver().findElement(customerButtonLocator).click();

    }

}
