package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.Login;

public class LoginPageTest extends TestBase{
	public Login loginPage;
	public HomePage homePage;

	LoginPageTest(){
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		loginPage = new Login();
	}

	@Test (priority =1)
	public void validateLoginPageTitleTest() {
		String title=loginPage.getPageTitle();	
		Assert.assertEquals(title, "CRM","The title is incorrect");
		System.out.println("title is " + title);
	}

	@Test (priority =2)
	public void login() {
		homePage=loginPage.enterCredentials(prop.getProperty("username"),prop.getProperty("password"));
	}

//	@AfterMethod
	public void tearDown() {
		driver.quit();		
	}

}
