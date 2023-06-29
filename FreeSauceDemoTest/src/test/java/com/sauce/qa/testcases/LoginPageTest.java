package com.sauce.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sauce.qa.base.TestBase;
import com.sauce.qa.pages.HomePage;
import com.sauce.qa.pages.LoginPage;
import com.sauce.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String expectedTitle="Swag Labs";
		String actuaTitle=loginPage.validateLoginPageTitle();
		Assert.assertEquals(actuaTitle, expectedTitle);
	}
	
	@Test(priority=2)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			TestUtil.takeScreenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
