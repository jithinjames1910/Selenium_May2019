package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test (priority = 0)
    public void invalidLoginTest_InvalidUserNameInvalidPassword () throws InterruptedException {
    	//*************PAGE INSTANTIATIONS*************
        //HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    	HomePage homePage = new HomePage(driver);
        LoginPage loginPage;

        //Chain of Invocation (Go to Login Page and then LoginToN11)
        homePage.goToN11();
        System.out.println("After goToN11");
        loginPage = homePage.goToLoginPage();
        System.out.println("After goToLoginPage");
        loginPage.loginToN11("onur@swtestacademy.com", "11223344");

        //*************ASSERTIONS***********************
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "E-posta adresiniz veya şifreniz hatalı");
    }

    @Test (priority = 1)
    public void invalidLoginTest_EmptyUserEmptyPassword () throws InterruptedException {
    	//*************PAGE INSTANTIATIONS*************
        //HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    	HomePage homePage = new HomePage(driver);
        LoginPage loginPage;

        //Chain of Invocation (Go to Login Page and then LoginToN11)
        homePage.goToN11();
        System.out.println("After goToN11");
        loginPage = homePage.goToLoginPage();
        System.out.println("After goToLoginPage");
        loginPage.loginToN11("", "");

        //*************ASSERTIONS***********************
        Assert.assertEquals(loginPage.getUserNameErrorMessage(), "Lütfen e-posta adresinizi girin.");
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Bu alanın doldurulması zorunludur.");
    }

}
