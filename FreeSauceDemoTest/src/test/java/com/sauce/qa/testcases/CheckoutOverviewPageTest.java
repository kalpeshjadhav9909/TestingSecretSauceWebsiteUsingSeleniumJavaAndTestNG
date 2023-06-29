package com.sauce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.TestBase;
import com.sauce.qa.pages.CartPage;
import com.sauce.qa.pages.CheckoutCompletePage;
import com.sauce.qa.pages.CheckoutOverviewPage;
import com.sauce.qa.pages.CheckoutPage;
import com.sauce.qa.pages.HomePage;
import com.sauce.qa.pages.LoginPage;

public class CheckoutOverviewPageTest extends TestBase{
	
		LoginPage loginPage;
		HomePage homePage;
		CartPage cartPage;
		CheckoutPage checkoutPage;
		CheckoutOverviewPage checkoutOverviewPage;
		CheckoutCompletePage checkoutCompletePage;
		
		public CheckoutOverviewPageTest() {
			super();
		}
		
		@BeforeMethod
		public void setup() {
			initialization();
			loginPage=new LoginPage();
			homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			homePage.addBackpack();
			homePage.addBikeLight();
			cartPage=homePage.goToCart();
			cartPage.removeBackpack();
			checkoutPage=cartPage.clickCheckout();
			checkoutPage.typeFirstName();
			checkoutPage.typeLastName();
			checkoutPage.typeZipCode();
			checkoutOverviewPage=checkoutPage.submit();
		}
		
		@Test
		public void verifyItemNameTest() {
			String actualName=checkoutOverviewPage.getItemName();
			String expectedName="Sauce Labs Bike Light";
			Assert.assertEquals(actualName, expectedName,"Item Name Didn't Matched");
		}
		
		@Test
		public void clickFinishTest() {
			checkoutCompletePage=checkoutOverviewPage.clickFinish();
		}
		
		@AfterMethod
		public void tearDown() {
			driver.close();
		}

}
