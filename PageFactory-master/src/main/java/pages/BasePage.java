package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
    
    public WebElement waitForVisibility(WebElement element, int iWaitInSeconds){
    	WebDriverWait wait = new WebDriverWait(this.driver, iWaitInSeconds);
    	return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Click Method
    public void click (WebElement element, int iWaitInSeconds) {
    	waitForVisibility(element, iWaitInSeconds).click();
    }

    //Write Text
    public void writeText (WebElement element, String text, int iWaitInSeconds) {
    	waitForVisibility(element, iWaitInSeconds).sendKeys(text);
    }

    //Read Text
    public String readText (WebElement element, int iWaitInSeconds) {
        return waitForVisibility(element, iWaitInSeconds).getText();
    }
}
