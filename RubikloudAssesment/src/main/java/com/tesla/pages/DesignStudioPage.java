package com.tesla.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.tesla.reportutils.extentreports.ExtentTestManager;
import com.tesla.utils.StringUtils;

public class DesignStudioPage extends BasePage{
	
	//*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "//div[@id='summary-lease-cash-wrapper']/ul/li[3]/a")
    public WebElement cashTab;
    
    @FindBy(how = How.XPATH, using = "//div[@id='cash']/div[3]/div[2]/h2")
    public WebElement totalCash;
    
    @FindBy(how = How.XPATH, using = "//div[@id='options_category_C_OPTS']/div/div/div/div/div[2]/div/div/i")
    public WebElement autoPilotCheckbox;
    
    @FindBy(how = How.XPATH, using = "//div[@id='options_category_C_OPTS']/div/div/div/div/div[2]/div[2]/div[2]/h4")
    public WebElement autoPilotFee;
    
    //*********Constructor*********
    public DesignStudioPage (WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(this.driver,this);
    }
    
    public DesignStudioPage clickCash(){
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Cash Tab under Design Studio page");
    	
    	//Click on cash tab
    	click(cashTab, 5);
    	return this;
    }
   
   public DesignStudioPage selectAutopilot(){
	   ExtentTestManager.getTest().log(LogStatus.INFO, "Select Autopilot option");
	   
	   //Click on Autopilot checkbox
	   click(autoPilotCheckbox, 3);
	   return this;
   }
   
   public String getTotalCash(){
	   ExtentTestManager.getTest().log(LogStatus.INFO, "Get the value of total cash");
	   
	   //Get total cash and return the value without dollar and comma
	   return StringUtils.getOnlyIntegerFromString(readText(totalCash, 3));
   }
   
   public String getAutopilotFee(){
	   ExtentTestManager.getTest().log(LogStatus.INFO, "Get the value of auto pilot fee");
	   
	   //Get Auto Pilot Fee and return the value without dollar and comma
	   return StringUtils.getOnlyIntegerFromString(readText(autoPilotFee, 3));
   }

}
