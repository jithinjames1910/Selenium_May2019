package com.tesla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.tesla.reportutils.extentreports.ExtentTestManager;

public class HomePage extends BasePage{
	
	//*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "//header[@id='tds-header-main']/div/div/nav/div/ol/li/a")
    public WebElement modelS;
    
    @FindBy(how = How.XPATH, using = "//header[@id='tds-header-main']/div/div/label/span")
    public WebElement menuIcon;
    
    //*********Constructor*********
    public HomePage (WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(this.driver,this);
    }
    
    public HomePage goToHomePage(){
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Tesla home page");
    	driver.get("https://www.tesla.com/en_CA");
    	return this;
    }
    
    public ModelSPage clickModelS(){
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Click on 'Model S' link");
    	click(modelS, 5);
    	return new ModelSPage(driver);
    }
    
    public MenuPage clickMenu(){
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Menu icon");
    	click(menuIcon, 5);
    	return new MenuPage(driver);
    }

}
