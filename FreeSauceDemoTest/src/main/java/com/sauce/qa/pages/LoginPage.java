package com.sauce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauce.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="user-name")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='submit-button btn_action']")
	WebElement loginBtn;
	
	//Constructor to Initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();		
	}
	
	public HomePage login(String un,String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		loginBtn.click();
		return new HomePage();
	}

}
