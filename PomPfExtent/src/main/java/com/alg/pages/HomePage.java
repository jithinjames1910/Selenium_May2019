package com.alg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.alg.reportutils.extentreport.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends BasePage {

	//*********Web Elements By Using Page Factory*********
    @FindBy(how = How.CLASS_NAME, using = "btnSignIn")
    public WebElement signInButton;
    
    //*********Constructor*********
    public HomePage (WebDriver driver) {
        //super(driver);
    	this.driver = driver;
    	PageFactory.initElements(this.driver,this);
    }

    //*********Page Variables*********
    String baseURL = "http://www.n11.com/";

    //*********Page Methods*********
    //Go to Homepage
    public void goToN11 (){
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to N11 Page");
        driver.get(baseURL);
    }

    //Go to LoginPage
    public LoginPage goToLoginPage (){
    	ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Login Page");
        click(signInButton, 3);
		//I want to chain LoginPage's methods so I return LoginPage by initializing its elements
        //return PageFactory.initElements(driver,LoginPage.class);
        return new LoginPage(driver);
    }
}