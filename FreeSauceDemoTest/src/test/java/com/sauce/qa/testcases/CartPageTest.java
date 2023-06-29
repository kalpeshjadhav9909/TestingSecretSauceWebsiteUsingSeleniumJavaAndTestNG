package com.sauce.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.TestBase;
import com.sauce.qa.pages.CartPage;
import com.sauce.qa.pages.CheckoutPage;
import com.sauce.qa.pages.HomePage;
import com.sauce.qa.pages.LoginPage;

public class CartPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	
	public CartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.addBackpack();
		homePage.addBikeLight();
		cartPage=homePage.goToCart();
		
	}
	
	@Test
	public void removeBackpack() {
		
		cartPage.removeBackpack();
		
	}
	
	@Test
	public void clickCheckoutTest() {
		checkoutPage=cartPage.clickCheckout();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
