package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Login;
import com.crm.qa.utilities.Utilities;

public class ContactsPageTest extends TestBase{
	public Login loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	public Utilities utils;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		loginPage = new Login();
		utils= new Utilities();
		homePage =new HomePage();
		homePage=loginPage.enterCredentials(prop.getProperty("username"),prop.getProperty("password"));
		homePage.clickOnDeals();
		contactsPage=homePage.clickOnContacts();
		// note here no need to create obj of homepage n contactspage,
		//by chaining u can call.
	}

	//@Test (priority=1)
	public void clickOnCheckBoxTest() throws InterruptedException {
	//	utils.switchToFrame();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(contactsPage.checkBoxesToClickOn("yht ytjtt")));
		contactsPage.clickOnCheckBox("yht ytjtt");			
	}
	
	@DataProvider
	public Object [][] getCRMTestData() {
		Object data[][]= utils.getTestData("Contacts");
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void createNewContactTest(String firstName,String lastName,String company,String email ) throws InterruptedException {
	//	contactsPage.createNewContact("Amit", "Sahu", "Rolex", "amit.sahu@rolex.com.au");
		contactsPage.createNewContact(firstName, lastName, company, email);
		Thread.sleep(3000);
		
		homePage.clickOnContacts();
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
