package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.initialComponents.InitialSetups;
import com.crm.qa.pages.AddNewContactPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.UserHomePage;
import com.crm.qa.utilities.TestUtils;

public class AddNewContactPageTest extends InitialSetups {
	AddNewContactPage addNewContactPage;
	LoginPage loginPage;
	UserHomePage userHomePage;
	TestUtils testUtils;
	public AddNewContactPageTest() {
		super();
	}

	@BeforeMethod
	public void initialSetups() {
		initializeBrowser();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		userHomePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		userHomePage.mouseOverOnContactsButton();
		addNewContactPage = userHomePage.clickOnNewContactButton();
	}

	@Test(priority=1)
	public void validateAddNewContactPageTitle() {
		Assert.assertTrue(addNewContactPage.verifyNewContactPage());
	}
	
	@Test(priority=2, dataProvider = "getCRMTestData")
	public void addNewContactTest(String title, String FirstName, String lastName) {
		addNewContactPage.selectTitle(title);
		addNewContactPage.firstName(FirstName);
		addNewContactPage.lastName(lastName);
		addNewContactPage.saveButton();
	}
	
	@DataProvider 
	public Object[][] getCRMTestData() {
		return testUtils.getTestData("Sheet4", "/src/main/java/com/crm/qa/testData/crmTestData.xlsx");
	}
	
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
	

}
