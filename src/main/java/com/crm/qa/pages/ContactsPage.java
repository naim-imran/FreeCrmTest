package com.crm.qa.pages;

import com.crm.qa.initialComponents.InitialSetups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends InitialSetups {

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactsLabel;

    public ContactsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyContactsLabel() {
        return contactsLabel.isDisplayed();
    }

    public void selectContactCheckBox(String name) {
        driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox']")).click();
    }

}
