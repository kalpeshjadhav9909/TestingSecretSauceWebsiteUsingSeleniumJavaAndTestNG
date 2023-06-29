package com.sauce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.base.TestBase;

public class CheckoutPage extends TestBase{
	
	@FindBy(xpath="//input[contains(@id,'first-name')]")
	WebElement firstName;
	
	@FindBy(xpath="//input[contains(@id,'last-name')]")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement zipcode;

	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;

	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void typeFirstName() {
		firstName.sendKeys(prop.getProperty("firstname"));
	}

	public void typeLastName() {
		lastName.sendKeys(prop.getProperty("lastname"));
	}
	
	public void typeZipCode() {
		zipcode.sendKeys(prop.getProperty("zipcode"));
	}

	public CheckoutOverviewPage submit() {
		submit.click();
		return new CheckoutOverviewPage();
	}
	
}