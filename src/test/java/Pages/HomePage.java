package Pages;

import Helper.Misc;
import Web.WebCommands;
import org.openqa.selenium.By;

public class HomePage extends WebCommands {
    By homeLocator = By.xpath("//button[normalize-space()='Home']");
    By customerLoginLocator = By.xpath("//button[normalize-space()='Customer Login']");
    By bankManagerLoginLocator = By.xpath("//button[normalize-space()='Bank Manager Login']");

    public void clickBankManagerLogin(){
        Misc.sleep(1);
        clickThis(bankManagerLoginLocator);
    }
}
