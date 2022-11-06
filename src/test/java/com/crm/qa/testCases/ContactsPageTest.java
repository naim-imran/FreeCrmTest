package com.crm.qa.testCases;

import com.crm.qa.initialComponents.InitialSetups;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.UserHomePage;
import com.crm.qa.utilities.TestUtils;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends InitialSetups {
    LoginPage logInPage;
    TestUtils testUtils;
    UserHomePage userHomePage;
    ContactsPage contactPage;

    public ContactsPageTest() {
        super();
    }

    @BeforeMethod
    public void setupCom() {
        initializeBrowser();
        logInPage = new LoginPage();
        testUtils = new TestUtils();
        userHomePage = logInPage.login(prop.getProperty("userName"), prop.getProperty("password"));
        testUtils.switchToFrameCRM();
        contactPage = userHomePage.clickContactButton();
    }

    @Test(priority = 1)
    public void verifyContactsPageTest() {
        AssertJUnit.assertTrue(contactPage.verifyContactsLabel());
    }

    @Test(priority = 2)
    public void selectContactCheckBoxTest() {
        contactPage.selectContactCheckBox("test crm");

    }

    @Test(priority = 3)
    public void selectMultipleContactCheckBoxTest() {
        contactPage.selectContactCheckBox("test crm");
        contactPage.selectContactCheckBox("j john");
    }


    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

}
