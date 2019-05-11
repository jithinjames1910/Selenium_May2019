package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test (priority = 0, description="Validate the error message when user enters incorrect password")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () {

        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage;

        //*************PAGE METHODS********************
        homePage.goToN11();
        loginPage = homePage.goToLoginPage();
        loginPage.loginToN11("onur@swtestacademy.com", "11223344");
        //Assert.assertEquals(loginPage.getUserNameErrorMessage(), "E-posta adresiniz veya şifreniz hatalı");
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "E-posta adresiniz veya şifreniz hatalı");
    }

    @Test (priority = 1, description="Validate the username and password error message when user does not enters userid and password")
    public void invalidLoginTest_EmptyUserEmptyPassword () {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage;

        //*************PAGE METHODS********************
        homePage.goToN11();
        loginPage = homePage.goToLoginPage();
        loginPage.loginToN11("", "");
        Assert.assertEquals(loginPage.getUserNameErrorMessage(), "Lütfen e-posta adresinizi girin.");
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Bu alanın doldurulması zorunludur.");
    }
}