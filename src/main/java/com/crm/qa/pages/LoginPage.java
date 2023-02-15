package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//PageFactory or OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement SignUpBtn;
	
	@FindBy(xpath = "//img[@class='img-responsive' and @src='https://classic.freecrm.com/img/logo@2x.png']")
	WebElement crmLogo;
	
	//Initializing the Page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return new HomePage();
	}
	
}

