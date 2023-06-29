package com.sauce.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.TestBase;
import com.sauce.qa.pages.CartPage;
import com.sauce.qa.pages.HomePage;
import com.sauce.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUP() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String expectedTitle="Swag Labs";
		String actualTitle=homePage.validateHomePageTitle();
		Assert.assertEquals(expectedTitle, actualTitle, "Home Page Title Didn't Matched");
	}
	
	@Test
	public void addingBackPackToCartTest() {
		homePage.addBackpack();
	}
	
	@Test
	public void addingBikeLightToCartTest() {
		homePage.addBikeLight();;
	}
	
	@Test
	public void goToCartTest() {
		cartPage=homePage.goToCart();	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
