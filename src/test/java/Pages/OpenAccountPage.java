package Pages;

import Web.WebCommands;
import org.openqa.selenium.By;

public class OpenAccountPage extends WebCommands{
    By openAccountLocator = By.xpath("//button[normalize-space()='Open Account']");
    By homeLocator = By.xpath("//button[normalize-space()='Home']");
    By customerNameLocator = By.xpath("//select[@id='userSelect']");
    By currentcyLocator = By.xpath("//select[@id='currency']");
    By processLocator = By.xpath("//button[normalize-space()='Process']");

    public void clickOpenAccountButton(){
        clickThis(openAccountLocator);
    }

    public void selectCustomerName(String name){
        selectFromDropdown(customerNameLocator, name);
    }

    public void chooseCurrency(String cur){
        selectFromDropdown(currentcyLocator, cur);
    }

    public void clickProcessButton(){
        clickThis(processLocator);
    }
}