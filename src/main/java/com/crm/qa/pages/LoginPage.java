package com.crm.qa.pages;

import com.crm.qa.initialComponents.InitialSetups;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends InitialSetups {

    @FindBy(name = "username")
    WebElement UserNameTxtField;

    @FindBy(name = "password")
    WebElement PasswordTxtField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement LoginButton;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement SignUpButton;

    @FindBy(xpath = "//img[contains(@src,'https://classic.freecrm.com/img/logo.png')]")
    WebElement CrmproLogo;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateCrmLogo() {
        return CrmproLogo.isDisplayed();
    }

    public UserHomePage login(String userName, String password) {
        UserNameTxtField.sendKeys(userName);
        PasswordTxtField.sendKeys(password);
        LoginButton.click();
        return new UserHomePage();
    }

    public SignUpPage signUpButton() {
        SignUpButton.click();
        return new SignUpPage();
    }


}
