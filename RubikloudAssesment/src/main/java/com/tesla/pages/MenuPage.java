package com.tesla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.tesla.reportutils.extentreports.ExtentTestManager;

public class MenuPage extends BasePage{
	
	//*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "//header[@id='tds-header-main']/div/div/nav/div[2]/ol/li[7]/a")
    public WebElement carbonImpact;
    
    //*********Constructor*********
    public MenuPage (WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(this.driver,this);
    }
    
    public CarbonImpactPage clickCarbonImpact(){
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Click on 'Carbon Impact' in the Menu");
    	click(carbonImpact, 5);
    	return new CarbonImpactPage(driver);
    }

}
