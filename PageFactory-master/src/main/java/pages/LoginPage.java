package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	//*********Web Elements by using Page Factory*********
    @FindBy(how = How.ID, using = "email")
    public WebElement username;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    @FindBy(how = How.ID, using = "loginButton")
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[1]/div/div")
    public WebElement errorMessageUsername;

    @FindBy(how = How.XPATH, using = "//*[@id=\"loginForm\"]/div[2]/div/div")
    public WebElement errorMessagePassword;
    
    //*********Constructor*********
    public LoginPage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(this.driver,this);
    }


    //*********Page Methods*********
    public void loginToN11 (String pusername, String ppassword){
        //Enter Username(Email)
        writeText(username,pusername, 5);
        //Enter Password
        writeText(password, ppassword, 2);
        //Click Login Button
        click(loginButton, 2);
    }

    //Verify Username Condition
    public String getUserNameErrorMessage () {
    	return readText(errorMessageUsername, 4);
    }

    //Verify Password Condition
    public String getPasswordErrorMessage () {
        return readText(errorMessagePassword, 4);
    }
}
