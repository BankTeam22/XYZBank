package Web;

import Helper.DataReader;
import Helper.Misc;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UseDriver {

    static WebDriver driver;

    //When url is given inside the method
    //When working with single website in various browsers and various environments
    /*@Before
    public static void openUrl() {

        DataReader data = new DataReader();
        String sauceUrl = "https://"+data.getSauceUser()+":"+data.getSauceKey()+"@ondemand.us-west-1.saucelabs.com:443/wd/hub";

        switch (data.getEnv().toLowerCase()) {
            case "local":
                switch(data.getBrowserName().toLowerCase()){
                    case "chrome":
                        System.setProperty("webdriver.chrome.driver",data.getChromeDriverPath());
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        System.setProperty("webdriver.firefox.driver",data.getFirefoxDriverPath());
                        driver = new FirefoxDriver();
                        break;
                }
                break;
            case "sauce":
                DesiredCapabilities capabilities = null;
                switch (data.getBrowserName().toLowerCase()){
                    case "chrome":
                        capabilities = DesiredCapabilities.chrome();
                        break;
                    case "firefox":
                        capabilities = DesiredCapabilities.firefox();
                        break;
                }
                capabilities.setCapability("version",data.getVersion());
                capabilities.setCapability("platform",data.getPlatform());

                try {
                    driver = new RemoteWebDriver(new URL(sauceUrl),capabilities);
                } catch (MalformedURLException e) {
                }
                driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
                driver.get(data.getUrl());
                // Misc.sleep(2);
        }
    }*/

    //When passing the url
    //When working in my machine only
    public static void openUrl(String url) {
        System.setProperty("webdriver.chrome.driver" , "Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get(url);
        Misc.sleep(2);
    }

    //This will start executing before every Scenario
    // @Before
    public static void openUrl() {
        System.setProperty("webdriver.chrome.driver" , "Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/");
        // Misc.sleep(2);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    //This will get executed after every Scenario
    @After
    public static void quitWebPages() {
        driver.quit();
    }
}