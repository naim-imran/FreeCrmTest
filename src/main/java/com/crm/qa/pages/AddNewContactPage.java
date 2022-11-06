package com.crm.qa.pages;

import com.crm.qa.initialComponents.InitialSetups;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewContactPage extends InitialSetups {

    @FindBy(xpath = "//legend[text()='Contact Information']")
    WebElement contactInformationLabel;

    @FindBy(xpath = "//select[@name='title']")
    WebElement titleDropDown;

    @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstNameTxtBox;

    @FindBy(xpath = "//input[@name='surname']")
    WebElement lastNameTxtBox;

    @FindBy(xpath = "//input[@value='Save and Create Another (same company)']//preceding-sibling::input[@type='submit']")
    WebElement saveButton;


    public AddNewContactPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyNewContactPage() {
        return contactInformationLabel.isDisplayed();
    }

    public void selectTitle(String title) {
        Select select = new Select(titleDropDown);
        select.selectByVisibleText(title);
    }

    public void firstName(String firstName) {
        firstNameTxtBox.sendKeys(firstName);
    }

    public void lastName(String lastName) {
        lastNameTxtBox.sendKeys(lastName);
    }

    public ContactDetailsPage saveButton() {
        saveButton.click();
        return new ContactDetailsPage();
    }

}
