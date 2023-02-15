package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath = "//td[contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//select[@name='title']")
	WebElement titleDropDown;
	
	@FindBy(name = "first_name")
	WebElement first_name;
	
	@FindBy(name = "surname")
	WebElement sur_name;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@value='Load From Company']//following-sibling::input[1]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'New Contact')]")
	WebElement newContactLink;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName() {
		driver.findElement(By.xpath("//strong[contains(text(),'Name')]//parent::td//preceding-sibling::td//input")).click();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	public void createNewContact(String tt, String ftname, String ltname, String comp) {
		Select title = new Select(titleDropDown);
		title.selectByValue(tt);
		
		first_name.sendKeys(ftname);
		sur_name.sendKeys(ltname);
		company.sendKeys(comp);
		saveBtn.click();
	}
}


