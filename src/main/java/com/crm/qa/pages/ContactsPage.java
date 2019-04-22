package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[text()='Contacts']")WebElement contactsHeading;
	
	@FindBy(xpath="//button[text()='New']")WebElement newBtn;
	
	@FindBy(name="first_name")WebElement firstName;
	
	@FindBy(name="last_name")WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']/input")WebElement company;
	
	@FindBy(xpath="//label[text()='Email']/following::input[@name='value'][1]")WebElement email;
	
	@FindBy(xpath="//button[text()='Save']")WebElement save;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement checkBoxesToClickOn(String name) {
	//	return driver.findElement(By.xpath("//td[text()='"+name+"']/"
	//			+ "preceding::input[@type='checkbox'][1]"));
		
		 return driver.findElement(By.xpath("//td[text()='"+name+"']/"
		+ "preceding::div[1]"));
	}
	
	// ********* End of WebElements ***********
	
	
	public void verifyContactHeading() {
		contactsHeading.isDisplayed();
	}
	
	public void clickOnCheckBox(String name) {
		checkBoxesToClickOn(name).click();		
	}
	
	public void clickOnNewContacts( ) {
		newBtn.click();
	}
	
	public void enterFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void enterCompany(String company) {
		this.company.sendKeys(company);
	}
	
	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void clickOnSave() {
		save.click();
	}
	
	public void createNewContact(String firstName,String lastName,String company,String email) {
		clickOnNewContacts();
		enterFirstName(firstName);
		enterLastName(lastName);
		enterCompany(company);
		enterEmail(email);
		clickOnSave();	
	}
	
}
