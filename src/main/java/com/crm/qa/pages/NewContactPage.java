package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.initialComponents.InitialSetups;

public class NewContactPage extends InitialSetups {
	
	@FindBy(xpath="//legend[text()='Contact Information']")
	WebElement contactInformationLabel;
	
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyNewContactPage() {
		return contactInformationLabel.isDisplayed();
	}

}


