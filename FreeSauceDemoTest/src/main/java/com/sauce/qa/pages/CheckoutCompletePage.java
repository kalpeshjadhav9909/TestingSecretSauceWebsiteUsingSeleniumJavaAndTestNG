package com.sauce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.base.TestBase;

public class CheckoutCompletePage extends TestBase{
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	WebElement message;
	
	@FindBy(name="back-to-products")
	WebElement backToProducts;
	
	public CheckoutCompletePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySuccessMessage() {
		return message.getText();
	}
	
	public HomePage backToHome(){
		backToProducts.click();
		return new HomePage();
	}

}
