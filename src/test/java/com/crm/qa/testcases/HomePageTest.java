package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new  TestUtil();
		//driver.switchTo().frame(0);
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO", "Home page title is not matched");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest() {
		testUtil.switchToFrame();
		boolean flag = homePage.verifyCorrectUsername();
		Assert.assertTrue(flag);
	}
	
	@Test()
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
