package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new  TestUtil();
		testUtil.switchToFrame();
		//contactsPage = homePage.clickOnContactsLink();
		
		//driver.switchTo().frame(0);
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
		}
	
	@Test(priority=2)
	public void selectContactsTextTest() {
		contactsPage.selectContactsByName();
		
	}
	
	@DataProvider 
	public Object[][] getCRMTestData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String tt, String ftname, String ltname, String comp) {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions . elementToBeClickable (By.xpath("//a[contains(text(), 'New Contact')]")));
		//wait.until(ExpectedConditions. invisibilityOfElementLocated(By.id("overlay element id")));
		
		homePage.clickOnNewContactLink();
		contactsPage = new ContactsPage();
		contactsPage.createNewContact(tt, ftname, ltname, comp);
		//contactsPage.createNewContact("Mr.", "Sachin", "Tendulkar", "Mumbai");
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
