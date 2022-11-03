package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.initialComponents.InitialSetups;
import com.crm.qa.utilities.TestUtils;

public class UserHomePage extends InitialSetups {

	Actions action;
	TestUtils testUtils;

	@FindBy(xpath = "//td[contains(text(),'User: naayeem uddin')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsButton;
	
	@FindBy(xpath = "//a[@title= 'New Contact']")
	WebElement newContactsButton;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealButton;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskButton;

	public UserHomePage() {
		PageFactory.initElements(driver, this);
		
		action = new Actions(driver);
		testUtils = new TestUtils();
	}

	public String pageTitle() {
		return driver.getTitle();
	}

	public boolean getUserNamelabel() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickContactButton() {
		contactsButton.click();
		return new ContactsPage();
	}

	public void mouseOverOnContactsButton() {
		testUtils.switchToFrameCRM();
		action.moveToElement(contactsButton).build().perform();
	}
	
	public NewContactPage clickOnNewContactsButton() {
		newContactsButton.click();
		return new NewContactPage();
	}

	public ContactsPage clickDealsButton() {
		dealButton.click();
		return new DealPage();
	}

	public void mouseOverOnDealsButton() {

	}

	public ContactsPage clickTasksButton() {
		taskButton.click();
		return new TaskPage();
	}

	public void mouseOverOnTasksButton() {

	}

}
