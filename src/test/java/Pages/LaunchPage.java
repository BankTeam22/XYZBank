package Pages;

import Web.UseDriver;
import org.openqa.selenium.By;

public class LaunchPage {

    //Locator of elements on launch page
    By BankMangerLoginLocator = By.xpath("//button[ng-click='manager()']");

    public void clickManagerLogin() {
        UseDriver.getDriver().findElement(BankMangerLoginLocator).click();
    }

    }
