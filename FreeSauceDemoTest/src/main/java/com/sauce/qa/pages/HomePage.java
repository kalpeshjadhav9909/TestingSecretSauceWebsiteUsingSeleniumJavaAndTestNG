package com.sauce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(name="add-to-cart-sauce-labs-backpack")
	WebElement addBackpack;

	@FindBy(name="add-to-cart-sauce-labs-bike-light")
	WebElement addBikeLight;

	@FindBy(id="shopping_cart_container")
	WebElement goToCart;
		
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public void addBackpack() {
		addBackpack.click();
	}
	public void addBikeLight() {
		addBikeLight.click();
	}
	public CartPage goToCart() {
		goToCart.click();
		return new CartPage();
	}

}
