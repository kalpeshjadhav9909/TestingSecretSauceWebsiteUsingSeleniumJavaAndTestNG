package com.sauce.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.TestBase;
import com.sauce.qa.pages.CartPage;
import com.sauce.qa.pages.CheckoutOverviewPage;
import com.sauce.qa.pages.CheckoutPage;
import com.sauce.qa.pages.HomePage;
import com.sauce.qa.pages.LoginPage;

public class CheckoutPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	CheckoutOverviewPage checkoutOverviewPage;
	
	public CheckoutPageTest() {
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
		cartPage.removeBackpack();
		checkoutPage=cartPage.clickCheckout();
	}
	
	@Test
	public void checkoutTest() {
		checkoutPage.typeFirstName();
	
		checkoutPage.typeLastName();
	
		checkoutPage.typeZipCode();;
	
		checkoutOverviewPage=checkoutPage.submit();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
