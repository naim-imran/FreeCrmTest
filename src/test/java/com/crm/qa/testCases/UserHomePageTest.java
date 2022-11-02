package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.initialComponents.InitialSetups;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.UserHomePage;
import com.crm.qa.utilities.TestUtils;

public class UserHomePageTest extends InitialSetups {
	LoginPage logInPage;
	UserHomePage userHomePage;
	TestUtils testUtils;

	public UserHomePageTest() {
		super();
	}

	@BeforeMethod
	public void launchBrowser() {
		initializeBrowser();
		logInPage = new LoginPage();
		testUtils = new TestUtils();
		userHomePage = logInPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void verifyUserHomePageTitleTest() {
		String UserHomePageTitle = userHomePage.pageTitle();
		Assert.assertEquals(UserHomePageTitle, "CRMPRO", "UserHomePageTitle didnt match");
	}

	@Test(priority = 2)
	public void verifyUserNameLabel() {
		testUtils.switchToFrameCRM();
		Assert.assertTrue(userHomePage.getUserNamelabel());
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

}
