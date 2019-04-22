package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//span[text()='priyanka Mehra']") WebElement userId;
	
	@FindBy(xpath ="//div[@class='header item']") WebElement homePageLogo;
	
	@FindBy(xpath="//span[text()='Deals']") WebElement deals;
	
	@FindBy(xpath="//span[text()='Contacts']") WebElement contacts;
	
	@FindBy(xpath="//span[text()='Tasks']")WebElement tasks;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ContactsPage clickOnContacts() {
		contacts.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals() {
		deals.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		tasks.click();
		return new TasksPage();
	}
	
	public Boolean validateUserId() {
		return userId.isDisplayed();
	}
	
	public Boolean validateLogoIsPresent() {
		return homePageLogo.isDisplayed();
	}
	
	public String verifyHomePageTitle() {
		 return driver.getTitle();
	}

}
