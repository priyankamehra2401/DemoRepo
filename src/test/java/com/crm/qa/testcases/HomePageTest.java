package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Login;

public class HomePageTest extends TestBase {
	public Login loginPage;
	public HomePage homePage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		loginPage = new Login();
		homePage=loginPage.enterCredentials(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test (priority=1)
	public void verifyTitleOfHomePageTest() {
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title,"CRM","The HomePageTitle is incorrect");	
	}

	@Test(priority=2)
	public void verifyUserIDTest() {
		Assert.assertTrue(homePage.validateUserId(),"UserId is not displayed");
	}

	@Test(priority=3)
	public ContactsPage clickOnContactslinkTest() {
		homePage.clickOnContacts();
		return new ContactsPage();
	}

//	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
