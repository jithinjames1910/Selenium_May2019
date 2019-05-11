package com.tesla.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tesla.pages.CarbonImpactPage;
import com.tesla.pages.DesignStudioPage;
import com.tesla.pages.HomePage;
import com.tesla.pages.MenuPage;
import com.tesla.pages.ModelSPage;
import com.tesla.reportutils.extentreports.ExtentTestManager;

public class RubikloudAssessmentTests extends BaseTest{
	
	@Test (priority = 1)
    public void checkAutopilotFeeInTotalCash() throws InterruptedException {
		ExtentTestManager.getTest().setDescription("Validate if total cash is updated as per autopilot fee when autopilot option is selected");
		String totalCashWithoutAP = "";
		String autoPilotFee = "";
		String expectedTotalCashWithAP = "";
		String actualTotalCashWithAP = "";
    	
    	//*************PAGE INSTANTIATIONS*************
    	HomePage homePage = new HomePage(driver);
        ModelSPage modelSPage;
        DesignStudioPage designStudioPage;

        //Go to tesla home page
        homePage.goToHomePage();
        //Clic on Model S
        modelSPage = homePage.clickModelS();
        //Click on order now of Model S
        designStudioPage = modelSPage.clickOrderNow();
        //Click on Cash Tab in Design Studio page
        designStudioPage.clickCash();
        //Get total cash of Model S without AP
        totalCashWithoutAP = designStudioPage.getTotalCash();
        //Get autopilot fee
        autoPilotFee = designStudioPage.getAutopilotFee();
        //Calculate expected total cash with AP
        try{
        	expectedTotalCashWithAP = Integer.parseInt(totalCashWithoutAP) + Integer.parseInt(autoPilotFee) + ""; 
        }catch(Exception e){
        	ExtentTestManager.getTest().log(LogStatus.ERROR, "Error while adding 'totalCashWithoutAP' and 'autoPilotFee' | Exception Desc: " + e.getMessage());
        	assert false;
        }
        //Select Autopilot option
        designStudioPage.selectAutopilot();
        //Get actual total cash with AP
        actualTotalCashWithAP =  designStudioPage.getTotalCash();

        //*************ASSERTIONS***********************
        ExtentTestManager.getTest().log(LogStatus.INFO, "Checking if 'Total cash with AP (" + actualTotalCashWithAP + ")' is equal to 'Total Cash without AP (" + totalCashWithoutAP + ")' plus 'Autopilot Fee (" + autoPilotFee + ")'");
        Assert.assertEquals(actualTotalCashWithAP, expectedTotalCashWithAP, "Expected 'Total cash with AP' - " + expectedTotalCashWithAP + " but found - " + actualTotalCashWithAP + ". | ");
    }
	
	@Test (priority = 2)
    public void checkCarbonImpactCanada() throws InterruptedException {
		ExtentTestManager.getTest().setDescription("Validate if carbon impact of Canada is 5th in the list");
    	Map<Integer, String> carbonSaverMap = new HashMap<Integer, String>();
    	
    	//*************PAGE INSTANTIATIONS*************
    	HomePage homePage = new HomePage(driver);
    	MenuPage menuPage;
    	CarbonImpactPage carbonImpactPage;
    	
        //Go to tesla home page
        homePage.goToHomePage();
        //Click on Menu
        menuPage = homePage.clickMenu();
        //Click on Carbon Impact under Menu
        carbonImpactPage = menuPage.clickCarbonImpact();
        //Click on World Tab in Carbon Impact page
        carbonImpactPage.clickWorldTab();
        //Get all carbon saver list
        carbonSaverMap = carbonImpactPage.getWorldCarbonSaverList();

        //*************ASSERTIONS***********************
        ExtentTestManager.getTest().log(LogStatus.INFO, "Checking if Canada is the 5th carbon saver in World Tab");
        Assert.assertEquals(carbonSaverMap.get(5), "Canada", "Expected 'Canada' to be 5th saver but found " + carbonSaverMap.get(5));
    }

}
