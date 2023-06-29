package com.sauce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(name="remove-sauce-labs-backpack")
	WebElement removeBackpack;
	
	@FindBy(name="checkout")
	WebElement checkout;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void removeBackpack() {
		removeBackpack.click();
	}
	
	public CheckoutPage clickCheckout() {
		checkout.click();
		return new CheckoutPage();
	}
	
}
