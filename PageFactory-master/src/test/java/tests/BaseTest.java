package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup () {
        //Create a Chrome driver. All test classes use this.
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities dCapab = DesiredCapabilities.chrome();
		options.setExperimentalOption("useAutomationExtension", false); 
		options.addArguments("disable-extensions");
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		options.addArguments("--disable-popup-blocking");
		dCapab.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(dCapab);
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }
}
