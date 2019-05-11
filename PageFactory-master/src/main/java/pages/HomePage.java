package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


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
        driver.get(baseURL);
    }

    //Go to LoginPage
    public LoginPage goToLoginPage (){
        click(signInButton, 3);
		//I want to chain LoginPage's methods so I return LoginPage by initializing its elements
        //return PageFactory.initElements(driver,LoginPage.class);
        return new LoginPage(driver);
    }
}