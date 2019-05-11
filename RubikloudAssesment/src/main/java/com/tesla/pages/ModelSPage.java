package com.tesla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.tesla.reportutils.extentreports.ExtentTestManager;

public class ModelSPage extends BasePage{

	//*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "//section[@id='models']/article/div[2]/ul/li[4]/div/a[2]")
    public WebElement orderNow;
    
    //*********Constructor*********
    public ModelSPage (WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(this.driver,this);
    }
    
    public DesignStudioPage clickOrderNow(){
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Click on 'Order Now' of Model S");
    	click(orderNow, 5);
    	return new DesignStudioPage(driver);
    }
}
