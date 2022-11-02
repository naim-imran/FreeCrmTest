package com.crm.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.initialComponents.InitialSetups;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.UserHomePage;

public class LogInPageTest extends InitialSetups {
	
	LoginPage logInPage;
	UserHomePage userHomePage;

	public LogInPageTest() {
		super();
	}

	@BeforeMethod
	public void launchBrowser() {
		initializeBrowser();
		logInPage = new LoginPage();
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

	@Test(priority = 1)
	public void validateTitleTest() {
		String LoginPageTitle = logInPage.validateLoginPageTitle();
		Assert.assertEquals(LoginPageTitle,
				"Free CRM - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void crmLogoTest() {
		boolean flag = logInPage.validateCrmLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		userHomePage = logInPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	}

}
