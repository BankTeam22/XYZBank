package Web;


import Helper.Misc;
import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class WebCommands {

    public WebElement getElement(By locator) {
        return UseDriver.getDriver().findElement(locator);
    }

    public WebElement getElementWithScroll(By locator) {
        WebElement element = null;
        for (int i=1 ; i <= 20 ; i++) {
            try {
                element = UseDriver.getDriver().findElement(locator);
                break;
            } catch (NoSuchElementException e) {
                scrollDown(800);
            }
        }
        return element;
    }

    public WebElement getElementWithWait(By locator) {
        Wait fWait = new FluentWait(UseDriver.getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Element is not found within 30 seconds");

        WebElement element = (WebElement) fWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return element;
    }

    public List<WebElement> getElements(By locator) {
        return UseDriver.getDriver().findElements(locator);
    }

    public void type(By locator, String data) {
        getElementWithWait(locator).sendKeys(data);
        Misc.sleep(2);
    }

    public void typeAndEnter(By locator, String data) {
        getElementWithWait(locator).sendKeys(data,Keys.ENTER);
        Misc.sleep(2);
    }

    public void type(WebElement element, String data) {
        element.sendKeys(data);
        Misc.sleep(2);
    }

    public void clickThis(By locator) {
        getElementWithWait(locator).click();
        Misc.sleep(10);
    }

    public String getAttributeValue(By locator, String attributeName) {
        WebElement element = getElementWithWait(locator);
        return element.getAttribute(attributeName);
    }

    public String  getTextValue(By locator) {
        WebElement element = getElementWithWait(locator);
        return element.getText();
    }

    public void scrollUpToElementAndClick(By locator){
        WebElement element = getElementWithWait(locator);
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        clickThis(element);
        Misc.sleep(10);
    }
    public void scrollUpToElement(By locator){
        WebElement element = getElementWithWait(locator);
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Misc.sleep(20);
    }

    public void scrollUpToBottomAndClick(By locator){
        UseDriver.getDriver().manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Misc.sleep(10);
        clickThis(locator);
        Misc.sleep(10);
    }
    public void scrollUpToBottom(){
        UseDriver.getDriver().manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        Misc.sleep(10);
    }

    public void clickThis(WebElement element) {
        element.click();
        Misc.sleep(10);
    }

    public void selectFromDropdown(By locator, String dataToSelect) {
        WebElement dropdownElement = getElement(locator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(dataToSelect);
        Misc.sleep(2);
    }

    public String getHandle() {
        return UseDriver.getDriver().getWindowHandle();
    }

    public Set<String> getAllHandles() {
        return UseDriver.getDriver().getWindowHandles();
    }

    public void switchToHandle(String handle) {
        UseDriver.getDriver().switchTo().window(handle);
    }

    public void verifyHandles(String handle){
        Set<String> allHandles = getAllHandles();
        for(String tabHandles : allHandles) {
            if (!(tabHandles.equals(handle))) {
                switchToHandle(tabHandles);
            }
        }
    }

    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();     // Casting
        js.executeScript("scrollBy(0,"+pixels+");");
        Misc.sleep(3);
    }

    public void scrollUp(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) UseDriver.getDriver();     // Casting
        js.executeScript("scrollBy(0,-"+pixels+");");
        Misc.sleep(2);
    }

    public void moveMouseToElementAndClick(By locator) {
        WebElement element = getElement(locator);
        Actions act = new Actions(UseDriver.getDriver());
        act.moveToElement(element).click().perform();
    }

    public void moveMouseToElement(WebElement element) {
        Actions act = new Actions(UseDriver.getDriver());
        act.moveToElement(element);
    }

    public void clickOneOfElementsUsingText(By locator, String text) {
        List<WebElement> allElements = getElements(locator);
        for (WebElement element : allElements) {
            String elementText = element.getText();
            if (elementText.equalsIgnoreCase(text)) {
                clickThis(element);
                Misc.sleep(2);
                break;
            }
        }
    }

    public String[] getTextOfElements(By locator) {
        int i=0;
        List<WebElement> allElements = getElements(locator);
        String[] elementText = new String[allElements.size()];
        for (WebElement element : allElements) {
            elementText[i] = element.getText();
            i++;
        }
        return elementText;
    }


    public void clickOneOfElementsUsingAttributeValue(By locator, String attributeName, String attributeValue) {
        List<WebElement> allElements = getElements(locator);
        for (WebElement element : allElements) {
            String attributeValueFromWeb = element.getAttribute(attributeName);
            if (attributeValueFromWeb.equalsIgnoreCase(attributeValue)) {
                clickThis(element);
                Misc.sleep(2);
                break;
            }
        }
    }

    public Alert waitForAlert() {
        WebDriverWait webDriverWait = new WebDriverWait(UseDriver.getDriver(), 20);
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        return UseDriver.getDriver().switchTo().alert();
    }

    public void clickPositiveButtonOnAlert() {
        Alert alert = waitForAlert();
        alert.accept();
    }

    public void clickNegativeButtonOnAlert() {
        Alert alert = waitForAlert();
        alert.dismiss();
    }

    public String getTextFromAlert() {
        Alert alert = waitForAlert();
        return alert.getText();
    }

    public void switchToFrame(String idValue) {
        UseDriver.getDriver().switchTo().frame(idValue);
    }

    public void switchToFrame(By locator) {
        WebElement element = getElementWithScroll(locator);
        UseDriver.getDriver().switchTo().frame(element);
    }
    public int getNoOfFrames(){
        return UseDriver.getDriver().findElements(By.tagName("iframe")).size();
    }
    public void dropDown(By locator, String data){
        WebElement element = getElementWithWait(locator);
        Select value = new Select(element);
        value.selectByVisibleText(data);
    }
    public boolean verifyIcon(By locator){
        WebElement element = getElementWithWait(locator);
        String innerHTMLText = element.getAttribute("outerHTML");
        if (innerHTMLText.contains("::after"))
            return true;
        else
            return false;

    }
    /*public WebElement verifyTickMarks(){
        WebElement tickElement = UseDriver.getDriver().findElement(By.cssSelector("input:checked"));
        return tickElement;
    }*/
    public String getPseudoAfterContent(WebElement target) {
        String script = "return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');";
        Object content = ((JavascriptExecutor) UseDriver.getDriver()).executeScript(script, target);
        return (String)content;
    }
    public String pseudoElementTag(By locator){
        WebElement tickElement = getElementWithWait(locator);
        String value = getPseudoAfterContent(tickElement);
        return value;
    }

    public boolean isWebElementDisplayed(By locator) {
        return getElementWithWait(locator).isDisplayed();
    }

    public boolean isWebElementEnabled(By locator) {
        return getElementWithWait(locator).isEnabled();
    }

    public boolean isWebElementSelected(By locator) {
        return getElementWithWait(locator).isSelected();
    }

}

