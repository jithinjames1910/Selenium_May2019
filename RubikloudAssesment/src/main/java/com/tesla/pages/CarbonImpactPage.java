package com.tesla.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.tesla.reportutils.extentreports.ExtentTestManager;

public class CarbonImpactPage extends BasePage{
	
	//*********Web Elements By Using Page Factory*********
    @FindBy(how = How.XPATH, using = "//div[@id='root']/div/section/section[3]/section/ul/li[2]")
    private WebElement worldTab;
    
    @FindBys( {
	   @FindBy(xpath = "//div[@id='root']/div/section/section[3]/section[3]/section[2]/div/span[2]/span")
	} )
	private List<WebElement> carbonSaverList;
    
    //*********Constructor*********
    public CarbonImpactPage (WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(this.driver,this);
    }
    
    public CarbonImpactPage clickWorldTab(){
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Click on World tab in Carbon Impact page");
    	click(worldTab, 5);
    	return this;
    }
    
    public Map<Integer, String> getWorldCarbonSaverList(){
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Reading all the carbon savers from World Tab");
    	Map<Integer, String> carbonSaverMap = new HashMap<Integer, String>();
    	int i=0;
    
    	waitForVisibilityOfAll(carbonSaverList, 5);
    	for(WebElement element:carbonSaverList){
    		i=i+1;
    		carbonSaverMap.put(i, readText(element, 1));
    	}
    	
    	return carbonSaverMap;
    }
}
