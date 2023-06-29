package com.sauce.qa.testcases;

import java.io.IOException;

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
import com.sauce.qa.util.TestUtil;

public class CheckoutCompletePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	CheckoutOverviewPage checkoutOverviewPage;
	CheckoutCompletePage checkoutCompletePage;
	
	public CheckoutCompletePageTest() {
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
		checkoutPage.typeFirstName();
		checkoutPage.typeLastName();
		checkoutPage.typeZipCode();
		checkoutOverviewPage=checkoutPage.submit();
		checkoutCompletePage=checkoutOverviewPage.clickFinish();
	}
	
	@Test
	public void verifySuccessMessage() {
		String actualMessage=checkoutCompletePage.verifySuccessMessage();
		String expectedMessage="Thank you for your order!";
		Assert.assertEquals(actualMessage, expectedMessage, "Message didn't Matched");
		try {
			TestUtil.takeScreenShot("Order_Placed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkoutCompletePage.backToHome();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
